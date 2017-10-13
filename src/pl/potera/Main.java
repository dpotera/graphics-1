package pl.potera;

import pl.potera.patterns.Chessboard;
import pl.potera.patterns.Grid;
import pl.potera.patterns.Ring;
import pl.potera.utils.ColorsUtils;
import pl.potera.utils.FileUtils;
import sun.awt.image.OffScreenImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int x_res = 800, y_res = 800;

        Ring ring = new Ring(x_res, y_res, 20, 0);

        Grid grid = new Grid(20, 200, 200, ColorsUtils.BLACK_RGB);
        grid.renderImage(x_res, y_res);
        BufferedImage wroclaw_grid = grid.renderOnImage(readWroclawImage());
        FileUtils.saveImage(wroclaw_grid, "patterns/wroclaw_grid.jpg");

        Chessboard chessboard = new Chessboard(50, ColorsUtils.BLACK_RGB);
        chessboard.renderImage(x_res, y_res);
        BufferedImage wroclaw_chessboard = chessboard.renderOnImage(readWroclawImage());
        FileUtils.saveImage(wroclaw_chessboard, "patterns/wroclaw_chessboard.jpg");



    }

    private static BufferedImage readWroclawImage() throws IOException {
        try {
            return ImageIO.read(new File("images/wroclaw.jpg"));
        } catch (IOException e) {
            throw new IOException("failed to open file");
        }
    }
}
