package pl.potera.utils;

import java.awt.image.BufferedImage;

public class ImagesUtils {

    public static BufferedImage renderImage(int width, int height, int colorRGB) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        return fillImage(image, colorRGB);
    }

    public static BufferedImage whiteImage(int width, int height) {
        return renderImage(width, height, ColorsUtils.WHITE_RGB);
    }

    private static BufferedImage fillImage(BufferedImage image, int color){
        for (int i = 0; i < image.getHeight(); i++)
            for (int j = 0; j < image.getWidth(); j++)
                    image.setRGB(j, i, color);
        return image;
    }
}
