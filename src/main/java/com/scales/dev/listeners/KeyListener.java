package com.scales.dev.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
  @Override
  public void keyPressed(KeyEvent e) {
    Listener.fire(Listener.Type.KEY_PRESS, e);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    Listener.fire(Listener.Type.KEY_RELEASE, e);
  }
}
