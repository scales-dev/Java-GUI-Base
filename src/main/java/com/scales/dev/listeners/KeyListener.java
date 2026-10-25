package com.scales.dev.listeners;

import com.scales.dev.window.Frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends Listener {
  public KeyListener(Frame frame) {
    super(frame);

    frame.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        Listener.fire(Listener.Type.KEY_PRESS, e);
      }

      @Override
      public void keyReleased(KeyEvent e) {
        Listener.fire(Listener.Type.KEY_RELEASE, e);
      }
    });
  }
}
