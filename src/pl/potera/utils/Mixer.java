package pl.potera.utils;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class Mixer {

    public static BufferedImage mixImages(BufferedImage img1, BufferedImage img2, BufferedImage pattern) {
        BufferedImage result = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < pattern.getHeight(); y++) {
            for (int x = 0; x < pattern.getWidth(); x++) {
                int rgb = pattern.getRGB(x, y);
                int key = IntStream.of(ColorsUtils.RGB2int(rgb)).sum()/3;
                int newColor = ColorsUtils.mixColors(img1.getRGB(x, y), img2.getRGB(x, y), key);
                result.setRGB(x,y,newColor);
            }
        }
        return result;
    }

}
