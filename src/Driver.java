public class Driver {
    public static void main(String[] args){
        System.out.println("Welcome to Lab 4! \n");

        Pixel p1 = new Pixel();

        System.out.println(p1.toString());
        System.out.println("\n");

        Pixel p2 = new Pixel();

        p2.setRedVal(20);
        p2.setGreenVal(40);
        p2.setBlueVal(60);

        System.out.println(p2.toString());
        System.out.println("\n");

        Pixel p3 = new Pixel();

        p3.setRedVal(6000);
        p3.setGreenVal(-1);
        p3.setBlueVal(25);

        System.out.println(p3.toString());
        System.out.println("\n");

        Icon i = new Icon();

        System.out.println(i.toString());

        Icon i2 = new Icon(2,2);

        i2.setPixelRGB(0,0,20,20,60);
        i2.setPixelRGB(1,1,30,30,60);

        System.out.println(i2.toString());
        System.out.println("\n");

        System.out.println(i2.getPixelRGB(1,1));
        System.out.println("\n");

        System.out.println(p2.toHex());
        System.out.println(p3.toHex());

    }
}
