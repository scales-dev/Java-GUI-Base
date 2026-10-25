package com.scales.dev.screens;

import com.scales.dev.Main;
import com.scales.dev.listeners.Listener;
import com.scales.dev.listeners.RegisterListener;
import com.scales.dev.window.Canvas;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Game extends Canvas {
  private final BufferedImage image;
  private final Graphics2D g;

  public Game() {
    super();

    this.image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
    this.g = this.image.createGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, this.image.getWidth(), this.image.getHeight());
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.drawImage(this.image, 0, 0, this);
  }

  @RegisterListener(type = Listener.Type.MOUSE_PRESS)
  public boolean onMousePress(MouseEvent e, boolean isPressed) {
    if (!isPressed) return false;

    g.setColor(Color.RED);
    g.setStroke(new BasicStroke(10));
    g.fillOval(e.getX(), e.getY(), 10, 10);

    this.repaint();

    return true;
  }

  private Point lastPoint;

  @RegisterListener(type = Listener.Type.MOUSE_DRAG)
  public boolean onMouseDrag(MouseEvent e, boolean isPressed) {
    if (!isPressed) {
      lastPoint = e.getPoint();
      return false;
    }

    g.setColor(Color.RED);

    int dx = e.getX() - lastPoint.x;
    int dy = e.getY() - lastPoint.y;
    int d = Math.abs(dx) + Math.abs(dy);
    for (int i = 0; i < d; i++) {
      float ratio = (float) i / d;
      g.fillOval((int) (e.getX() - (dx * ratio)), (int) (e.getY() - (dy * ratio)), 10, 10);
    }
    lastPoint = e.getPoint();

    this.repaint();

    return true;
  }

  @RegisterListener(type = Listener.Type.KEY_PRESS)
  public boolean onKeyPress(KeyEvent e, boolean isPressed) {
    if (!isPressed || e.getKeyCode() != KeyEvent.VK_ESCAPE) return false;

    Main.FRAME.addCanvas(new Pause());

    return true;
  }
}
