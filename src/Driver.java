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

        Icon i = new Icon(2, 17);
        i.setPixelRGB(0, 0, 255, 0, 0);
        i.setPixelRGB(0, 4, 0, 255, 0);
        i.setPixelRGB(4, 0 , 0, 0, 255);
        i.setPixelRGB(4, 4 , 255, 255, 255);


        System.out.println(i.toString());

        Icon i2 = new Icon(2,2);

        i2.setPixelRGB(0,0,0,0,255);
        i2.setPixelRGB(0,1,0,255,0);
        i2.setPixelRGB(1,0,255,0,0);
        i2.setPixelRGB(1,1,255,255,255);

        System.out.println(i2.toString());
        System.out.println("\n");

        System.out.println(i2.getPixelRGB(1,1));
        System.out.println("\n");

        System.out.println(p2.toHex());
        System.out.println(p3.toHex());

        Pixel p4 = new Pixel();
        System.out.println(p4.toHex()); //#000000 two digits for each color

//give each color a value
        p4.setRedVal(20);
        p4.setGreenVal(40);
        p4.setBlueVal(60);
        System.out.println(p4.toHex()); //#14283C

//change green only
        p4.setGreenVal(140);
        System.out.println(p4.toHex()); //#148C3C 14 and 3C should not change

        i2.createBitmap("/Users/buddymahoney/Documents/test.bmp");
        i.createBitmap("/Users/buddymahoney/Documents/test2.bmp");
        //Icon i3 = new Icon();
    }
}
