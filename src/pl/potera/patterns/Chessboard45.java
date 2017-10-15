package pl.potera.patterns;

import pl.potera.utils.MathUtils;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Chessboard45 extends Chessboard {

    private static final double ANGLE = 0.7853981634;

    public Chessboard45(int squareSize, int color) {
        super(squareSize, color);
        FILE_NAME = "patterns/chessboard45.jpg";
    }

    @Override
    void renderPixel(BufferedImage image, int i, int j) {
        Point point = rotatePoint(new Point(j, i));
        int pixelColor = getPixelColor(point.x, point.y);
        if (pixelColor >= 0) {
            image.setRGB(j, i, pixelColor);
        }
    }

    private Point rotatePoint(Point point) {
        int centerX = width / 2, centerY = height / 2;
        double cosX = Math.cos(ANGLE), sinX = Math.sin(ANGLE);
        double newX = centerX + (cosX * (point.x - centerX) + sinX * (point.y - centerY));
        double newY = centerY + (-sinX * (point.x - centerX) + cosX * (point.y - centerY));
        return new Point(MathUtils.distance((int) newX, centerX), MathUtils.distance((int) newY, centerY));
    }
}
