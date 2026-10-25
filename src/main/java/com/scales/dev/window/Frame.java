package com.scales.dev.window;

import com.scales.dev.Main;
import com.scales.dev.listeners.KeyListener;
import com.scales.dev.listeners.Listener;
import com.scales.dev.listeners.MouseListener;

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

    // generally its easier for my stuff to only render for a specific size, sorry
    this.setResizable(false);
    this.registerListeners();
    this.setIconImage();
    this.setVisible(true);
  }

  private void registerListeners() {
    this.addMouseListener(new MouseListener());
    this.addKeyListener(new KeyListener());
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
    Listener.registerClass(canvas);

    this.add(canvas);
    // makes the window the same size as its canvas's
    this.pack();

    // centers the window
    this.setLocationRelativeTo(null);
  }
}