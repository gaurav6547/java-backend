// Client Code
public class BridgePatternDemo {
    public static void main(String[] args) {
        Renderer vectorRenderer = new VectorRenderer();
        Renderer rasterRenderer = new RasterRenderer();

        Shape circle = new Circle(vectorRenderer, 5.0f);
        Shape rectangle = new Rectangle(rasterRenderer, 4.0f, 6.0f);

        circle.draw(); // Uses Vector Renderer
        rectangle.draw(); // Uses Raster Renderer
    }
}
