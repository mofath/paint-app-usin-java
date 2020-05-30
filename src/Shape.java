package myPaintApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {

    protected Point staPoint;
    protected Point enPoint;
    protected Color color;

    Shape() {
    }

    Shape(Point _staDrag, Point enDrag) {
        this.staPoint = _staDrag;
        this.enPoint = enDrag;
    }

    Shape(int _x1, int _y1, int _x2, int _y2) {
        this.staPoint.x = _x1;
        this.staPoint.y = _y1;
        this.enPoint.x = _x2;
        this.enPoint.y = _y2;
    }

    //setter methods
    public void setStartX(int _staPointX) {
        this.staPoint.x = _staPointX;
    }

    public void setStartY(int _staPointY) {
        this.staPoint.y = _staPointY;
    }

    public void setEndX(int _endPointX) {
        this.enPoint.x = _endPointX;
    }

    public void setEndY(int _endPointY) {
        this.enPoint.y = _endPointY;
    }

    //getter methods
    public int getStartX() {
        return this.staPoint.x;
    }

    public int getStartY() {
        return this.staPoint.y;
    }

    public int getEndX() {
        return this.enPoint.x;
    }

    public int getEndY() {
        return this.enPoint.y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int width() {
        return Math.abs(enPoint.x - staPoint.x);
    }

    public int height() {
        return Math.abs(enPoint.y - staPoint.y);
    }

    abstract void draw(Graphics g);
}
