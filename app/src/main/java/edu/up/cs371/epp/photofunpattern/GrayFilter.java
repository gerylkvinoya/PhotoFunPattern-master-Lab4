package edu.up.cs371.epp.photofunpattern;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 *  class GrayFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to convert the image to gray scale.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class GrayFilter extends PhotoFilter {

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It transforms a color pixel to gray by averaging its three RGB
    * components.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components is their averaged
    * value
    */
    public int transformPixel(int p0, int p1, int p2,int p3, int p4, int p5, int p6, int p7) {
        int intensity = (Color.red(p4) + Color.green(p4) +
                Color.blue(p4)) / 3;
        //int ret = ((p0/10) + (p1/10) + (p2/10) + (p3/10) + (p4/5) + (p5/10) + (p6/10) + (p7/10) + (p8/10));
        return Color.argb(Color.alpha(p4), intensity,intensity,intensity);

    }


    public Bitmap apply(Bitmap inBmp) {
        int width = inBmp.getWidth();
        int height = inBmp.getHeight();

        Bitmap newBmp = Bitmap.createBitmap(width, height, inBmp.getConfig());
        int p0, p1, p2, p3, p4, p5, p6, p7, p8;
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                p4 = inBmp.getPixel(w,h);
                //if(w == 0 && h == 0){
                //    p0 =
                //}
                /*
                if((w-1) >= 0 && (h-1) >= 0)
                {
                    p0 = inBmp.getPixel(w-1,h-1);
                }
                else
                {
                    p0 = 0;
                }

                if((h-1) >= 0)
                {
                    p1 = inBmp.getPixel(w,h-1);
                }
                else
                {
                    p1 = 0;
                }

                if((w+1) < width && (h-1) >= 0)
                {
                    p2 = inBmp.getPixel(w+1,h-1);
                }
                else
                {
                    p2 = 0;
                }

                if((w-1) >= 0)
                {
                    p3 = inBmp.getPixel(w-1,h);
                }
                else
                {
                    p3 = 0;
                }

                if((w+1) < width)
                {
                    p5 = inBmp.getPixel(w+1,h);
                }
                else
                {
                    p5 = 0;
                }

                if((w-1) >= 0 && (h+1) < height)
                {
                    p6 = inBmp.getPixel(w-1,h+1);
                }
                else
                {
                    p6 = 0;
                }

                if((h+1) < height)
                {
                    p7 = inBmp.getPixel(w,h+1);
                }
                else
                {
                    p7 = 0;
                }

                if((w+1) < width && (h+1) < height)
                {
                    p8 = inBmp.getPixel(w+1,h+1);
                }
                else
                {
                    p8 = 0;
                }*/
                int outPixel = transformPixel(0,0,0,0,p4,0,0,0,0);
                newBmp.setPixel(w, h, outPixel);
            }
        }
        return newBmp;
    }
}
