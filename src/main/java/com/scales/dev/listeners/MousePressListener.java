package com.scales.dev.listeners;

import com.scales.dev.window.Canvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MousePressListener extends Listener {
  public MousePressListener(Canvas canvas) {
    super(canvas);

    canvas.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        Listener.fire(Listener.Type.MOUSE_PRESS, mouseEvent, true);
      }

      @Override
      public void mouseReleased(MouseEvent mouseEvent) {
        Listener.fire(Listener.Type.MOUSE_PRESS, mouseEvent, false);
      }
    });
  }
}