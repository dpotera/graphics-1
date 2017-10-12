package pl.potera.utils;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static String saveImage(RenderedImage image, String fileName) {
        try {
            ImageIO.write(image, "jpg", new File(fileName));
            return fileName + " created successfully";
        } catch (IOException e) {
            return fileName + " cannot be stored";
        }
    }

}
