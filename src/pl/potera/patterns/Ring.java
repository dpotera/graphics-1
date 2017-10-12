package pl.potera.patterns;

import pl.potera.utils.ColorsUtils;
import pl.potera.utils.FileUtils;
import pl.potera.utils.MathUtils;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

public class Ring {
    private static final String FILE_NAME = "patterns/ring.jpg";

    public Ring(int x_res, int y_res, int width, int shadow) {
        System.out.println("Ring pattern synthesis");
        RenderedImage image = generateImage(x_res, y_res, width, shadow);
        FileUtils.saveImage(image, FILE_NAME);
    }

    private RenderedImage generateImage(int x_res, int y_res, int width, int shadow) {
        BufferedImage image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < y_res; i++)
            for (int j = 0; j < x_res; j++)
                image.setRGB(j, i, getPixelColor(width, shadow, MathUtils.distanceToCenter(i, j, x_res, y_res)));
        return image;
    }

    private int getPixelColor(int width, int shadow, double distance) {
        int ringIndex = (int) distance / width;
        boolean even = ringIndex % 2 == 0;
        if (isShadow(width, shadow, distance, ringIndex)) {
            int shadowColor = calculateShadowColor(distance, ringIndex, width, shadow);
            return ColorsUtils.int2RGB(even ? shadowColor : ColorsUtils.inverseColor(shadowColor));
        } else {
            return even ? ColorsUtils.BLACK_RGB : ColorsUtils.WHITE_RGB;
        }
    }

    private boolean isShadow(int width, int shadow, double distance, int ringIndex) {
        return distance - ringIndex * width > width - shadow;
    }

    private int calculateShadowColor(double distance, int ringIndex, int width, int shadow) {
        return (int) ((distance - ringIndex * width - (width - shadow)) / shadow * 100) * ColorsUtils.WHITE / 100;
    }
}
