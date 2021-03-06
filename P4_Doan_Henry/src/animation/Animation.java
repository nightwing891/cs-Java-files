package animation;

import java.awt.Color;
import java.awt.Graphics;

public class Animation {
	/**
	 * This is the method that you need to rewrite to create a custom animation.
	 * This method is called repeatedly as the animation proceeds. It needs to
	 * draw to g how the animation should look after t milliseconds have passed.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param t
	 *            Number of milliseconds that have passed since animation
	 *            started
	 */

	/**
	 * This is the method shows the behavior of each elements in the animation.
	 * The story is that there is a three person race and a person finished
	 * first and then as time goes on, ( represented as the tree growing and the
	 * sun moving) the other people will catch up.
	 * 
	 * The elements have a set position in their own methods and then in this
	 * method is where it moves and characteristics. the people goes from left
	 * to right, but at different speed by dividing the initial x value by
	 * various numbers a higher number is a slower movement speed while the
	 * lowest value is the faster movements.
	 * 
	 * The Sun moves not only from left to right but in a sin wave with the
	 * speed similar to the person speed, where the lower values are faster and
	 * greater values are slower.
	 * 
	 * The tree top gets the scale be bigger so it make it bigger every 2
	 * seconds, and the reason why the trunk is moving is because it is trying
	 * to be in the center of the treetop and that is why it is moving.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param t
	 *            Number of milliseconds that have passed since animation
	 *            started
	 * @param height
	 *            the starting point in the y axis
	 * @param width
	 *            the starting point in the x axis
	 */

	public static void paintFrame(Graphics g, int t, int height, int width) {
		if (t < 10000) {
			drawPerson1(g, 0 + t / 2, 0, 0, Color.BLACK);
			drawPerson2(g, 0 + t / 30, 0, 0, Color.RED);
			drawPerson3(g, 0 + t / 10, 0, 0, Color.CYAN);
			drawTreeTop(g, 0, 0, 0 + t / 2000, Color.GREEN);
			drawTrunk(g, 0 + t / 200, 0, 0 + t / 2000, Color.ORANGE);
			drawSun(g, 0 + t / 5, 0 + (int) (50 * Math.sin(t * Math.PI / 1000)), 0 + t / 2000, Color.YELLOW);
		}

	}

	/**
	 * This is the method draws the first person starting from the right with
	 * specific positions of each element. The first line in the element sets
	 * all of the lines below the color indented in the main. Then the head is
	 * drawn from the right size and position, followed by the vertical line of
	 * the body which is centered of the head. The horizontal line makes up for
	 * the arms. The right leg is a line that is opposite y value reflection in
	 * of the left leg.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param int
	 *            x is a number representing the value of the x, from left to
	 *            right positioning
	 * @param int
	 *            y is a number representing the value of the y, from top to
	 *            bottom positioning
	 * @param double
	 *            scale is the size increase or decrease in the method and
	 *            elements.
	 * @param Color
	 *            Color is the color that is all of the methods elements.
	 */

	public static void drawPerson1(Graphics g, int x, int y, double scale, Color color) {
		g.setColor(color);
		g.fillOval(x + 10, 50, 50, 50); // Draws the head
		g.drawLine(x + 35, 170, x + 35, 60); // Draws the Body
		g.drawLine(x + 10, 120, x + 60, 120); // Draws the Arms
		g.drawLine(x + 35, 170, x + 60, 200); // Draws the Right leg
		g.drawLine(x + 35, 170, x + 10, 200); // Draws the Left leg
	}

	/**
	 * This is the method draws the Second person starting from the right with
	 * specific positions of each element. Since this is a object that is lower
	 * than the first object, the y value has increase for all elements to be
	 * 170 lower than the first person but it is set 170 higher to move it down.
	 * Then all of the elements that made up the person is the same as person
	 * one.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param int
	 *            x is a number representing the value of the x, from left to
	 *            right positioning
	 * @param int
	 *            y is a number representing the value of the y, from top to
	 *            bottom positioning
	 * @param double
	 *            scale is the size increase or decrease in the method and
	 *            elements.
	 * @param Color
	 *            Color is the color that is all of the methods elements.
	 */

	public static void drawPerson2(Graphics g, int x, int y, double scale, Color color) {
		g.setColor(color);
		g.fillOval(x + 10, 220, 50, 50); // Draws the head
		g.drawLine(x + 35, 340, x + 35, 230); // Draws the Body
		g.drawLine(x + 10, 290, x + 60, 290); // Draws the Arms
		g.drawLine(x + 35, 340, x + 60, 370); // Draws the Right leg
		g.drawLine(x + 35, 340, x + 10, 370);
	}

	/**
	 * This is the method draws the Third person starting from the right with
	 * specific positions of each element. Since this is a object that is lower
	 * than the second object, the y value has increase for all elements to be
	 * 170 lower than the second person but it is set 170 higher to move it down
	 * than the second person. Then all of the elements that made up the person
	 * is the same as person one.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param int
	 *            x is a number representing the value of the x, from left to
	 *            right positioning
	 * @param int
	 *            y is a number representing the value of the y, from top to
	 *            bottom positioning
	 * @param double
	 *            scale is the size increase or decrease in the method and
	 *            elements.
	 * @param Color
	 *            Color is the color that is all of the methods elements.
	 */

	public static void drawPerson3(Graphics g, int x, int y, double scale, Color color) {
		g.setColor(color);
		g.fillOval(x + 10, 390, 50, 50); // Draws the head
		g.drawLine(x + 35, 510, x + 35, 400); // Draws the Body
		g.drawLine(x + 10, 460, x + 60, 460); // Draws the Arms
		g.drawLine(x + 35, 510, x + 60, 540); // Draws the Right leg
		g.drawLine(x + 35, 510, x + 10, 540); // Draws the Left leg
	}

	/**
	 * This is the method draws multiple oval in shape of circles, and have the
	 * ability to manipulate the size and in this case it is growing but having
	 * the scale be added on to the origin size and multiple it as the times
	 * goes.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param int
	 *            x is a number representing the value of the x, from left to
	 *            right positioning
	 * @param int
	 *            y is a number representing the value of the y, from top to
	 *            bottom positioning
	 * @param double
	 *            scale is the size increase or decrease in the method and
	 *            elements.
	 * @param Color
	 *            Color is the color that is all of the methods elements.
	 */
	public static void drawTreeTop(Graphics g, int x, int y, double scale, Color color) {
		g.setColor(color);
		g.fillOval(800, 250, 80 + (int) (30 * scale), 80 + (int) (30 * scale));
		g.fillOval(820, 220, 80 + (int) (30 * scale), 80 + (int) (30 * scale));
		g.fillOval(850, 220, 80 + (int) (30 * scale), 80 + (int) (30 * scale));
		g.fillOval(860, 250, 80 + (int) (30 * scale), 80 + (int) (30 * scale));
	}

	/**
	 * This is the method draws two vertical lines that represents the tree
	 * trunk and have the size be changed by having the length of the line be
	 * added more as the time goes on by.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param int
	 *            x is a number representing the value of the x, from left to
	 *            right positioning
	 * @param int
	 *            y is a number representing the value of the y, from top to
	 *            bottom positioning
	 * @param double
	 *            scale is the size increase or decrease in the method and
	 *            elements.
	 * @param Color
	 *            Color is the color that is all of the methods elements.
	 */

	public static void drawTrunk(Graphics g, int x, int y, double scale, Color color) {
		g.setColor(color);
		g.drawLine(x + 890, 330, x + 890, 530 + (int) (30 * scale)); // Draws
																		// Right
																		// Trunk
		g.drawLine(x + 845, 330, x + 845, 530 + (int) (30 * scale));
	}

	/**
	 * This is the method draws an oval in shape of circle and have the position
	 * of it be added from the original position to the right to have it move
	 * from the left to the right.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param int
	 *            x is a number representing the value of the x, from left to
	 *            right positioning
	 * @param int
	 *            y is a number representing the value of the y, from top to
	 *            bottom positioning
	 * @param double
	 *            scale is the size increase or decrease in the method and
	 *            elements.
	 * @param Color
	 *            Color is the color that is all of the methods elements.
	 */

	public static void drawSun(Graphics g, int x, int y, double scale, Color color) {
		g.setColor(color);
		g.fillOval(x + 5, y + 20, 40, 40);
	}
}
