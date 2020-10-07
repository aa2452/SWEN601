/**
 * Anwar A.
 * SWEN 610
 * aa2452@g.rit.edu
 *
 * This portion of the homework exhibits the ability to utilize the 'Figure' interface with the 'Shape' class
 * The required methods are implemented from the interface to produce a function output
 *
 * The Class also incorporates a figure 'scaling' method whose magnitude affects the area() and perimeter() of the
 * respective shape.
 *
 */

package homework11;

/**
 * Utility class that can be used to move or print shapes.
 */
public class ShapeMover implements Figure {



    /**
     * Prints a shape, moves it to a new position, and then prints it again.
     *
     * @param shape The shape to move and print.
     * @param position The new position to which the shape should me moved.
     */
    public static void moveShape(Shape shape, Position position) {
        System.out.println("BEFORE MOVING");
        printShape(shape);

        //scale the figure by a factor of 2 after moving
            //the area and perimeter of each shape is double in the process
        Figure.scale(shape,2.0);

        Figure.move(shape,position);


        System.out.println("AFTER MOVING");
        printShape(shape);
    }

    /**
     * Prints the details about a shape including the class name, position,
     * area, perimeter, fill color, and outline.
     *
     * @param shape The shape to print.
     */
    public static void printShape(Shape shape) {
        System.out.println("Shape: " + shape.getClass());
        System.out.println("  position: " + Figure.getPos(shape));
        System.out.println("  area: " + Figure.area(shape));
        System.out.println("  perimeter: " + Figure.perimeter(shape));
        System.out.println("  fill color: " + Figure.getFillColor(shape));
        System.out.println("  outline: " + Figure.getLineColor(shape) + "\n");

    }



    /**
     * Tests the move method with various different shapes.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {







        Rectangle rectangle = new Rectangle(new Position(50, 50), "Brown",
                "Yellow", 100, 50);
        moveShape(rectangle, new Position(25, 75));

        Circle circle = new Circle(new Position(0, 10), "Transparent",
                "Black", 150);
        moveShape(circle, new Position(10, 0));

        Triangle triangle = new Triangle(new Position(-30, -50), "Blue",
                "Orange", 125);
        moveShape(triangle, new Position(-100, -200));








    }
}
