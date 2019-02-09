package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class BrightFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to increase an image brightness by value of 100.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class westEdgeFilter extends PhotoFilter {

    private final int ADJUSTMENT = 100;

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It adds 100 to each RGB color component. The maxium value of each
    * component is limited to 255
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components has been increased
    */
    public int transformPixel(int inPixel, int inPixel0, int inPixel1, int inPixel2,
                              int inPixel3, int inPixel4, int inPixel5,
                              int inPixel6, int inPixel7) {

        int outPixel = (inPixel*-2 + inPixel0 + inPixel1 + inPixel2*-1 + inPixel3 + -1*inPixel4
                + inPixel5 + inPixel6 + -1*inPixel7)/9;
        int red = constrain(Color.red(outPixel));
        int green = constrain(Color.green(outPixel));
        int blue = constrain(Color.blue(outPixel));

        int avg = (red + green + blue)/3;

        return Color.argb(Color.alpha(inPixel), avg, avg, avg);
    }
}
