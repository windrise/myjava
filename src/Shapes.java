/*
多态
 */
import java.util.*;

class Shape{
    void draw(){};
    void erase(){};
}

class Circle extends Shape{
    void draw(){
        System.out.println("Calling Circle.draw()");
    }
    void earse(){
        System.out.println("Calling Circle.draw()");
    }
}
class Square extends Shape{
    void draw(){
        System.out.println("Calling Square.draw()");
    }
    void earse(){
        System.out.println("Calling Square.draw()");
    }
}
class Triangle extends Shape{
    void draw(){
        System.out.println("Calling Triangle.draw()");
    }
    void earse(){
        System.out.println("Calling Triangle.draw()");
    }
}

public class Shapes {
    static void drawOneShape(Shape s){
        s.draw();
    }
    static void drawShape(Shape[] ss){
        for(int i=0;i<ss.length;i++){
            ss[i].draw();
        }
    }

    public static void main(String[] args){
        Random rand = new Random();
        Shape[] s=new Shape[9];
        for(int i=0;i<s.length;i++){
            switch(rand.nextInt(3)){
                case 0: s[i] = new Circle(); break;
                case 1: s[i] = new Square(); break;
                case 2: s[i] = new Triangle(); break;

            }
        }
        drawShape(s);
    }


}
