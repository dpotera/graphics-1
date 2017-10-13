package pl.potera.patterns;

import pl.potera.utils.FileUtils;
import pl.potera.utils.ImagesUtils;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

public class Grid {
    String FILE_NAME = "patterns/grid.jpg";

    int lineColor;
    int spaceWidth;
    int spaceHeight;
    int columnsWidth;
    int rowsWidth;

    public Grid(int width, int x_space, int y_space, int color) {
        this(width, width, x_space, y_space, color);
    }

    public Grid(int x_width, int y_width, int x_space, int y_space, int color) {
        spaceWidth = x_space;
        spaceHeight = y_space;
        lineColor = color;
        columnsWidth = x_width;
        rowsWidth = y_width;
    }

    public void renderImage(int x_res, int y_res) {
        RenderedImage image = generateImage(x_res, y_res);
        FileUtils.saveImage(image, FILE_NAME);
    }

    private RenderedImage generateImage(int x_res, int y_res) {
        return renderOnImage(ImagesUtils.whiteImage(x_res, y_res));
    }

    public BufferedImage renderOnImage(BufferedImage image) {
        for (int i = 0; i < image.getHeight(); i++)
            for (int j = 0; j < image.getWidth(); j++){
                int pixelColor = getPixelColor(distance(j, image.getWidth()), distance(i, image.getHeight()));
                if(pixelColor >= 0) {
                    image.setRGB(j, i, pixelColor);
                }
            }
        return image;
    }

    int getPixelColor(int x, int y) {
        boolean column = (x + spaceWidth / 4) % (spaceWidth / 2 + columnsWidth) > spaceWidth / 2;
        boolean row = (y + spaceHeight / 4) % (spaceHeight / 2 + rowsWidth) > spaceHeight / 2;
        return column || row ? lineColor : -1;
    }

    private static int distance(int x, int resolution){
        return Math.abs(resolution / 2 - x);
    }
}
