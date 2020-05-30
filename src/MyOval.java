package myPaintApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

class MyOval extends Shape {

    private boolean isFillActive;

    public MyOval() {
    }

    public MyOval(Point _staDrag, Point _enDrag) {
        super.staPoint = _staDrag;
        super.enPoint = _enDrag;
    }

    public MyOval(Point _staDrag, Point _enDrag, Color c, boolean _fill) {
        super.staPoint = _staDrag;
        super.enPoint = _enDrag;
        super.color = c;
        this.isFillActive = _fill;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(this.color);
        if (isFillActive) {
            g.fillOval(staPoint.x, staPoint.y, width(), height());

        } else {
            g.drawOval(staPoint.x, staPoint.y, width(), height());
        }
    }
}
