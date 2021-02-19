package Lesson6.Prototype;

import java.awt.*;

public abstract class Tree implements Cloneable{
    int length;
    Color leavesColor;

    public Tree(int length, Color leavesColor) {
        this.length = length;
        this.leavesColor = leavesColor;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Color getLeavesColor() {
        return leavesColor;
    }

    public void setLeavesColor(Color leavesColor) {
        this.leavesColor = leavesColor;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "length=" + length +
                ", leavesColor=" + leavesColor +
                '}';
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
