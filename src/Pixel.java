public class Pixel
{
    private int redVal;
    private int greenVal;
    private int blueVal;

    public Pixel()
    {
        this.redVal = 0;
        this.greenVal = 0;
        this.blueVal = 0;
    }

    public String toString()
    {
        String pixelString = "[Red: " + getRedVal()+ ", Green: " + getGreenVal() + ", Blue: " + getBlueVal() + "]";
        return pixelString;
    }

    public int getRedVal()
    {
        return redVal;
    }

    public void setRedVal(int rV)
    {
        if(rV >= 0 && rV <= 255)
        {
            this.redVal = rV;
        }
    }

    public int getGreenVal()
    {
        return greenVal;
    }

    public void setGreenVal(int gV)
    {
        if(gV >= 0 && gV <= 255)
        {
            this.greenVal = gV;
        }
    }

    public int getBlueVal()
    {
            return blueVal;
    }

    public void setBlueVal(int bV)
    {
        if(bV >= 0 && bV <= 255)
        {
            this.blueVal = bV;
        }
    }
}
