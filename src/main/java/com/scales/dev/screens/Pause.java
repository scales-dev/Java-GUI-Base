package com.scales.dev.screens;

import com.scales.dev.listeners.Listener;
import com.scales.dev.listeners.RegisterListener;
import com.scales.dev.window.Canvas;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Pause extends Canvas {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(new Color(0, 0, 0, 100));
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
  }

  @RegisterListener(type = Listener.Type.MOUSE_PRESS)
  public boolean onMousePress(MouseEvent e, boolean isPressed) {
    return true;
  }

  @RegisterListener(type = Listener.Type.KEY_PRESS)
  public boolean onKeyPress(KeyEvent e, boolean isPressed) {
    if (!isPressed || e.getKeyCode() != KeyEvent.VK_ESCAPE) return true;

    this.getParentFrame().removeCanvas(this);

    return true;
  }
}
