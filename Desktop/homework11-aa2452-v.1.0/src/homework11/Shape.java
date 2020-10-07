package homework11;


import java.io.Serializable;

/**
 * The parent class for all shapes.
 */
public abstract class Shape implements Figure, Serializable {
    /**
     * The position of the shape. The meaning of this is different depending
     * on the shape.
     */
    private Position pos;
    private double factor;

    /**
     * The shape fill color.
     */
    private String fillColor;

    /**
     * The shape line color.
     */
    private String lineColor;

    /**
     * Creates a new shape.
     *
     * @param pos The initial position of the shape.
     * @param fillColor The fill color.
     * @param lineColor The outline color.
     */
    public Shape(Position pos, String fillColor, String lineColor) {
        this.pos = pos;
        this.fillColor = fillColor;
        this.lineColor = lineColor;
    }


    public Shape(){}

    public  Position getPos() {
        return pos;
    }

    public void setPos(Position pos){

        this.pos = pos;
    }



    public String getFillColor() {
        return fillColor;
    }

    public String getLineColor() {
        return lineColor;
    }

    public void move(Position pos) {
        this.pos = pos;
    }

    /**
     * Returns the area of the shape. This cannot be computed for all shapes,
     * and so this method must be overridden in a child class.
     *
     * @return The area of the shape. By default this is 0.
     */
    public abstract double area();

    /**
     * Returns the perimeter of the shape. This cannot be computed for all
     * shapes, and so this method must be overridden in a child class.
     *
     * @return The perimeter of all shapes.
     */
    public abstract double perimeter();

    public void scale(double factor){};


}
