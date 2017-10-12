package pl.potera.utils;

public class MathUtils {


    public static double distanceToCenter(int x, int y, int x_res, int y_res){
        int x_center = x_res / 2, y_center = y_res / 2;
        return Math.sqrt((x - y_center) * (x - y_center) + (y - x_center) * (y - x_center));
    }
}
