// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

import java.io.IOException;

import fileio.implementations.FileReader;
import interfaces.Factory;

/**
 * Clasa ShapeFactory implementeaza interfata Factory si este utilizata
 * pentru crearea formelor.
 *
 * Aceasta clasa utilizeaza Singleton Pattern, pentru ca este nevoie de o
 * singura instanta a clasei ShapeFactory.
 *
 * Clasa contine o instanta a clasei ShapeFactory si o metoda care sa returneze
 * aceasta instanta.
 *
 * Aceasta clasa ajuta de asemenea si la implementarea pattern-ului Factory
 * (pentru ca clasa este un Factory ce creeaza formele).
 *
 * @author Gavan Adrian-George, 324CA
 */

public final class ShapeFactory implements Factory {

  private static ShapeFactory instance = new ShapeFactory();

  private ShapeFactory() { }

  /**
   * Metoda createShape este metoda ce creeaza formele. Primeste numele formei
   * si in functie de tipul formei initializeaza forma corespunzatoare.
   *
   * Pentru a stii ce forma trebuie sa creeze, se foloseste de clasa enum
   * Strategy.
   */

  public Shape createShape(final String nameShape, final FileReader reader)
                           throws IOException {
    Shape s = null;
    if (nameShape.equals(Strategy.CANVAS.toString())) {
      s = new Canvas(nameShape, reader);
    } else if (nameShape.equals(Strategy.LINE.toString())) {
      s = new Line(nameShape, reader);
    } else if (nameShape.equals(Strategy.SQUARE.toString())) {
      s = new Square(nameShape, reader);
    } else if (nameShape.equals(Strategy.RECTANGLE.toString())) {
      s = new Rectangle(nameShape, reader);
    } else if (nameShape.equals(Strategy.CIRCLE.toString())) {
      s = new Circle(nameShape, reader);
    } else if (nameShape.equals(Strategy.POLYGON.toString())) {
      s = new Polygon(nameShape, reader);
    } else if (nameShape.equals(Strategy.TRIANGLE.toString())) {
      s = new Triangle(nameShape, reader);
    } else if (nameShape.equals(Strategy.DIAMOND.toString())) {
      s = new Diamond(nameShape, reader);
    }
    return s;
  }

  /**
   * Metoda returneaza o instanta de tipul ShapeFactory.
   *
   * @return
   */

  public static ShapeFactory getInstance() {
    return instance;
  }

}
