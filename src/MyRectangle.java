package myPaintApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

class MyRectangle extends Shape {

    private boolean isFillActive;

    public MyRectangle() {
    }

    public MyRectangle(Point _staDrag, Point _enDrag, Color c, boolean _fill) {
        super.staPoint = _staDrag;
        super.enPoint = _enDrag;
        super.color = c;
        this.isFillActive = _fill;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(this.color);

        if (this.isFillActive) {
            g.fillRect(staPoint.x, staPoint.y, width(), height());
        } else {
            g.drawRect(staPoint.x, staPoint.y, width(), height());
        }
    }
}
