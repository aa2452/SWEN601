/**
 * Anwar A.
 * SWEN 610
 * aa2452@g.rit.edu
 *
 * This portion of the homework implements the 'ShapeArray' class that is used to exhibit
 *  Array sorting of the Shape Array
 *  Create Random shape(s) in a user produced array (2-20)
 *  Utilizing the @Overide equals() within a Class
 *
 *  In order to produce the relevant randomly produced shapes and states, I utilized static integers with a
 *  variety of ranges to utilize randomly generated variables to develop the shapes states and properties.
 *
 *  The homework introduced the new methods saveToFile() and loadToFile() - HomeWork11
 *
 *  The file will throw the incorporated exception and stop the execution of the code. This is used to exhibit the
 *  capability of the exception class and the System.exit, is used to show the NegativeNumber Exception in the class
 *
 *
 */
package homework11;
import java.io.*;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;


public class ShapeArray implements Serializable {
    /**
     * Static variables for creating random shape
     */

    private static String lineColor;
    private static String fillColour;
    private static int x;
    private static int y;
    private static int shapeSelect;
    private static int width;
    private static int height;
    private static int radius;
    private static int side;
    private static int fillcolorSelect;
    private static int linecolorSelect;
    private static  Random rand = new Random();
    private static final long serialVersionUID = 1L;


    /**
     * Create a random shape and state values to be used to populate the 'shapeArray' array
     * which has a variable size. The size of the array is determined by the user during runtime
     */

    public static void createRandomShape(){
        //create a random shape

        /**
         * Random value selectors for generating random states
         */
        //shape selector
        shapeSelect = rand.nextInt(3);
        //fillcolor  selector
        fillcolorSelect = rand.nextInt(4);
        //linecolor  selector
        linecolorSelect = rand.nextInt(4);
        //int x coordinate
        x = rand.nextInt(100);
        //int x coordinate
        y = rand.nextInt(100);
        //circle radius
        radius = rand.nextInt(30)+5;
        //rectangle width
        width = rand.nextInt(15);
        //rectangle height
        height = rand.nextInt(15);
        //triangle height
        side = rand.nextInt(30)+1;


        switch(fillcolorSelect) {
            case 0:
                fillColour = "Blue";
                break;
            case 1:
                fillColour = "Yellow";
                break;
            case 2:
                fillColour = "Red";
                break;
            case 3:
                fillColour = "Transparent";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + fillcolorSelect);
        }

        switch(linecolorSelect) {
            case 0:
                lineColor = "Blue";
                break;
            case 1:
                lineColor = "Yellow";
                break;
            case 2:
                lineColor = "Black";
                break;
            case 3:
                lineColor = "Green";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + linecolorSelect);
        }



    }

    /**
     * Method will sort through shape areas and arrange them by size
     * The Selection Sort method is used to produce a sorted array
     */
    public static void sortShape(Shape[] shape){

        //invoke selection sort
        selectionSort(shape, 0, shape.length-1);
    }

    //selection sort algorithm
    public static void selectionSort(Shape[] shape, int lo, int hi){
        for (int h=lo;h< shape.length;h++){
            int s = smallestNum(shape, h, hi);
            swap(shape,h,s);
        }
    }


    /**
    find the smallest numerical representation of the shape area
    */
    public static int smallestNum(Shape shape[], int lo, int hi){
        int smallNum = lo;
        for (int h=lo+1;h<=hi;h++)

            if (shape[h].area()< shape[smallNum].area()){

                smallNum = h;
            }
        return smallNum;
    }//end of the Selection Sort


    /**
    swap elements in the array for the country data
    follow-up be swapping the elements in the population data
     */
    public static void swap(Shape shape[], int i, int j){


        Shape temp = shape[i];
        shape[i] = shape[j];
        shape[j] = temp;

    }

    /**
     *
     * @param shape
     * @param s - Shape shape
     * @return
     */

    public static boolean findShape(Shape[] shape, Shape s){
        boolean reality = false;

        for (int i = 0; i < shape.length ; i++) {
            if(shape[i].equals(s)){
                //System.out.println("\nFound a matching shape");
                reality =  true;
                break;
            }
            else {

                reality =  false;

            }
        }

        if(reality==false){
            //System.out.println("\nThere is no matching shape");
        }

        return reality;
    }

    /**
     * The method saves the randomly generated array to a text file
     * @param file
     * @param shapes
     * @throws IOException
     */
    public static void saveShapesToFile (String file,Shape[] shapes) throws IOException {

        try {
        // Writes the content to the file
            FileOutputStream fileOutputStream = new FileOutputStream(file+".txt");
            ObjectOutputStream obOutStr = new ObjectOutputStream(fileOutputStream);

            for (int i = 0; i < shapes.length; i++) {
            obOutStr.writeObject(shapes[i]);
            }
         obOutStr.close();
            }catch(IOException e){
         e.printStackTrace();
        }

    }


    /**
     * The method will be used to create a temporary Shape Array from the text file, the file uses a matcher to create
     * extract the shapes from the text strings
     * @param file
     * @param tempShapes
     * @throws FileNotFoundException
     */

    public static void loadShapesToFile(String file, Shape[] tempShapes) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file+".txt");
        try {
            ObjectInputStream obInStr = new ObjectInputStream(fileInputStream);

            for (int i = 0; i < tempShapes.length ; i++) {
                tempShapes[i] = (Shape) obInStr.readObject();
            }
            obInStr.close();

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }




    public static void main(String[] args) throws IOException {

        int arraySize;
        boolean errorFlag = true;
        // create instance of Random class
        Random rand = new Random();


        /**
         * The input will be used to take user input to create an integer arraySize of size 2-20
         */
        Scanner sc = new Scanner(System.in);

        /**
         * Prompt the user for input for ArraySize
         * If the integer is outside the required range prompt user to reenter input
         */
        do {
            System.out.print("Enter the desired array size between 2 - 20: ");
                arraySize = sc.nextInt();
            if(arraySize>=2&&arraySize<=20){
                errorFlag = false;

                System.out.printf("\nCreating an array of size: %d\n", arraySize);
            }else{
                System.out.println("The integer that you entered is outside of the range");
                errorFlag= true;

            }
        }while(errorFlag == true);

        /**
         * Create a shape array of arraySize
         */

        Shape[] shapeArray = new Shape[arraySize];

        /**
         * Populate the array with randomly with types Triangle, Rectangle, Circle
         */
        for (int i = 0; i < arraySize; i++) {
            createRandomShape();

            switch(shapeSelect) {
                case 0:
                    shapeArray[i] = new Rectangle(new Position(x, y), fillColour,
                            lineColor, width, height);
                    break;
                case 1:
                    shapeArray[i] = new Circle(new Position(x, y), fillColour,
                            lineColor, radius);
                    break;
                case 2:
                    shapeArray[i]= new Triangle(new Position(x, y), fillColour,
                            lineColor, side);
                    break;
            }



            System.out.println(shapeArray[i]);

        }

        /**
         * The method is used sort the randomly created array from smallest to largest
         */

        sortShape(shapeArray);

        /**
         * The array after the sorting method is implemented
         */

        System.out.println("\nThe result of 'sortShape' being implemented: ");

        for (int i = 0; i < arraySize; i++) {
            System.out.println(shapeArray[i]);

        }

        /**
         * Initialize a single random shape 
         */
        
        Shape randomShape;
        
        createRandomShape();

        switch(shapeSelect) {
            case 0:
                randomShape = new Rectangle(new Position(x, y), fillColour,
                        lineColor, width, height);
                break;
            case 1:
                randomShape = new Circle(new Position(x, y), fillColour,
                        lineColor, radius);
                break;
            case 2:
                randomShape= new Triangle(new Position(x, y), fillColour,
                        lineColor, side);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + shapeSelect);
        }

        /**
         * The findShape function is being used to compare arrayShape elements tp random create randomShape
         */

        System.out.println("\nThere is a matching shape in the array: "+findShape(shapeArray, randomShape));
        


        /**
         * The findShape function is being used to compare arrayShape[0] to all the shapes in the array using equals
         */

        System.out.println("\nThere is a matching shape in the array: "+findShape(shapeArray, shapeArray[0]));

        System.out.print("\nName the sample file to store the array: ");

        String file = sc.next();

        /**
        The code shows saves the randomly generates array to a file
         */

        saveShapesToFile(file, shapeArray);

        /**
         * Create a empty array of 'arraySize' for storing the values from the file
         */
        Shape[] tempArray = new Shape[arraySize];


        /**
         * Reading the file of Shapes that was saved to a temporary Array for displaying
         */
      loadShapesToFile(file,tempArray);



        System.out.println("\nThe contents of the Temporary Array will be displayed\n");

        for (int i = 0; i < tempArray.length; i++) {
           System.out.println( tempArray[i]);
        }









    }//end main
}//end class
