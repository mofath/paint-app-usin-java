package myPaintApp;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.util.Vector;
import java.applet.Applet;
import java.util.ArrayList;

public class GUI extends Applet {

    private Point startDrag, endDrag;

    public static String selectShap = "Line";
    public static Color selectColor = Color.BLACK;
    boolean isFill = false;
    Shape myCurrentShape;

    public static ArrayList<Shape> myShapes = new ArrayList<>();

    public void init() {
        setSize(1000, 600);
        setMinimumSize(getSize());

        Button btnLine = new Button("Line");
        btnLine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectShap = "Line";
            }
        });
        add(btnLine);

        Button btnRect = new Button("Rectangle");
        btnRect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                selectShap = "Rectangle";
            }
        });
        add(btnRect);

        Button btnOval = new Button("Oval");
        btnOval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectShap = "Oval";
            }
        });
        add(btnOval);

        Button btnFill = new Button("Fill");
        btnFill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isFill = true;
            }
        });
        add(btnFill);

        Button btnNotFill = new Button("Not Fill");
        btnNotFill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isFill = false;
            }
        });
        add(btnNotFill);

        Button btnBlueColor = new Button("Blue");
        btnBlueColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectColor = Color.BLUE;
            }
        });
        add(btnBlueColor);

        Button btnGreenColor = new Button("Green");
        btnGreenColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectColor = Color.GREEN;
            }
        });
        add(btnGreenColor);

        Button btnRedColor = new Button("Red");
        btnRedColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectColor = Color.RED;
            }
        });
        add(btnRedColor);

        Button btnBlackColor = new Button("Black");
        btnBlackColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectColor = Color.BLACK;
            }
        });
        add(btnBlackColor);

        Button btnClear = new Button("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myShapes.clear();
                myCurrentShape = null;
                repaint();
            }
        });
        add(btnClear);

        this.addMouseListener(new DrawMyPaint());
        this.addMouseMotionListener(new DrawMyPaint());
    }

    public void paint(Graphics g) {
        myCurrentShape.draw(g);

        for (Shape sh : myShapes) {
            sh.draw(g);
        }
    }

    class DrawMyPaint implements MouseListener, MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent e) {
            startDrag = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            endDrag = e.getPoint();

            switch (selectShap) {
                case "Line":
                    myCurrentShape = new MyLine(startDrag, endDrag, selectColor);
                    break;
                case "Rectangle":
                    myCurrentShape = new MyRectangle(startDrag, endDrag, selectColor, isFill);
                    break;
                case "Oval":
                    myCurrentShape = new MyOval(startDrag, endDrag, selectColor, isFill);
                    break;
            }
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            myShapes.add(myCurrentShape);
            repaint();

            startDrag = null;
            endDrag = null;
        }

        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        public void mouseMoved(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
