package Board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.awt.*;
@AllArgsConstructor
public class BoardItem {
    @Getter @Setter int x;
    @Getter @Setter int y;
    @Getter @Setter Color color;
}
