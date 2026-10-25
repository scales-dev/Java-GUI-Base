package com.scales.dev.window;

import javax.swing.*;
import java.awt.*;

// ironically, we dont extend canvas, lol.
public class Canvas extends JPanel {
  public Canvas() {
    super();

    // Might need an intervention for this new dimension
    // That's too new to mention, or fit in a sentence
    // If I get locked up, I won't finish the sent—
    this.setPreferredSize(new Dimension(500, 500));
  }

  // this is called as soon as the canvas is created, we can call it ourselves whenever we need
  @Override
  public void paintComponent(Graphics g) {
    // makes SURE we arent drawing twice at the same time
    Toolkit.getDefaultToolkit().sync();
    g.clearRect(0, 0, this.getWidth(), this.getHeight());
    g.setColor(Color.RED);

    int x = (int) ((System.currentTimeMillis()/5) % 450);
    g.fillRect(x, 0, 50,50);
  }
}
