package com.scales.dev.listeners;

import com.scales.dev.window.Canvas;

import java.lang.reflect.Method;
import java.util.LinkedList;

public class Listener {
  private static final LinkedList<Canvas> LISTENERS = new LinkedList<>();

  public Listener(Canvas canvas) {
  }

  public static void registerClass(Canvas canvas) {
    LISTENERS.add(canvas);

    for (Method method : canvas.getClass().getDeclaredMethods()) {
      RegisterListener listener = method.getAnnotation(RegisterListener.class);
      if (listener == null) continue;

      canvas.LISTENERS.put(listener.type(), method);
      listener.type().register(canvas);
    }
  }

  public static void unregisterClass(Canvas canvas) {
    LISTENERS.remove(canvas);
  }

  public static void fire(Type type, Object... args) {
    Canvas[] listeners = LISTENERS.toArray(Canvas[]::new);
    for (int i = listeners.length - 1; i >= 0; i--) {
      Canvas canvas = listeners[i];

      Method method = canvas.LISTENERS.get(type);
      if (method == null) continue;

      try {
        // the event can be CONSUMED stopping children from playing with it
        if ((boolean) method.invoke(canvas, args)) break;
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    }
  }

  public enum Type {
    MOUSE_PRESS {
      @Override
      public void register(Canvas canvas) {
        new MousePressListener(canvas);
      }
    },

    MOUSE_DRAG {
      @Override
      public void register(Canvas canvas) {
        new MouseMotionListener(canvas);
      }
    },

    KEY_PRESS {
      @Override
      public void register(Canvas canvas) {
        new KeyListener(canvas);
      }
    },

    TICK {
      @Override
      public void register(Canvas canvas) {
        new TickListener(canvas);
      }
    };

    public abstract void register(Canvas canvas);
  }
}