package pl.potera.utils;

public class MathUtils {

    public static int calculateDistance(int x, int x_res){
        return Math.abs(x_res / 2 - x);
    }
    public static double calculateDistance(int x, int y, int x_res, int y_res){
        int x_center = x_res / 2, y_center = y_res / 2;
        return Math.sqrt((x - y_center) * (x - y_center) + (y - x_center) * (y - x_center));
    }
}
