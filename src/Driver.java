public class Driver {
    public static void main(String[] args){
        System.out.println("Welcome to Lab 4!");

        Pixel p1 = new Pixel();

        System.out.println(p1.toString());

        Pixel p2 = new Pixel();

        p2.setRedVal(20);
        p2.setGreenVal(40);
        p2.setBlueVal(60);

        System.out.println(p2.toString());

        Pixel p3 = new Pixel();

        p3.setRedVal(6000);
        p3.setGreenVal(-1);
        p3.setBlueVal(25);

        System.out.println(p3.toString());

    }
}
