package Utils;

public class DirectionChecker {
    public static boolean checkUp(int x, int y, int xToCompare, int yToCompare){return x == xToCompare && y-1 == yToCompare;}
    public static boolean checkDown(int x, int y, int xToCompare, int yToCompare){return x == xToCompare && y+1 == yToCompare;}
    public static boolean checkLeft(int x, int y, int xToCompare, int yToCompare){return x-1 == xToCompare && y == yToCompare;}
    public static boolean checkRight(int x, int y, int xToCompare, int yToCompare){return x+1 == xToCompare && y == yToCompare;}
}
