/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractical;

import java.applet.*;
import java.awt.*;

/**
 *
 * @author bramo
 */
public class Fractical extends Applet {

    private Image display;
    private Graphics drawingArea;

    @Override
    public void init() {
        int height = getSize().height;
        int width = getSize().width;
        display = createImage(height, width);
        drawingArea = display.getGraphics();
        randomFractal(0, height / 2, width, height / 2, drawingArea);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(display, 0, 0, null);
    }

    public static void randomFractal(int leftX, int leftY, int rightX, int rightY,
            Graphics drawingArea) {
        final int STOP = 4;
        int midX, midY;
        int delta;

        if ((rightX - leftX) <= STOP) {
            drawingArea.drawLine(leftX, leftY, rightX, rightY);
        } else {
            midX = (leftX + rightX) / 2;
            midY = (leftY + rightY) / 2;
            delta = (int) (Math.random() - 0.5) * (rightX - leftX);
            midY += delta;
            randomFractal(leftX, leftY, midX, midY, drawingArea);
            randomFractal(midX, midY, rightX, rightY, drawingArea);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
