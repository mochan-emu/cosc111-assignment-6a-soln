import java.awt.Color;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.*;

public class BouncingMagicBall extends BouncingBall {
	int radius;
	//Color nextColor;
	
	BouncingMagicBall(int startX, int startY, int radius){
		super(startX, startY, radius, Color.RED);
		this.radius = radius;
		changeColor();
		//this.nextColor = nextColor;
	}
	
	public void changeColor(){
		Random rand = new Random();
		// Java 'Color' class takes 3 floats, from 0 to 1.
		int r = rand.nextInt(256);
		int g = rand.nextInt(256);
		int b = rand.nextInt(256);
		color = new Color(r,g,b);
	}
	
	@Override
    public void moveShape(Graphics surface) {
        // Move the center of the object each time we draw it
        x += xDirection;
        y += yDirection;

        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck"
        // rather than moving in the right direction
        if ((x - radius/2 <= 0 && xDirection < 0) ||
                (x + radius/2 >= SimpleDraw.WIDTH && xDirection > 0)) {
            xDirection = -xDirection;
            changeColor();
        }
        if ((y - radius/2 <= 0 && yDirection < 0) ||
                (y + radius/2 >= SimpleDraw.HEIGHT && yDirection > 0)) {
            yDirection = -yDirection;
            changeColor();
        }
    }
}
