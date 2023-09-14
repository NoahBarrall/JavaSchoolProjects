import java.awt.Color;
/**
 * @author David Owen and Noah Barrall
 */
public class Turtle {
    private double xPos;
    private double yPos;
    private double angle;
    private boolean isPenDown;

    public Turtle(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.angle = 90;  // Point straight up initially.
        this.isPenDown = true;
    }
    public void turnLeft(double delta) {
        this.angle += delta;
    }
    public void goForward(double distance) {
        double angleRadians = Math.toRadians(this.angle);
        double xDistance = distance * Math.cos(angleRadians);
        double yDistance = distance * Math.sin(angleRadians);
        double newX = this.xPos + xDistance;
        double newY = this.yPos + yDistance;
        if (isPenDown == true) {
            StdDraw.line(this.xPos, this.yPos, newX, newY);
        }
        this.xPos = newX;
        this.yPos = newY;
    }

    public void penUp() {
        this.isPenDown = false;
    }

    public void penDown() {
        this.isPenDown = true;
    }

}