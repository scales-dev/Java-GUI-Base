package com.scales.dev.listeners;

import com.scales.dev.window.Frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends Listener {
  public MouseListener(Frame frame) {
    super(frame);

    frame.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Listener.fire(Listener.Type.MOUSE_PRESS, e);
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        Listener.fire(Listener.Type.MOUSE_RELEASE, e);
      }
    });
  }
}