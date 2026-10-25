package com.scales.dev;

import com.scales.dev.window.Frame;

public class Main {
  public static final String PROJECT_NAME = "base";

  public static void main(String[] args) {
    Frame frame = new Frame();
    Example canvas = new Example();
    frame.addCanvas(canvas);
  }
}