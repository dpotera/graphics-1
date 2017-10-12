package pl.potera;

import pl.potera.patterns.Grid;
import pl.potera.patterns.Ring;
import pl.potera.utils.ColorsUtils;

public class Main {

    public static void main(String[] args) {

        int x_res = 800, y_res = 700;
        new Ring(x_res, y_res, 20, 0);
        Grid grid = new Grid(10, 100, 60, ColorsUtils.BLUE_RGB, ColorsUtils.BLACK_RGB);
        grid.renderImage(x_res, y_res);

    }
}
