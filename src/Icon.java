import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;

public class Icon
{
    private ArrayList < ArrayList < Pixel >> pixels = new ArrayList < ArrayList < Pixel >>();

    public Icon()
    {
        //creates a 40 by 40 ArrayList of Pixels
        this(40,40);
    }

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

    public void createBitmap(String filePath)
    {
        //convert the ArrayList of Bytes into an array of bytes
        ArrayList<Byte> pixelBytes = new ArrayList<Byte>();

        //file header
        pixelBytes.addAll(fileHeader());
        //info header
        pixelBytes.addAll(infoHeader());
        //pixel data
        pixelBytes.addAll(pixelData());

        byte[] bytes = new byte[pixelBytes.size()];

        for (int i = 0; i < pixelBytes.size(); i++)
        {
            bytes[i] = pixelBytes.get(i);
        }


        //write bytes to file
        try (FileOutputStream fos = new FileOutputStream(filePath))
        {
            fos.write(bytes);
            System.out.println("Data successfully written to " + filePath);
        } catch (IOException e)
        {
            System.err.println("An error occurred while writing the file: " + e.getMessage());
        }
    }


    public ArrayList<Byte> fileHeader()
    {
        ArrayList<Byte> headerBytes = new ArrayList<Byte>();

        // Ascii BM
        headerBytes.add((byte) 66);
        headerBytes.add((byte) 77);

        //Size of File
        headerBytes.addAll(toLittleEndian4Bytes(getFileSize()));

        //4 bytes unused
        headerBytes.addAll(toLittleEndian4Bytes(0));

        //offset of pixel data
        headerBytes.addAll(toLittleEndian4Bytes(54));


        return headerBytes;
    }

    public ArrayList<Byte> infoHeader()
    {
        ArrayList<Byte> headerBytes = new ArrayList<Byte>();

        //size of info header
        headerBytes.addAll(toLittleEndian4Bytes(40));

        //width of bitmap
        headerBytes.addAll(toLittleEndian4Bytes(pixels.get(0).size()));
        //height of bitmap
        headerBytes.addAll(toLittleEndian4Bytes(pixels.size()));

        //# of planes
        headerBytes.addAll(toLittleEndian2Bytes(1));
        //bits/color
        headerBytes.addAll(toLittleEndian2Bytes(24));
        //compression
        headerBytes.addAll( toLittleEndian4Bytes(0));
        //int x = getPixelDataSize();

        //pixel data size
        headerBytes.addAll( toLittleEndian4Bytes(getPixelDataSize()));

        //unused
        headerBytes.addAll(toLittleEndian4Bytes(0));
        headerBytes.addAll(toLittleEndian4Bytes(0));
        headerBytes.addAll(toLittleEndian4Bytes(0));
        headerBytes.addAll(toLittleEndian4Bytes(0));


        return headerBytes;
    }

    public int getFileSize()
    {
        //headers = 54 bits
        return getPixelDataSize() + 54;
    }

    public int getPixelDataSize()
    {
        int height = pixels.size();
        int width = pixels.get(0).size();

        int bytesPerPixel = 3;

        int rowSize = width * bytesPerPixel;
        int paddedRowSize = rowSize + getPaddingBytes(rowSize);
        int pixelDataSize = paddedRowSize * height;

        return pixelDataSize;
    }

    public int getPaddingBytes(int rowSize)
    {
       int retVal = 0;
        if(rowSize % 4 == 1)
        {
            retVal = 3;
        }else if(rowSize % 4 == 2)
        {
            retVal = 2;
        }else if(rowSize % 4 == 3)
        {
            retVal = 1;
        }

        return retVal;
    }

    public ArrayList<Byte> pixelData()
    {
        ArrayList<Byte> pixelBytes = new ArrayList<Byte>();

        for(int i = pixels.size() - 1; i >= 0; i--)
        {
            for(int j = 0; j < pixels.getFirst().size(); j++)
            {
                //get the RGB vals for each pixel
                pixelBytes.add((byte) pixels.get(i).get(j).getBlueVal());
                pixelBytes.add((byte) pixels.get(i).get(j).getGreenVal());
                pixelBytes.add((byte) pixels.get(i).get(j).getRedVal());
            }
            int width = pixels.get(0).size();

            int bytesPerPixel = 3;

            int rowSize = width * bytesPerPixel;
            int padding = getPaddingBytes(rowSize);

            //get the padding
            if(padding == 1)
            {
                pixelBytes.add((byte) 0);
            } else if(padding == 2)
            {
                pixelBytes.add((byte) 0);
                pixelBytes.add((byte) 0);

            }else if(padding == 3)
            {
                pixelBytes.add((byte) 0);
                pixelBytes.add((byte) 0);
                pixelBytes.add((byte) 0);

            }
        }

        return pixelBytes;
    }

    //returns an arrayList of 2 bytes in little endian
    public ArrayList < Byte > toLittleEndian2Bytes(int num)
    {
        ArrayList < Byte > retVal = new ArrayList< Byte >();

        //num = Integer.reverse(num);
        byte byteOne = (byte)(num & 0b00000000000000000000000011111111);
        byte byteTwo = (byte)((num & 0b00000000000000001111111100000000) >> 8);

        retVal.add(byteOne);
        retVal.add(byteTwo);

        return retVal;
    }

    //returns an arrayList of 4 bytes in little endian
    public ArrayList < Byte > toLittleEndian4Bytes(int num)
    {
        ArrayList < Byte > retVal = new ArrayList< Byte >();

        //num = Integer.reverse(num);
        byte byteOne = (byte)(num & 0b00000000000000000000000011111111);
        byte byteTwo = (byte)((num & 0b00000000000000001111111100000000) >> 8);
        byte byteThree = (byte)((num & 0b00000000111111110000000000000000) >> 16);
        byte byteFour = (byte)((num & 0b11111111000000000000000000000000) >> 24);

        retVal.add(byteOne);
        retVal.add(byteTwo);
        retVal.add(byteThree);
        retVal.add(byteFour);

        return retVal;
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

    //allows the user to select a specific pixel and set the RGB values
    public void setPixelRGB(int row, int col, int rVal, int gVal, int bVal)
    {
        if(inBounds(row, col))
        {
            pixels.get(row).get(col).setRedVal(rVal);
            pixels.get(row).get(col).setGreenVal(gVal);
            pixels.get(row).get(col).setBlueVal(bVal);

        }else{
            System.out.println("Out of Bounds! row:" + row + ", col:" + col);
            System.exit(256);
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
                rgbVals = rgbVals + pixels.get(i).get(j).toHex() + "\t";
            }
            rgbVals = rgbVals + "\n";
        }
        return rgbVals;
    }
}
