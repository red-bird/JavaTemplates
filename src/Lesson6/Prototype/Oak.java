package Lesson6.Prototype;

import java.awt.*;

public class Oak extends Tree{
    public Oak(int length, Color leavesColor) {
        super(length, leavesColor);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
