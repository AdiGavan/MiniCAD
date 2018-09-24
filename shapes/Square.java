// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

import java.io.IOException;

import fileio.implementations.FileReader;
import interfaces.Visitor;

/**
 * Clasa Square extinde clasa Shape si contine campurile si metodele
 * specifice formei Square.
 *
 * @author Gavan Adrian-George, 324CA
 */

public class Square extends Shape {
  /*
   * - point1 - coltul din stanga sus;
   * - dimensionL - dimensiunea unei laturi;
   * - rgbaF - RGB A pentru fill;
   */
  private StructPoint point1;
  private int dimensionL;
  private int rgbaF;

  public Square(final String nameShape, final FileReader reader)
                throws IOException {
    super(nameShape);
    point1 = new StructPoint(reader.nextInt(), reader.nextInt());
    dimensionL = reader.nextInt();

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

  public final StructPoint getPoint1() {
    return point1;
  }

  public final void setPoint1(final StructPoint point1) {
    this.point1.setX(point1.getX());
    this.point1.setY(point1.getY());
  }

  public final int getDimensionL() {
    return dimensionL;
  }

  public final int getRgbaF() {
    return rgbaF;
  }

  public final void createImage() throws IOException { }

}
