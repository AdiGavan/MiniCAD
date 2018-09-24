// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

import java.io.IOException;
import java.util.ArrayList;

import fileio.implementations.FileReader;
import interfaces.Visitor;

/**
 * Clasa Polygon extinde clasa Shape si contine campurile si metodele
 * specifice formei Polygon.
 *
 * @author Gavan Adrian-George, 324CA
 */

public class Polygon extends Shape {
  /*
   * - points - lista de StructPoint ce contine colturile Polygon-ului.
   * - nrPoints - numarul de puncte al Polygon-ului;
   * - rgbaF - RGB A pentru fill;
   * - centruG - se retin coordonatele centului Polygon-ului;
   */

  private ArrayList<StructPoint> points = new ArrayList<StructPoint>();
  private int nrPoints;
  private int rgbaF;
  private StructPoint centruG;

  public Polygon(final String nameShape, final FileReader reader)
                 throws IOException {
    super(nameShape);
    nrPoints = reader.nextInt();
    StructPoint auxPoint = null;
    int sumaX = 0;
    int nrX = 0;
    int sumaY = 0;
    int nrY = 0;

    // Se adauga punctele in lista de puncte points. Se calculeaza suma
    // x-urilor, a y-urilor si numarul total de puncte.
    for (int i = 0; i < nrPoints; i++) {
      auxPoint = new StructPoint(reader.nextInt(), reader.nextInt());
      points.add(auxPoint);
      sumaX += auxPoint.getX();
      nrX++;
      sumaY += auxPoint.getY();
      nrY++;
    }

    // Se afla centrul polygon-ului.
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
    return nrPoints;
  }

  public final void createImage() throws IOException { }

}
