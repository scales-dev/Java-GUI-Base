package com.scales.dev.listeners;

import com.scales.dev.window.Frame;

import java.util.Timer;
import java.util.TimerTask;

public class TickListener extends Listener {
  private static final Timer timer = new Timer();

  public TickListener(Frame frame) {
    super(frame);

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
