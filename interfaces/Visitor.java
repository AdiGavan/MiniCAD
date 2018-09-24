// "Copyright [2017] Gavan Adrian-George, 324CA"
package interfaces;

import shapes.Canvas;
import shapes.Circle;
import shapes.Diamond;
import shapes.Line;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;

/**
 * Interfata este utilizata pentru ca visitor-ul sa poate vizita o forma
 * si pentru a stii automat ce tip de forma viziteaza (double dispatch).
 *
 * Interfata este utilizata pentru implementarea pattern-ului Visitor.
 *
 * @author Gavan Adrian-George, 324CA
 */

public interface Visitor {

  void visit(Canvas c);
  void visit(Line l);
  void visit(Square s);
  void visit(Rectangle r);
  void visit(Circle c);
  void visit(Polygon p);
  void visit(Triangle t);
  void visit(Diamond d);

}
