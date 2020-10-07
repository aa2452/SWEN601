package homework11;

/**
 * An equilateral triangle shape.
 */
public class Triangle extends Shape {
    /**
     * Used to compute the area of an equilateral triangle.
     */
    private static final double CONSTANT = Math.sqrt(3) / 4.0d;

    /**
     * The length of one side of the triangle.
     */
    private double side;

   /**
            * The variable used to scale the triangle
 */
    private double factor = 1.0 ;

    public Triangle(){}

    /**
     * Creates a new equilateral triangle.
     *
     * @param pos The position of the top left corner.
     * @param fillColor The fill color.
     * @param lineColor The outline color.
     * @param side The length of one side of the triangle.
     */
    public Triangle(Position pos, String fillColor, String lineColor, double side) throws NegativeInteger {
        super(pos, fillColor, lineColor);

        /**
         * Determines if the triangle(s) side is less than one or negative;
         */
        try{
            if(side<1) {
                throw new NegativeInteger("The triangle(s) side cannot be less than 1 or negative");
            }else{this.side = side;}

        }catch(NegativeInteger e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }


    }

    public double getSide() {
        return side;
    }

    @Override
    public void scale(double factor) {
        this.factor = factor;
    }

    /**
     * Computes and returns the area of the equilateral triangle.
     *
     * @return Returns the area of the equilateral triangle.
     */
    @Override
    public double area() {
        return CONSTANT * side * side*factor;
    }

    /**
     * Computes and returns the perimeter of the equilateral triangle.
     *
     * @return Returns the perimeter of the equilateral triangle.
     */
    @Override
    public double perimeter() {
        return side * 3*factor;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                 getPos()+
                ", side=" + side +
                ", Line Color = "+ getLineColor()+
                ", Fill Color = "+ getFillColor()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side, side) == 0 &&
                Double.compare(triangle.factor, factor) == 0;
    }


}
