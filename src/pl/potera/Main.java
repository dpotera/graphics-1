package pl.potera;

import pl.potera.patterns.Chessboard;
import pl.potera.patterns.Grid;
import pl.potera.patterns.Ring;
import pl.potera.utils.ColorsUtils;

public class Main {

    public static void main(String[] args) {

        int x_res = 800, y_res = 800;

        Ring ring = new Ring(x_res, y_res, 20, 0);

        Grid grid = new Grid(50, 200, 200, ColorsUtils.BLACK_RGB);
        grid.renderImage(x_res, y_res);

        Chessboard chessboard = new Chessboard(50, ColorsUtils.BLACK_RGB);
        chessboard.renderImage(x_res, y_res);



    }
}
