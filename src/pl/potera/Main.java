package pl.potera;

import pl.potera.patterns.*;
import pl.potera.utils.ColorsUtils;
import pl.potera.utils.FileUtils;
import pl.potera.utils.ImagesUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int x_res = 800, y_res = 800;

        Circle circle = new Circle(30, 2);
        circle.renderImage(x_res, y_res);
        BufferedImage wroclaw_circle = circle.renderOnImage(readWroclawImage());
        FileUtils.saveImage(wroclaw_circle, "patterns/wroclaw_circle.jpg");

        CirclesGrid circlesGrid = new CirclesGrid(x_res, y_res, 40, 0, 100, 100);
        circlesGrid.renderImage(x_res, y_res);
        BufferedImage wroclaw_circles_grid = circlesGrid.renderOnImage(readWroclawImage());
        FileUtils.saveImage(wroclaw_circles_grid, "patterns/wroclaw_circles_grid.jpg");

        circlesGrid = new CirclesGrid(x_res, y_res, 40, 0, 100, 100);
        circlesGrid.renderImage(x_res, y_res);
        BufferedImage bigCircles = circlesGrid.renderOnImage(ImagesUtils.whiteImage(x_res, y_res));
        FileUtils.saveImage(bigCircles, "patterns/big_circles.jpg");

        Grid grid = new Grid(20, 200, 200, ColorsUtils.BLACK_RGB);
        grid.renderImage(x_res, y_res);
        BufferedImage wroclaw_grid = grid.renderOnImage(readWroclawImage());
        FileUtils.saveImage(wroclaw_grid, "patterns/wroclaw_grid.jpg");

        Chessboard chessboard = new Chessboard(50, ColorsUtils.BLACK_RGB);
        chessboard.renderImage(x_res, y_res);
        BufferedImage wroclaw_chessboard = chessboard.renderOnImage(readWroclawImage());
        FileUtils.saveImage(wroclaw_chessboard, "patterns/wroclaw_chessboard.jpg");

        Chessboard45 chessboard45 = new Chessboard45(50, ColorsUtils.BLACK_RGB);
        chessboard45.renderImage(x_res, y_res);
        BufferedImage wroclaw_chessboard45 = chessboard45.renderOnImage(readWroclawImage());
        FileUtils.saveImage(wroclaw_chessboard45, "patterns/wroclaw_chessboard45.jpg");



    }

    private static BufferedImage readWroclawImage() throws IOException {
        try {
            return ImageIO.read(new File("images/wroclaw.jpg"));
        } catch (IOException e) {
            throw new IOException("failed to open file");
        }
    }
}
