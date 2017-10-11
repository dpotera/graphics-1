package pl.potera.utils;

public class ColorsUtils {
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
}
