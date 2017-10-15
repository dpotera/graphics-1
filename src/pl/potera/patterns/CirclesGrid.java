package pl.potera.patterns;

import pl.potera.utils.MathUtils;

import java.awt.image.BufferedImage;

public class CirclesGrid extends Circle {

    int fragmentWidth;
    int fragmentHeight;

    public CirclesGrid(int x_res, int y_res, int width, int shadow, int fragmentWidth, int fragmentHeight) {
        super(x_res, y_res, width, shadow);
        FILE_NAME = "patterns/circles_grid.jpg";
        this.fragmentWidth = fragmentWidth;
        this.fragmentHeight = fragmentHeight;
    }

    @Override
    void renderPixel(int width, int shadow, int x_res, int y_res, BufferedImage image, int x, int y) {
        int x_center = calculateFragmentCenter(y, y_res, fragmentHeight);
        int y_center = calculateFragmentCenter(x, x_res, fragmentWidth);
        int pixelColor = getPixelColor(width, shadow, MathUtils.distance(x, y, x_center, y_center));
        if (pixelColor >= 0) {
            image.setRGB(y, x, pixelColor);
        }
    }

    private int calculateFragmentCenter(int i, int i_res, int fragmentSize) {
        double column = ((double) i - (i_res + fragmentSize) / 2)/fragmentSize * fragmentSize ;
        int x_center = i_res / 2 - (-1) * (int) column / fragmentSize * fragmentSize ;
        return i > i_res / 2 + fragmentSize/2 ? x_center + fragmentSize : x_center;
    }
}
