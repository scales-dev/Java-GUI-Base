package com.scales.dev.window;

import com.scales.dev.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Frame extends JFrame {
  public Frame() {
    super(Main.PROJECT_NAME);

    // otherwise it keeps running without a window, how crazy!
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setIconImage();

    this.setVisible(true);
  }

  private void setIconImage() {
    try {
      InputStream iconStream = Main.class.getResourceAsStream("/icon.png");

      if (iconStream != null) {
        BufferedImage icon = ImageIO.read(iconStream);
        this.setIconImage(icon);
        return;
      }
    } catch (IOException ignored) {}

    System.err.println("Error loading icon");
  }

  public void addCanvas(Canvas canvas) {
    this.add(canvas);
    this.pack();

    // centers the window
    this.setLocationRelativeTo(null);
  }
}
