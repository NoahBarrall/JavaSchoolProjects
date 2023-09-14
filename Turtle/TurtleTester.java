public class TurtleTester {
    
    public static void polygon(Turtle turtle, int numSides, double sidesLength) {

        for (int i = 0; i < numSides; i++) {
            turtle.goForward(sidesLength);
            turtle.turnLeft(360.0 / numSides);
        }
    }

    public static void polygonStar(Turtle turtle, int numPolygons,
    int numSides, double sideLength) {
    
    for (int p = 0; p < numPolygons; p++) {
        polygon(turtle, numSides, sideLength);
        turtle.turnLeft(360 / numPolygons);
        }
    }
    public static void main(String[] args) {
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-10, 10);

        Turtle t = new Turtle(5,-5);

        polygonStar(t, 8, 5, 1.5);

        t.penUp();
        t.goForward(10);
        t.penDown();

        polygonStar(t, 8, 5, 1.5);

        t.penUp();
        t.turnLeft(90);
        t.goForward(10);
        t.penDown();

        polygonStar(t, 8, 5, 1.5);

        t.penUp();
        t.turnLeft(90);
        t.goForward(10);
        t.penDown();

        polygonStar(t, 8, 5, 1.5);

    }
}
