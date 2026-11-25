# Java GUI Base
> I use JFrame in all my personal projects, it makes sense to have a slightly quicker way to write the GUI.

## WIP
Currently not usable as a library, I'll finish it next time I write a project with a GUI, 
which is possibly never, spending all day at work writing code makes doing it in my free time less fun :(

I plan on adding more to this, so when I'm 100 I can just import this as a library and only have to write 2 lines of GUI code.

## Features
### Simpler to initialise the window
Normally JFrame makes you initialise the frame, give it an icon, set it visible and set it to close the program when the GUI is closed.
I also like my windows to not be resizable.
This sets all of those for you, because any project I make wants those set.
All with a 
```java
Frame FRAME = new Frame("name!")
```

### Easily create overlapping canvases
I often want canvases overlapping eachother, to do this you need to create a new JLayeredPane, I created a slightly extended child class `Canvas`.
Assuming you have a class as so:

```java
import com.scales.dev.window.Canvas;
import java.awt.*;

public class Title extends Canvas {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // draw whatever, to repaint the screen on an event, do "this.repaint()";
  }
}
```

You can add this canvas to the window, and it will draw above the previous canvas, allowing transparency!
```java
FRAME.addCanvas(new Title());
```

You can then remove it as so:
```java
Canvas title = new Title();
FRAME.addCanvas(title);

FRAME.removeCanvas(title);
```

Or by the canvas itself by doing:
```java
this.getParentFrame().removeCanvas(this);
```

### Handling events
Most importantly, it gives an easy way to handle clicks, keyboard inputs and mouse dragging, across the layered canvases. 
As well as making it easy to create your own events.
```java
import com.scales.dev.listeners.RegisterListener;
import java.awt.event.MouseEvent;

public class Pause extends Canvas {
  // handle drawing...

  @RegisterListener(type = Listener.Type.MOUSE_PRESS)
  public boolean onMousePress(MouseEvent e, boolean isPressed) {
    // calls the paintComponent function from every "Canvas"
    this.repaint();

    // if you return true, the event is not passed to canvases below it,
    // whatever is rendered on top handles the event first!
    return true;
  }
}
```
