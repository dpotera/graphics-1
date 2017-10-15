package pl.potera.patterns;

import pl.potera.utils.FileUtils;
import pl.potera.utils.ImagesUtils;
import pl.potera.utils.MathUtils;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

public class Radius {

    private String FILE_NAME = "patterns/radius.jpg";
    private int radius;
    private int color;

    public Radius(int radius, int color) {
        this.radius = radius;
        this.color = color;
    }


    public void renderImage(int x_res, int y_res) {
        RenderedImage image = generateImage(x_res, y_res);
        FileUtils.saveImage(image, FILE_NAME);
    }

    private RenderedImage generateImage(int x_res, int y_res) {
        return renderOnImage(ImagesUtils.whiteImage(x_res, y_res));
    }

    public BufferedImage renderOnImage(BufferedImage img) {
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                double distanceX = x - img.getWidth()/2, distanceY = y - img.getHeight()/2;
                double angle = Math.abs(Math.toDegrees(Math.atan(distanceY / distanceX)));

                if (distanceX > 0 && distanceY < 0)
                    angle = 180 - angle;
                else if (distanceX >= 0 && distanceY >= 0)
                    angle += 180;
                else if (distanceX < 0 && distanceY > 0)
                    angle = 360 - angle;

                if ((int) (angle / radius) % 2 == 0)
                    img.setRGB(x, y, color);
            }
        }
        return img;
    }
}
