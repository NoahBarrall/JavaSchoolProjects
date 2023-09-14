import java.awt.Color;

public class DrawTester {
    public static void main(String[] args) {
        // StdDraw.setCanvasSize(800, 600);
        // StdDraw.setXscale(-4, 4);
        // StdDraw.setYscale(-3, 3);
        // StdDraw.setPenColor(Color.ORANGE);
        // StdDraw.filledRectangle(-1, -1, 2, 1);
        // StdDraw.setPenColor(Color.BLACK);
        // StdDraw.setPenRadius(0.01);
        // StdDraw.rectangle(-1, -1, 2, 1);
    
        // Box box = new Box(1, 2, Color.RED, 0.01);
        // box.move(1, 0.5);
        // box.draw();
    
        
        Draw window = new Draw();
        window.setCanvasSize(800, 600);
        window.setXscale(-4, 4);
        window.setYscale(-3, 3);

        Box[] boxes = new Box[50];
        
        for (Box box : boxes) {
        
            double w = Math.random() + 1;
            double h = Math.random() + 1;
            Color c = Color.YELLOW;
            if (Math.random() > 0.75) c = Color.GREEN;
            box = new Box(w, h, c, 0.01);
            double dx = Math.random() * 6 - 3;
            double dy = Math.random() * 4 - 2;
            box.move(dx, dy);
            box.draw(window);
        }
        
    }
}

