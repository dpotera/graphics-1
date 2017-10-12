package pl.potera.patterns;

import pl.potera.utils.ColorsUtils;
import pl.potera.utils.FileUtils;
import pl.potera.utils.MathUtils;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

public class Grid {
    private static final String FILE_NAME = "patterns/grid.jpg";

    public  Grid(int x_res, int y_res, int x_width, int y_width, int x_space, int y_space) {
        System.out.println("Grid pattern synthesis");
        RenderedImage image = generateImage(x_res, y_res, x_width, y_width, x_space, y_space);
        FileUtils.saveImage(image, FILE_NAME);
    }

    private RenderedImage generateImage(int x_res, int y_res, int x_width, int y_width, int x_space, int y_space) {
        BufferedImage image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < y_res; i++)
            for (int j = 0; j < x_res; j++)
                image.setRGB(j, i,
                        getPixelColor(x_width, y_width, x_space/2, y_space/2,
                                MathUtils.calculateDistance(j, x_res),
                                MathUtils.calculateDistance(i, y_res)));
        return image;
    }

    private int getPixelColor(int x_width, int y_width, int x_space, int y_space, int x, int y) {
        int columnx = (x + x_space/2) % (x_space + x_width);
        boolean column = columnx > x_space;
        int rowx = (y + y_space/2) % (y_space + y_width);
        boolean row = rowx > y_space;
        return column || row ? ColorsUtils.BLACK_RGB : ColorsUtils.WHITE_RGB;
    }
}
