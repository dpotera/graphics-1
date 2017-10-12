package pl.potera.utils;

public class ColorsUtils {
    public static final int BLACK = 0;
    public static final int WHITE = 255;
    public static final int BLACK_RGB = int2RGB(0);
    public static final int WHITE_RGB = int2RGB(255);
    public static final int RED_RGB = int2RGB(255, 0, 0);
    public static final int GREEN_RGB = int2RGB(0, 255, 0);
    public static final int BLUE_RGB = int2RGB(0, 0, 255);

    // This method assembles RGB color intensities into single
    // packed integer. Arguments must be in <0..255> range
    public static int int2RGB(int color) {
        return int2RGB(color, color, color);
    }

    public static int int2RGB(int red, int green, int blue) {
        // Make sure that color intensities are in 0..255 range
        red = red & 0x000000FF;
        green = green & 0x000000FF;
        blue = blue & 0x000000FF;

        // Assemble packed RGB using bit shift operations
        return (red << 16) + (green << 8) + blue;
    }

    public static int inverseColor(int color) {
        return WHITE - color;
    }
}
