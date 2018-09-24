// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

import java.io.IOException;

import fileio.implementations.FileReader;
import interfaces.Visitor;

/**
 * Clasa Line extinde clasa Shape si contine campurile si metodele
 * specifice formei Line.
 *
 * @author Gavan Adrian-George, 324CA
 */

public class Line extends Shape {
  /*
   * point1 si point2 - primul si al doilea punct al liniei (capetele liniei);
   */

  private StructPoint point1;
  private StructPoint point2;

  public Line(final String nameShape, final FileReader reader)
              throws IOException {
    super(nameShape);
    point1 = new StructPoint(reader.nextInt(), reader.nextInt());
    point2 = new StructPoint(reader.nextInt(), reader.nextInt());

    // Se calculeaza RGBA cu ajutorul functiei calcRGBA din Shape.
    this.rgbaB = calcRGBA(reader);
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

  public final StructPoint getPoint2() {
    return point2;
  }

  public final void setPoint2(final StructPoint point2) {
    this.point2.setX(point2.getX());
    this.point2.setY(point2.getY());
  }

  public final void createImage() throws IOException { };

}
