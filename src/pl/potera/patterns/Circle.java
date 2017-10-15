package pl.potera.patterns;

import pl.potera.utils.ColorsUtils;
import pl.potera.utils.FileUtils;
import pl.potera.utils.ImagesUtils;
import pl.potera.utils.MathUtils;

import java.awt.image.BufferedImage;

public class Circle {
    String FILE_NAME = "patterns/circle.jpg";

    int x_res;
    int y_res;
    int width;
    int shadow;

    public Circle(int width, int shadow) {
        this.width = width;
        this.shadow = shadow;
    }

    public Circle(int x_res, int y_res, int width, int shadow) {
        this(width, shadow);
        System.out.println("Circle pattern synthesis");
        this.x_res = x_res;
        this.y_res = y_res;
    }

    public void renderImage(int x_res, int y_res) {
        BufferedImage image = generateImage(x_res, y_res, width, shadow, ImagesUtils.whiteImage(x_res, y_res));
        FileUtils.saveImage(image, FILE_NAME);
    }

    public BufferedImage renderOnImage(BufferedImage image) {
        x_res = image.getWidth();
        y_res = image.getHeight();
        return generateImage(x_res, y_res, width, shadow, image);
    }

    BufferedImage generateImage(int x_res, int y_res, int width, int shadow, BufferedImage image) {
        for (int i = 0; i < y_res; i++)
            for (int j = 0; j < x_res; j++)
                renderPixel(width, shadow, x_res, y_res, image, i, j);
        return image;
    }

    void renderPixel(int width, int shadow, int x_res, int y_res, BufferedImage image, int i, int j) {
        int pixelColor = getPixelColor(width, shadow, MathUtils.distanceToCenter(i, j, x_res, y_res));
        if (pixelColor >= 0) {
            image.setRGB(j, i, pixelColor);
        }
    }

    int getPixelColor(int width, int shadow, double distance) {
        int ringIndex = (int) distance / width;
        boolean even = ringIndex % 2 == 0;
        if (isShadow(width, shadow, distance, ringIndex)) {
            int shadowColor = calculateShadowColor(distance, ringIndex, width, shadow);
            return ColorsUtils.int2RGB(even ? shadowColor : ColorsUtils.inverseColor(shadowColor));
        } else {
            return even ? ColorsUtils.BLACK_RGB : -1;
        }
    }

    boolean isShadow(int width, int shadow, double distance, int ringIndex) {
        return distance - ringIndex * width > width - shadow;
    }

    int calculateShadowColor(double distance, int ringIndex, int width, int shadow) {
        return (int) ((distance - ringIndex * width - (width - shadow)) / shadow * 100) * ColorsUtils.WHITE / 100;
    }
}
