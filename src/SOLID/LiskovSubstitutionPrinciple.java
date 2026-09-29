package SOLID;
/*
If S is a subtype of T, then objects of type T may be replaced with objects of type S without altering the correctness of the program.
This means that any subclass should be substitutable for its parent class without breaking the functionality.

Think of it like this:
If you write code using a parent class (say Shape), and later swap in a child class (using the child class object in place of the parent class object) (like Circle), the code should still work without errors or unexpected behavior.
If the subclass changes behavior in a way that breaks expectations, it violates LSP

 */



class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle{
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Ensure height is always equal to width for a square
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // Ensure width is always equal to height for a square
    }
}
public class LiskovSubstitutionPrinciple{
    public static void main(String args[]){
    // Create a Rectangle object and calculate its area
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println("Rectangle Area: " + rectangle.getArea()); // Output: 50

        // Now, let's use a Square object in place of a Rectangle
        Rectangle square = new Square();
        square.setWidth(5);
        System.out.println("Square Area: " + square.getArea()); // Output: 25

    }
}
