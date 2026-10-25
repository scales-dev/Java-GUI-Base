package com.scales.dev.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
  @Override
  public void mousePressed(MouseEvent e) {
    Listener.fire(Listener.Type.MOUSE_PRESS, e);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    Listener.fire(Listener.Type.MOUSE_RELEASE, e);
  }
}