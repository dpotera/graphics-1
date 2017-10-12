package pl.potera.patterns;

import pl.potera.utils.FileUtils;
import pl.potera.utils.MathUtils;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

public class Grid {
    private static final String FILE_NAME = "patterns/grid.jpg";

    private int backgroundColor;
    private int lineColor;
    private int spaceWidth;
    private int spaceHeight;
    private int columnsWidth;
    private int rowsWidth;

    public Grid(int width, int x_space, int y_space, int background, int color) {
        this(width, width, x_space, y_space, background, color);
    }

    public Grid(int x_width, int y_width, int x_space, int y_space, int background, int color) {
        spaceWidth = x_space;
        spaceHeight = y_space;
        backgroundColor = background;
        lineColor = color;
        columnsWidth = x_width;
        rowsWidth = y_width;
    }

    public void renderImage(int x_res, int y_res) {
        RenderedImage image = generateImage(x_res, y_res);
        FileUtils.saveImage(image, FILE_NAME);
    }

    private RenderedImage generateImage(int x_res, int y_res) {
        BufferedImage image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
        return renderedOnImage(image);
    }

    private RenderedImage renderedOnImage(BufferedImage image) {
        for (int i = 0; i < image.getHeight(); i++)
            for (int j = 0; j < image.getWidth(); j++)
                image.setRGB(j, i, getPixelColor(distance(j, image.getWidth()), distance(i, image.getHeight())));
        return image;
    }

    private int getPixelColor(int x, int y) {
        boolean column = (x + spaceWidth / 4) % (spaceWidth / 2 + columnsWidth) > spaceWidth / 2;
        boolean row = (y + spaceHeight / 4) % (spaceHeight / 2 + rowsWidth) > spaceHeight / 2;
        return column || row ? lineColor : backgroundColor;
    }

    private static int distance(int x, int resolution){
        return Math.abs(resolution / 2 - x);
    }
}
