package com.scales.dev;

import com.scales.dev.screens.Game;
import com.scales.dev.window.Canvas;
import com.scales.dev.window.Frame;

public class Main {
  public static final String PROJECT_NAME = "base";

  public static void main(String[] args) {
    Canvas titleScreen = new Game();
    new Frame().addCanvas(titleScreen);
  }
}