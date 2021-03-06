package gui.util;

import javafx.scene.canvas.Canvas;
import org.jfree.chart.JFreeChart;
import org.jfree.fx.FXGraphics2D;

import java.awt.geom.Rectangle2D;

/**
 *
 */
public class ChartCanvas extends Canvas {
    JFreeChart chart;

    private final FXGraphics2D g2;

    public ChartCanvas(JFreeChart chart) {
        this.chart = chart;
        this.g2 = new FXGraphics2D(getGraphicsContext2D());
        // Redraw canvas when size changes.
        widthProperty().addListener(e -> draw());
        heightProperty().addListener(e -> draw());
    }

    private void draw() {
        double width = getWidth();
        double height = getHeight();
        getGraphicsContext2D().clearRect(0, 0, width, height);
        this.chart.draw(this.g2, new Rectangle2D.Double(0, 0, width,
                height));
    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double prefWidth(double height) { return getWidth(); }

    @Override
    public double prefHeight(double width) { return getHeight(); }
}

