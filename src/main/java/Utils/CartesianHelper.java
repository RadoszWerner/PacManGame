package Utils;

public class CartesianHelper {
    public static int getIndexByCoordinates(int x, int y, int cols){
        return y*cols+x;
    }
}
