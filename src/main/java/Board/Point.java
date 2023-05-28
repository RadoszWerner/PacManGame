package Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Point extends BoardItem{
    public Point(int x, int y) {
        super(x, y, Color.GRAY);
    }
    public int getLayer(){
        return 0;
    }
}
