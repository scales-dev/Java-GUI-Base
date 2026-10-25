package com.scales.dev;

import com.scales.dev.listeners.Listener;
import com.scales.dev.listeners.RegisterListener;
import com.scales.dev.window.Canvas;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Example extends Canvas {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.RED);

    int size = this.getWidth() - 50;
    int x = (int) (Math.abs(((System.currentTimeMillis() / 5) % size * 2) - size));
    int y = (int) (Math.abs(((System.currentTimeMillis() / 3) % size * 2) - size));
    g.fillRect(x, y, 50, 50);
  }

  @RegisterListener(type = Listener.Type.TICK)
  public void onTick() {
    this.repaint();
  }

  @RegisterListener(type = Listener.Type.KEY_PRESS)
  public void onKeyPress(KeyEvent e) {
    this.repaint();
  }
}
