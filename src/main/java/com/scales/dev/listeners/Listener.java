package com.scales.dev.listeners;

import com.scales.dev.window.Frame;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class Listener {
  private static final HashMap<Type, ArrayList<CallableMethod>> LISTENERS = new HashMap<>();

  public record CallableMethod(Method method, Object instance) {
  }

  public Listener(Frame frame) {
  }

  public static void registerListeners(Frame frame) {
    new KeyListener(frame);
    new MouseListener(frame);
    new TickListener(frame);
  }

  public static void registerClass(Object canvas) {
    for (Method method : canvas.getClass().getDeclaredMethods()) {
      RegisterListener listener = method.getAnnotation(RegisterListener.class);
      if (listener == null) continue;

      Listener.register(listener.type(), new CallableMethod(method, canvas));
    }
  }

  public static void unregisterClass(Object canvas) {
    for (Method method : canvas.getClass().getDeclaredMethods()) {
      RegisterListener listener = method.getAnnotation(RegisterListener.class);
      if (listener == null) continue;

      Listener.unregister(listener.type(), new CallableMethod(method, canvas));
    }
  }

  public static void register(Type type, CallableMethod method) {
    LISTENERS.computeIfAbsent(type, k -> new ArrayList<>());
    LISTENERS.get(type).add(method);
  }

  public static void unregister(Type type, CallableMethod method) {
    ArrayList<CallableMethod> methods = LISTENERS.get(type);
    if (methods == null) return;

    methods.remove(method);
    if (methods.isEmpty()) {
      LISTENERS.remove(type);
    }
  }

  public static void fire(Type type, Object... args) {
    ArrayList<CallableMethod> methods = LISTENERS.get(type);
    if (methods == null) return;

    try {
      for (CallableMethod callableMethod : methods) {
        callableMethod.method.invoke(callableMethod.instance, args);
      }
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public enum Type {
    MOUSE_PRESS,
    MOUSE_RELEASE,

    KEY_PRESS,
    KEY_RELEASE,

    TICK
  }
}