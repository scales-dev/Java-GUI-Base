package com.scales.dev.listeners;

import com.scales.dev.window.Canvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMotionListener extends Listener {
  public MouseMotionListener(Canvas canvas) {
    super(canvas);

    // todo: this event only applies if MOUSE_PRESSED isnt consumed by an above layer...?
    canvas.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent mouseEvent) {
        Listener.fire(Type.MOUSE_DRAG, mouseEvent, true);
      }

      @Override
      public void mouseMoved(MouseEvent mouseEvent) {
        Listener.fire(Type.MOUSE_DRAG, mouseEvent, false);
      }
    });
  }
}