package pl.potera.utils;

public class MathUtils {


    public static double distanceToCenter(int x, int y, int x_res, int y_res){
        return distance(x, y, x_res /2, y_res / 2);
    }

    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt((x1 - y2) * (x1 - y2) + (y1 - x2) * (y1 - x2));
    }

    public static int distance(int x, int resolution){
        return Math.abs(resolution / 2 - x);
    }
}
