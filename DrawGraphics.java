import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class DrawGraphics {
    BouncingBox[] balls;
    
    /** Initializes this class for drawing. */
    public DrawGraphics() 
    {
    	Random rand = new Random();
    	
    	// Generate a random number of items on the screen
    	int N = rand.nextInt(6) + 5;
    	balls = new BouncingBox[N];
    	
    	// Create all the boxes and balls
    	for (int i=0; i<balls.length; i++)
    	{
    		// Random type, starting point and radius
    		int br = rand.nextInt(3);
    		int rx = rand.nextInt(300);
    		int ry = rand.nextInt(300);
    		int rr = rand.nextInt(21) + 20;
    		
    		// Switch statement to generate the type of item we want
    		switch(br)
    		{
    		case 0:
    			balls[i] = new BouncingBox(rx, ry, Color.RED);
    			break;
    		case 1:
    			balls[i] = new BouncingBall(rx, ry, rr, Color.BLUE);
    			break;
    		case 2:
    			balls[i] = new BouncingMagicBall(rx, ry, rr);
    			break;
    		}
    		
    		// Random movement vector
    		int rmx = rand.nextInt(9) - 4;
    		int rmy = rand.nextInt(9) - 4;
    		balls[i].setMovementVector(rmx, rmy);
    	}        
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) 
    {
    	// Draw all the balls and boxes in the array
        for (int i=0; i<balls.length; i++)
        	balls[i].draw(surface);
    }
} 