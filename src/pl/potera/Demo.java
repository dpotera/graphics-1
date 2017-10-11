package pl.potera;

import pl.potera.utils.ColorsUtils;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Ring pattern synthesis");

        // Fixed ring width
        final int width = 50;
        final int shadow = 2;
        final String fileName = "image.bmp";

        BufferedImage image;

        int x_res = 400, y_res = 400;


        // Initialize an empty image, use pixel format
        // with RGB packed in the integer data type
        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        // Predefined black and white RGB representations
        // packed as integers
        // Create packed RGB representation of black and white colors
        int black = ColorsUtils.int2RGB(0);
        int white = ColorsUtils.int2RGB(255);

        // Ring center coordinates
        // Find coordinates of the image center
        int x_c = x_res / 2;
        int y_c = y_res / 2;

        // Process the image, pixel by pixel
        for (int i = 0; i < y_res; i++)
            for (int j = 0; j < x_res; j++) {
                // Calculate distance to the image center
                double d = Math.sqrt((i - y_c) * (i - y_c) + (j - x_c) * (j - x_c));

                // Find the ring index
                int r = (int) d / width;

                // Even ring - set black color
                boolean even = r % 2 == 0;
                if (d - r * width > width - shadow) {
                    int color = (int) ((d - r * width - (width - shadow)) / shadow * 100) * 255 / 100;
                    image.setRGB(j, i, ColorsUtils.int2RGB(even ? color : 255 - color));
                } else {
                    image.setRGB(j, i, even ? black : white);
                }
            }

        // Save the created image in a graphics file
        try {
            ImageIO.write(image, "bmp", new File(fileName));
            System.out.println("Ring image created successfully");
        } catch (IOException e) {
            System.out.println("The image cannot be stored");
        }
    }
}