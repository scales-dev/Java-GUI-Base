package com.scales.dev.screens;

import com.scales.dev.Main;
import com.scales.dev.listeners.Listener;
import com.scales.dev.listeners.RegisterListener;
import com.scales.dev.window.Canvas;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Title extends Canvas {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.BLACK);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 24));

    int titleWidth = g.getFontMetrics().stringWidth(Main.FRAME.getTitle());
    g.drawString(Main.FRAME.getTitle(), (this.getWidth() / 2) - (titleWidth / 2), 100);

    String subtitleText = "Press any key to start";
    int subtitleWidth = g.getFontMetrics().stringWidth(subtitleText);
    g.drawString(subtitleText, (this.getWidth() / 2) - (subtitleWidth / 2), 150);
  }

  @RegisterListener(type = Listener.Type.KEY_PRESS)
  public boolean onKeyPress(KeyEvent e, boolean isPressed) {
    if (!isPressed) return false;

    this.getParentFrame().addCanvas(new Game());
    this.getParentFrame().removeCanvas(this);

    return true;
  }
}
