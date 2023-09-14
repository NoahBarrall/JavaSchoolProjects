import java.awt.Color;

public class Box {
    //instance variables
    private double width;
    private double height;
    private Color color;
    private double outlineWidth;
    private double centerX;
    private double centerY;
    
    // Constructor, no return type, name also matches class
    public Box(double width, double height, Color color,
            double outlineWidth) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.outlineWidth = outlineWidth;
        this.centerX = 0;
        this.centerY = 0;
    }

    // additional methods (non-static)  
    public void move(double dx, double dy) {
        this.centerX += dx;
        this.centerY += dy;
    }
    public void draw() {
        StdDraw.setPenColor(this.color);
        StdDraw.filledRectangle(this.centerX, this.centerY,
            this.width / 2, this.height / 2);
        
        StdDraw.setPenRadius(this.outlineWidth);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.rectangle(this.centerX, this.centerY,
            this.width / 2, this.height / 2);
    }
    public void draw(Draw window) {
        window.setPenColor(this.color);
        window.filledRectangle(this.centerX, this.centerY,
            this.width / 2, this.height / 2);
        
        window.setPenRadius(this.outlineWidth);
        window.setPenColor(Color.BLACK);
        window.rectangle(this.centerX, this.centerY,
            this.width / 2, this.height / 2);
    }
}
