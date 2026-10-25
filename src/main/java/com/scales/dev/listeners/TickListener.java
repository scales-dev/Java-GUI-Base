package com.scales.dev.listeners;

import com.scales.dev.window.Canvas;

import java.util.Timer;
import java.util.TimerTask;

public class TickListener extends Listener {
  private static final Timer timer = new Timer();

  public TickListener(Canvas canvas) {
    super(canvas);

    timer.scheduleAtFixedRate(
      new TimerTask() {
        @Override
        public void run() {
          Listener.fire(Listener.Type.TICK);
        }
      },
      0,
      50
    );
  }
}
