package com.scales.dev;

import com.scales.dev.window.Canvas;
import com.scales.dev.window.Frame;

import java.awt.*;

public class Main {
  public static final String PROJECT_NAME = "base";

  public static void main(String[] args) {
    Frame frame = new Frame();
    Canvas canvas = new Canvas();
    frame.addCanvas(canvas);

    while (true) {
      canvas.repaint();
    }
  }
}