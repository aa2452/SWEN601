package homework11;
import java.io.Serializable;

/**
 * A rectangle shape.
 */
public class Rectangle extends Shape{
    /**
     * The width of the rectangle.
     */
    private double width;

    /**
     * The height of the rectangle.
     */
    private double height;

    /**
            * The variable used to scale the rectangle
 */
    private double factor = 1.0 ;

    /**
     * Creates a new rectangle.
     *
     * @param pos The position of the top left corner.
     * @param fillColor The fill color.
     * @param lineColor The outline color.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(Position pos, String fillColor, String lineColor,
                     double width, double height) {
        super(pos, fillColor, lineColor);

        /**
         * Determines if the rectangle(s) width or height is less than one or negative;
         */

        try{
            if(width<1||height<1) {
                throw new NegativeInteger("The rectangle(s) side cannot be less than 1 or negative");
            }else{
                this.width = width;
                this.height = height;
            }
        }catch(NegativeInteger e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }


    }

    public Rectangle(){}




    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    /**
     * Computes and returns the area of the rectangle.
     *
     * @return Returns the area of the rectangle.
     */
    @Override
    public double area() {
        return width * height;
    }

    /**
     * Computes and returns the perimeter of the rectangle.
     *
     * @return Returns the perimeter of the rectangle.
     */
    @Override
    public double perimeter() {
        return width*2 + height*2;
    }

    @Override
    public void scale(double factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                 getPos()+
                ", width=" + width +
                ", height=" + height +
                ", Line Color = "+ getLineColor()+
                ", Fill Color = "+ getFillColor()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 &&
                Double.compare(rectangle.height, height) == 0 &&
                Double.compare(rectangle.factor, factor) == 0;
    }


}
