package pl.potera.patterns;

import pl.potera.utils.ColorsUtils;
import pl.potera.utils.FileUtils;
import pl.potera.utils.MathUtils;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

public class Grid {
    private static final String FILE_NAME = "patterns/grid.jpg";

    public  Grid(int x_res, int y_res, int width) {
        System.out.println("Grid pattern synthesis");
        RenderedImage image = generateImage(x_res, y_res, width);
        FileUtils.saveImage(image, FILE_NAME);
    }

    private RenderedImage generateImage(int x_res, int y_res, int width) {
        BufferedImage image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < y_res; i++)
            for (int j = 0; j < x_res; j++)
                image.setRGB(j, i,
                        getPixelColor(width,
                                MathUtils.calculateDistance(j, x_res),
                                MathUtils.calculateDistance(i, y_res)));
        return image;
    }

    private int getPixelColor(int width, int x, int y) {
        boolean column = ((x + width / 2) / width) % 2 == 0;
        boolean row = ((y + width / 2) / width) % 2 == 0;
        return column && row ? ColorsUtils.WHITE_RGB : ColorsUtils.BLACK_RGB;
    }
}
