// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

import java.io.IOException;

import fileio.implementations.FileReader;
import interfaces.Visitor;

/**
 * Clasa Circle extinde clasa Shape si contine campurile si metodele
 * specifice formei Circle.
 *
 * @author Gavan Adrian-George, 324CA
 */

public class Circle extends Shape {
  /*
   * - center - variabila de tip StructPoint in care se retin coordonatele
   * centrului cercului;
   * - dimensionR - dimensiunea razei;
   * - rgbaF - RGB A pentru fill;
   */

  private StructPoint center;
  private int dimensionR;
  private int rgbaF;

  public Circle(final String nameShape, final FileReader reader)
                throws IOException {
    super(nameShape);
    center = new StructPoint(reader.nextInt(), reader.nextInt());
    dimensionR = reader.nextInt();

    // Se calculeaza RGBA-urile cu ajutorul functiei calcRGBA din Shape.
    this.rgbaB = calcRGBA(reader);
    this.rgbaF = calcRGBA(reader);
  }

  /**
   * Metoda utilizata pentru acceptarea unui Visitor.
   */

  public void accept(final Visitor v) {
    v.visit(this);
  }

  public final StructPoint getCenter() {
    return center;
  }

  public final void setPoint1(final StructPoint point1) {
    this.center.setX(center.getX());
    this.center.setY(center.getY());
  }

  public final int getDimensionR() {
    return dimensionR;
  }

  public final int getRgbaF() {
    return rgbaF;
  }

  public final void createImage() throws IOException { }

}
