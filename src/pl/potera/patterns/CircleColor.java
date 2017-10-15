package pl.potera.patterns;

import pl.potera.utils.ColorsUtils;

import java.util.stream.IntStream;

public class CircleColor extends Circle {

    int[] colors = {ColorsUtils.RED_RGB, ColorsUtils.BLUE_RGB, ColorsUtils.GREEN_RGB};

    public CircleColor(int width, int shadow) {
        super(width, shadow);
        FILE_NAME = "patterns/circle_color.jpg";
    }

    @Override
    int getPixelColor(int width, int shadow, double distance) {
        int ringIndex = (int) distance / width;
        int ringColor = getRingColor(ringIndex);
        boolean even = ringIndex % 2 == 0;
        if (isShadow(width, shadow, distance, ringIndex)) {
            double colorLevel = ((distance - ringIndex * width - (width - shadow)) / shadow * 100);
            double key = colorLevel * 255 / 100;
            double keyOutside = (100 - colorLevel) * 255 / 100;
            if(!even) ringColor = getRingColor(ringIndex +1);
            int newColor = ColorsUtils.mixColors(ringColor, ColorsUtils.WHITE_RGB, (int) (even ? keyOutside : key));
            return newColor;
        } else {
            return even ? ringColor : -1;
        }
    }

    int getRingColor(int ringIndex) {
        return colors[ringIndex % 3];
    }
}
