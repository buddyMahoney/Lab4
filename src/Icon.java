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
        String retVal = "";

        if(inBounds(row, col))
        {
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++) {
                    retVal = pixels.get(i).get(j).toString();
                }
            }
        }
        return retVal;
    }

    public void setPixelRGB(int row, int col, int rVal, int gVal, int bVal)
    {
        if(inBounds(row, col))
        {
            pixels.get(row).get(col).setRedVal(rVal);
            pixels.get(row).get(col).setGreenVal(gVal);
            pixels.get(row).get(col).setBlueVal(bVal);

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
