package pl.potera.patterns;

public class Chessboard extends Grid {

    public Chessboard(int squareSize, int color) {
        super(squareSize, squareSize * 2, squareSize * 2, color);
        FILE_NAME = "patterns/chessboard.jpg";
    }

    @Override
    int getPixelColor(int x, int y) {
        boolean column = (x + spaceWidth / 4) % (spaceWidth / 2 + columnsWidth) > spaceWidth / 2;
        boolean row = (y + spaceHeight / 4) % (spaceHeight / 2 + rowsWidth) > spaceHeight / 2;
        return column ^ row ? lineColor : -1;
    }
}
