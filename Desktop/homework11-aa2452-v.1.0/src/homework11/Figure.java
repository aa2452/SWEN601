package homework11;


public interface Figure {



    //methods
   static Position getPos(Shape shape) {
        return shape.getPos();
    }

    static void move(Shape shape, Position pos) {
        //move shape
        shape.setPos(pos);
    }


    static String getFillColor(Shape shape) {
        return shape.getFillColor();
    }

    static String getLineColor(Shape shape) {
        return shape.getLineColor();
    }

     static double area(Shape shape){
        return shape.area();
     }


     static double perimeter(Shape shape){
      return shape.perimeter();
     }


    static void scale(Shape shape, double factor) {
       shape.scale(factor);
    }
}
