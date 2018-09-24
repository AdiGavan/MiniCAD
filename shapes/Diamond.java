// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

import java.io.IOException;
import java.util.ArrayList;

import fileio.implementations.FileReader;
import interfaces.Visitor;

/**
 * Clasa Diamond extinde clasa Shape si contine campurile si metodele
 * specifice formei Diamond.
 *
 * @author Gavan Adrian-George, 324CA
 */

public class Diamond extends Shape {
  /*
   * - NRPOINTS - numarul de puncte al unui Diamond
   * - points - lista de StructPoint ce contine colturile Diamond-ului.
   * - rgbaF - RGB A pentru fill;
   * - diagO - dimensiunea diagonalei orizontale;
   * - diagV - dimensiunea diagonalei verticale;
   * - centruG - se retin coordonatele centului Diamond-ului;
   */

  private ArrayList<StructPoint> points = new ArrayList<StructPoint>();
  private static final int NRPOINTS = 4;
  private int rgbaF;
  private int diagO;
  private int diagV;
  private StructPoint centruG;

  public Diamond(final String nameShape, final FileReader reader)
                 throws IOException {
    super(nameShape);

    centruG = new StructPoint(reader.nextInt(), reader.nextInt());
    diagO = reader.nextInt();
    diagV = reader.nextInt();

    int semidiagO = diagO / 2;
    int semidiagV = diagV / 2;

    // Se adauga colturile Diamond-ului in points.
    points.add(new StructPoint(centruG.getX(), centruG.getY() - semidiagV));
    points.add(new StructPoint(centruG.getX() + semidiagO, centruG.getY()));
    points.add(new StructPoint(centruG.getX(), centruG.getY() + semidiagV));
    points.add(new StructPoint(centruG.getX() - semidiagO, centruG.getY()));

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
