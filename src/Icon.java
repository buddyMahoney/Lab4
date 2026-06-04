import java.util.ArrayList;


public class Icon
{
    private ArrayList < ArrayList < Pixel >> pixels = new ArrayList < ArrayList < Pixel >>();

    // this is not quite right
    public Icon()
    {
        int defaultSize = 5;
        for(int row = 0; row < defaultSize; row++)
        {
            ArrayList < Pixel > pixel = new ArrayList < Pixel >();
            for(int col = 0; col < defaultSize; col++)
            {
                Pixel p = new Pixel();
                pixel.add(p);
            }
            pixels.add(pixel);
        }
    }

    // this is not quite right
    public Icon(int rows, int cols)
    {
        for(int i = 0; i < rows; i++)
        {
            ArrayList < Pixel > pixel = new ArrayList < Pixel >();
            for(int j = 0; j < cols; j++)
            {
                Pixel p = new Pixel();
                pixel.add(p);
            }
            pixels.add(pixel);
        }
    }

    // State management
    public String getPixelRGB(int row, int col)
    {
        if(inBounds(row, col))
        {

        }

    }

    public void setPixelRGB(int row, int col){
        if(inBounds(row, col))
        {

        }
    }

    private boolean inBounds(int row, int col)
    {
        boolean retVal = false;

        if(row >= 0 && row < pixels.size() && col >= 0 && col < pixels.get(row).size()){
            retVal = true;
        }

        return retVal;
    }

    //output
    public String toString() {
        String rgbVals = "";

        for (int i = 0; i < pixels.size(); i++)
        {
            for (int j = 0; j < pixels.get(i).size(); j++)
            {
                rgbVals = rgbVals + pixels.get(i).get(j).toString() + "\t";
            }
            rgbVals = rgbVals + "\n";
        }
        return rgbVals;
    }
}
