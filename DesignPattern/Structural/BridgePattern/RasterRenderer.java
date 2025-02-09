
public class RasterRenderer implements Renderer{

    @Override
    public void renderCircle(float radius){
        System.out.println("Drawing a circle of radius " + radius + " using Rastser Renderer.");
    }

    @Override
    public void renderRectangle(float width, float height){
        System.out.println("Drawing a rectangle of width " + width + " and height " + height + " using Raster Renderer.");
    }


}