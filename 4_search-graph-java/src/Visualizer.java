import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.*;

public class Visualizer extends WindowAdapter {
	Frame frame;

	public static void main(String[] args) {
		new Visualizer();
	}
	
	Visualizer() {
		frame = new Frame();
		frame.add(new VisualizedGraph());

		int frameWidth = 300;
		int frameHeight = 300;
		frame.addWindowListener(this);

		frame.setSize(frameWidth, frameHeight);

		frame.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		frame.dispose();
	}
	/**
	 * To draw on the screen, it is first necessary to subclass a Component and
	 * override its paint() method. The paint() method is automatically called by
	 * the windowing system whenever component's area needs to be repainted.
	 */
	static class VisualizedGraph extends Component {

		public void paint(Graphics g) {

			// Retrieve the graphics context; this object is used to paint shapes

			Graphics2D g2d = (Graphics2D) g;


			int x = 0;

			int y = 0;



			g2d.drawLine(x, y, 100, 100);

			g2d.drawOval(x, y, 100, 100);



		}
	}
}
