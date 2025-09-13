public class Rectangle {
  private final double length, width;

  public Rectangle(double length, double width) {
    if (length <= 0 || width <= 0)
      throw new RuntimeException("Invalid dimensions");
    this.length = length; this.width = width;
  }
  public double area()      { return length * width; }
  public double perimeter() { return 2 * (length + width); }
  public double getLength() { return length; }
  public double getWidth()  { return width; }
}