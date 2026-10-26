package com.scales.dev.window;

import com.scales.dev.listeners.Listener;
import java.awt.*;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import javax.swing.*;
import lombok.Getter;

// ironically, we dont extend canvas, lol.
// obscure stuff https://forums.oracle.com/ords/apexds/post/how-to-make-two-jpanel-overlapping-0596
public class Canvas extends JLayeredPane {
  public final LinkedHashMap<Listener.Type, Method> LISTENERS = new LinkedHashMap<>();

  @Getter private Frame parentFrame;

  public void setParentFrame(Frame parentFrame) {
    if (this.parentFrame != null) {
      this.parentFrame.getCanvases().remove(this);
    }

    this.parentFrame = parentFrame;

    if (this.parentFrame != null) {
      this.parentFrame.getCanvases().add(this);
    }
  }

  private boolean isOnTop() {
    return parentFrame.getCanvases().getLast() == this;
  }

  public Canvas() {
    super();

    // Might need an intervention for this new dimension
    // That's too new to mention, or fit in a sentence
    // If I get locked up, I won't finish the sent—
    this.setPreferredSize(new Dimension(500, 500));

    this.setDoubleBuffered(true);
    this.setFocusable(true);

    this.setBackground(new Color(0, 0, 0, 0));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    // makes SURE we aren't drawing twice at the same time
    //Toolkit.getDefaultToolkit().sync();
  }
}