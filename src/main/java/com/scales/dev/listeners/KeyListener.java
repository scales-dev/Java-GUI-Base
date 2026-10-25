package com.scales.dev.listeners;

import com.scales.dev.window.Canvas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends Listener {
  public KeyListener(Canvas canvas) {
    super(canvas);

    canvas.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent keyEvent) {
        Listener.fire(Type.KEY_PRESS, keyEvent, true);
      }

      @Override
      public void keyReleased(KeyEvent keyEvent) {
        Listener.fire(Type.KEY_PRESS, keyEvent, false);
      }
    });
  }
}
