package homework11;

/**
 * A circle shape.
 */
public class Circle extends Shape {
    /**
     * The radius of the circle.
     */
    private double radius;

/**
 * The variable used to scale the circle
 */
    private double factor = 1.0 ;

    /**
     *
     *
     * Creates a new circle.
     *
     * @param pos The position of the top left corner.
     * @param fillColor The fill color.
     * @param lineColor The outline color.
     * @param radius The radius of the circle.
     */
    public Circle(Position pos, String fillColor, String lineColor, double radius) {

        super(pos, fillColor, lineColor);

        /**
         * Determines if the circle(s) side is less than one or negative;
         */

        try{
            if(radius<1) {
                throw new NegativeInteger("The cirles(s) side cannot be less than 1 or negative");
            }else{this.radius = radius;}

        }catch(NegativeInteger e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            //System.exit(-1);
        }finally{
            this.radius = radius;
        }



    }

    public Circle(){}

    public double getRadius() {
        return radius;
    }

    /**
     * Computes and returns the area of the circle.
     *
     * @return Returns the area of the circle.
     */

    @Override
    public double area() {
        return Math.PI * radius * radius*factor;
    }

    /**
     * Computes and returns the perimeter of the circle.
     *
     * @return Returns the perimeter of the circle.
     */
    @Override
    public double perimeter() {
        return Math.PI * radius * 2*factor;
    }

    @Override
    public void scale(double factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return "Circle{" +
                getPos()+
                ", radius=" + radius +
                ", Line Color = "+ getLineColor()+
                ", Fill Color = "+ getFillColor()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 &&
                Double.compare(circle.factor, factor) == 0;
    }


}
