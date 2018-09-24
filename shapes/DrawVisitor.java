// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

import interfaces.Visitor;
import utils.Algoritms;
import utils.Color;

/**
 * Clasa DrawVisitor represinta un visitor (pentru pattern-ul Visitor) si
 * realizeaza desenarea formelor, in functie de tipul fiecareia. Clasa
 * contine metoda visit pentru fiecare tip de forma (overload).
 *
 * @author Gavan Adrian-George, 324CA
 */

public class DrawVisitor implements Visitor {

  /**
   * Metoda visit pentru Canvas realizeaza colorarea Canvas-ului.
   * Se trece prin fiecare pixel al Canvas-ului si se seteaza culoarea.
   */

  public void visit(final Canvas canvas) {
    for (int x = 0; x < Canvas.getWidth(); x++) {
      for (int y = 0; y < Canvas.getHeight(); y++) {
          Canvas.getCanvas().setRGB(x, y, canvas.getRgbaB());
      }
    }
  }

  /**
   * Metoda visit pentru Linie realizeaza desenarea unei linii.
   * Se apeleaza algoritmul de desenare al liniei din Algoritms.
   */

  public void visit(final Line l) {
    Algoritms.bresenhamAlgLine(l.getPoint1().getX(), l.getPoint1().getY(),
                               l.getPoint2().getX(), l.getPoint2().getY(),
                                l.getRgbaB());
  }

  /**
   * Metoda visit pentru Square realizeaza desenarea si colorarea unui Square.
   * Se apeleaza algoritmul de desenare al unui square din Algoritms si
   * algoritmul de colorare al unui square din Color.
   */

  public void visit(final Square s) {
    Algoritms.squareAlg(s.getPoint1().getX(), s.getPoint1().getY(),
                        s.getDimensionL(), s.getRgbaB());
    Color.colorSquare(s.getPoint1().getX(), s.getPoint1().getY(),
                      s.getDimensionL(), s.getRgbaF());
  }

  /**
   * Metoda visit pentru Rectangle realizeaza desenarea si colorarea unui
   * Rectangle.
   * Se apeleaza algoritmul de desenare al unui rectangle din Algoritms si
   * algoritmul de colorare al unui rectangle din Color.
   */

  public void visit(final Rectangle r) {
    Algoritms.rectangleAlg(r.getPoint1().getX(), r.getPoint1().getY(),
                           r.getDimensionH(), r.getDimensionW(), r.getRgbaB());
    Color.colorRectangle(r.getPoint1().getX(), r.getPoint1().getY(),
                         r.getDimensionH(), r.getDimensionW(), r.getRgbaF());
  }

  /**
   * Metoda visit pentru Circle realizeaza desenarea si colorarea unui Circle.
   * Se apeleaza algoritmul de desenare al unui Circle din Algoritms si
   * algoritmul de Flood Fill din Color.
   */

  public void visit(final Circle c) {
    Algoritms.bresenhamAlgCircle(c.getCenter().getX(), c.getCenter().getY(),
                                 c.getDimensionR(), c.getRgbaB());
    Color.floodFill(c.getCenter().getX(), c.getCenter().getY(), c.getRgbaB(),
                    c.getRgbaF());
  }

  /**
   * Metoda visit pentru Polygon realizeaza desenarea si colorarea unui
   * Polygon.
   * Se apeleaza algoritmul de desenare al unui Polygon din Algoritms si
   * algoritmul de Flood Fill din Color.
   */

  public void visit(final Polygon p) {
    Algoritms.polygonAlg(p.getPoints(), p.getRgbaB(), p.getNrPoints());
    Color.floodFill(p.getCentruG().getX(), p.getCentruG().getY(), p.getRgbaB(),
                    p.getRgbaF());
  }

  /**
   * Metoda visit pentru Triangle realizeaza desenarea si colorarea unui
   * Triangle.
   * Se apeleaza algoritmul de desenare al unui Triangle din Algoritms si
   * algoritmul de Flood Fill din Color.
   */

  public void visit(final Triangle t) {
    Algoritms.triangleAlg(t.getPoints(), t.getRgbaB(), t.getNrPoints());
    Color.floodFill(t.getCentruG().getX(), t.getCentruG().getY(), t.getRgbaB(),
                    t.getRgbaF());
  }

  /**
   * Metoda visit pentru Diamond realizeaza desenarea si colorarea unui
   * Diamond.
   * Se apeleaza algoritmul de desenare al unui Diamond din Algoritms si
   * algoritmul de Flood Fill din Color.
   */

  public void visit(final Diamond d) {
    Algoritms.diamondAlg(d.getPoints(), d.getRgbaB(), d.getNrPoints());
    Color.floodFill(d.getCentruG().getX(), d.getCentruG().getY(), d.getRgbaB(),
                    d.getRgbaF());
  }

}
