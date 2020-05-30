package myPaintApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyLine extends Shape {

    public MyLine() {
    }

    public MyLine(Point _staDrag, Point _enDrag, Color c) {
        super.staPoint = _staDrag;
        super.enPoint = _enDrag;
        super.color = c;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(this.color);
        g.drawLine(staPoint.x, staPoint.y, enPoint.x, enPoint.y);
    }
}
