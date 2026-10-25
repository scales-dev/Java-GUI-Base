package com.scales.dev;

import com.scales.dev.screens.Title;
import com.scales.dev.window.Frame;

public class Main {
  public static final String PROJECT_NAME = "base";
  public static final Frame FRAME = new Frame();

  public static void main(String[] args) {
    Title titleScreen = new Title();
    FRAME.addCanvas(titleScreen);
  }
}