public class Pixel
{
    private int rgb;


    public Pixel()
    {
        this.rgb = 0;
    }

    public String toString()
    {
        String pixelString = "[Red: " + getRedVal()+ ", Green: " + getGreenVal() + ", Blue: " + getBlueVal() + "]";
        return pixelString;
    }

    public int getRedVal()
    {
        int redMask = 0b000000000000000011111111;

        int redVal = rgb & redMask;
        return redVal;
    }

    public void setRedVal(int rV)
    {
        if(rV >= 0 && rV <= 255)
        {
            this.rgb = rV;
        }
    }

    public int getGreenVal()
    {
        int greenMask = 0b000000001111111100000000;

        int greenVal = (rgb & greenMask) >> 8;
        return greenVal;
    }

    public void setGreenVal(int gV)
    {
        if(gV >= 0 && gV <= 255)
        {
            this.rgb = rgb + (gV << 8);
        }
    }

    public int getBlueVal()
    {
        int blueMask = 0b111111110000000000000000;

        int blueVal = (rgb & blueMask) >> 16;
        return blueVal;
    }

    public void setBlueVal(int bV)
    {
        if(bV >= 0 && bV <= 255)
        {
            this.rgb = rgb + (bV << 16);
        }
    }

    public String toHex(){
        String redHex = "";
        String greenHex = "";
        String blueHex = "";

        if(getRedVal() < 16) {
            redHex = "0";
        }

        if(getGreenVal() < 16) {
            greenHex = "0";
        }

        if(getBlueVal() < 16) {
            blueHex = "0";
        }

        redHex += Integer.toHexString(getRedVal());
        greenHex += Integer.toHexString(getGreenVal());
        blueHex += Integer.toHexString(getBlueVal());


        return "#" + redHex + greenHex + blueHex;
    }
}
