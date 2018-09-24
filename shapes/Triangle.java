// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

import java.io.IOException;
import java.util.ArrayList;

import fileio.implementations.FileReader;
import interfaces.Visitor;

/**
 * Clasa Triangle extinde clasa Shape si contine campurile si metodele
 * specifice formei Triangle.
 *
 * @author Gavan Adrian-George, 324CA
 */

public class Triangle extends Shape {
  /*
   * - NRPOINTS - numarul de puncte al Triangle-ului;
   * - points - lista de StructPoint ce contine colturile Triangle-ului.
   * - rgbaF - RGB A pentru fill;
   * - centruG - se retin coordonatele centului Triangle-ului;
   */

  private static final int NRPOINTS = 3;
  private ArrayList<StructPoint> points = new ArrayList<StructPoint>();
  private int rgbaF;
  private StructPoint centruG;

  public Triangle(final String nameShape, final FileReader reader)
                  throws IOException {
    super(nameShape);
    StructPoint auxPoint = null;
    int sumaX = 0;
    int nrX = 0;
    int sumaY = 0;
    int nrY = 0;

    // Se adauga punctele in lista de puncte points. Se calculeaza suma
    // x-urilor, a y-urilor si numarul total de puncte.
    for (int i = 0; i < NRPOINTS; i++) {
      auxPoint = new StructPoint(reader.nextInt(), reader.nextInt());
      points.add(auxPoint);
      sumaX += auxPoint.getX();
      nrX++;
      sumaY += auxPoint.getY();
      nrY++;
    }

    // Se afla centrul Triangle-ului.
    centruG = new StructPoint((int) Math.round(sumaX / nrX),
                              (int) Math.round(sumaY / nrY));

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

  public final int getRgbaF() {
    return rgbaF;
  }

  public final ArrayList<StructPoint> getPoints() {
    return points;
  }

  public final StructPoint getCentruG() {
    return centruG;
  }

  public final int getNrPoints() {
    return NRPOINTS;
  }

  public final void createImage() throws IOException { }

}
