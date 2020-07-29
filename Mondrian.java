import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Mondrian
 * 
 * To create Mondrians follow this procedure:
 * 
 * 1) either split canvas horizontally, vertically or do nothing <br/>
 * 2) repeat step 1 with the smaller canvases, until canvases are to small.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Khen Brian N.K. Quartey
 */
public class Mondrian extends GraphicsProgram {
	private static final int MIN_SIZE = 25;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		setSize(400, 400);

		while (true) {
			removeAll();
			drawMondrian(0, 0, getWidth(), getHeight());
			waitForClick();
		}
	}

	private void drawMondrian(double i, double j, double width, double height) {
		drawRectangle(i, j, width, height);
		double partialHeight = height / 2;
		double partialWidth = width / 4;
		if ((partialWidth < MIN_SIZE) || (partialHeight < MIN_SIZE)) {
			return;
		}
		drawMondrian(i, j, partialWidth, height);
		drawMondrian(i + partialWidth, j, width, partialHeight);
		drawMondrian(i + partialWidth, j + partialHeight, width, partialHeight);

	}
	

	private void drawRectangle(double i, double j, double width, double height) {
		GRect rect = new GRect(i, j, width, height);
		rect.setColor(Color.BLACK);
		rect.setFillColor(getRandomColor());
		rect.setFilled(true);
		add(rect);
		GRect rect2 = new GRect(i + 1, j + 1, width - 2, height - 2);
		rect2.setColor(Color.BLACK);
		rect2.setFillColor(getRandomColor());
		rect2.setFilled(true);
		add(rect2);
	}

	private Color getRandomColor() {
		int choice = rgen.nextInt(0, 3);
		switch (choice) {
		case 0:
			return Color.BLUE;
		case 1:
			return Color.RED;
		case 2:
			return Color.YELLOW;
		default:
			return Color.WHITE;
		}
	}
}
