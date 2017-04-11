import java.awt.Color;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.*;

public class BouncingBall extends BouncingBox {
	int radius;
	//Color nextColor;
	
	BouncingBall(int startX, int startY, int radius, Color color){
		super(startX, startY, color);
		this.radius = radius;
	}
	
	@Override
	public void drawShape(Graphics surface) {
        surface.setColor(color);
        surface.fillOval(x - radius/2, y - radius/2, radius, radius);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(x - radius/2, y - radius/2, radius, radius);
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
        }
        if ((y - radius/2 <= 0 && yDirection < 0) ||
                (y + radius/2 >= SimpleDraw.HEIGHT && yDirection > 0)) {
            yDirection = -yDirection;
        }
    }
}
