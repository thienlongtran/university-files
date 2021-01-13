public class Main{
    public static void main(String[] args){
        Square passion = new Square(10);
        passion.calculateArea();
        passion.calculateAngles();
        System.out.println(passion.getArea());
        System.out.println(passion.getAngles());

        Triangle melody = new Triangle(8);
        melody.calculateArea();
        melody.calculateAngles();
        System.out.println(melody.getArea());
        System.out.println(melody.getAngles());
    }
}