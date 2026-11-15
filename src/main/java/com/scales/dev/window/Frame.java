package com.scales.dev.window;

import com.scales.dev.Main;
import com.scales.dev.listeners.Listener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import lombok.Getter;

public class Frame extends JFrame {
  @Getter private final ArrayList<Canvas> canvases = new ArrayList<>();

  public Frame() {
    super(Main.PROJECT_NAME);

    // otherwise it keeps running without a window, how crazy!
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // generally its easier for my stuff to only render for a specific size, sorry
    this.setResizable(false);
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
    canvas.setParentFrame(this);

    Listener.registerClass(canvas);
    // index 0 is the top layer
    this.add(canvas, 0);

    // makes the window the same size as its canvas's
    this.pack();

    this.update();
  }

  public void removeCanvas(Canvas canvas) {
    canvas.setParentFrame(null);

    Listener.unregisterClass(canvas);
    this.remove(canvas);

    this.update();
  }

  private void update() {
    this.repaint();
  }
}