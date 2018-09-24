// "Copyright [2017] Gavan Adrian-George, 324CA"
package utils;

import java.util.Stack;

import shapes.Canvas;
import shapes.StructPoint;

/**
 * Clasa Color contine metodele statice folosite pentru umplerea formelor.
 *
 * @author Gavan Adrian-George, 324CA
 */

public final class Color {

  private Color() { }

  /**
   * Metoda colorRectangle este folosita pentru colorarea Rectangle-urilor.
   *
   * Pentru aceasta forma este suficient sa folosim 2 for-uri cu care sa
   * trecem prin fiecare pixel al dreptunghiului (inafara de contur).
   * Pentru fiecare pixel, se apeleaza functia exitCanvas din algoritm
   * pentru a vedea daca pixelul este in Canvas sau nu.
   *
   * @param x
   * @param y
   * @param dimensionH
   * @param dimensionW
   * @param rgbaB
   */

  public static void colorRectangle(final int x, final int y, final int
                      dimensionH, final int dimensionW, final int rgbaB) {
    for (int i = x + 1; i < x + dimensionW - 1; i++) {
      for (int j = y + 1; j < y + dimensionH - 1; j++) {
        if (!Algoritms.exitCanvas(i, j)) {
          Canvas.getCanvas().setRGB(i, j, rgbaB);
        }
      }
    }
  }

  /**
   * Metoda colorSquare este folosita pentru colorarea Square-urilor.
   *
   * Pentru aceasta forma, colorarea se face in acelasi mod ca la Rectangle.
   * Diferenta este ca in loc de 2 dimensiuni diferite, Square-ul are o
   * singura dimensiune (dimensionL) pentru laturi. Se apeleaza metoda
   * colorRectangle, iar in loc de dimensionW si dimensionH vom avea de 2 ori
   * dimensionL.
   *
   * @param x
   * @param y
   * @param dimensionL
   * @param rgbaF
   */

  public static void colorSquare(final int x, final int y, final int
                                 dimensionL, final int rgbaF) {
    colorRectangle(x, y, dimensionL, dimensionL, rgbaF);
  }

  /**
   * Metoda floodFill este folosita pentru colorarea Circle, Triangle, Diamond
   * si Polygon.
   *
   * Se foloseste o stiva pentru retinerea punctelor ce ar trebui colorate.
   * Se adauga punctul ce trebuie colorat in stiva. Cat timp stiva nu este
   * goala, pentru fiecare punct din stiva se verifica daca acest punct face
   * parte din Canvas, daca culoarea actuala a punctului este diferita de
   * culoarea conturului si daca culoarea actuala a punctului este diferita de
   * culoarea cu care trebuie umpluta forma. Daca toate aceste conditii sunt
   * adevarate, se coloreaza punctul si se adauga punctele vecine in stiva.
   *
   * @param xi
   * @param yi
   * @param rgbaB
   * @param rgbaF
   */
  public static void floodFill(final int xi, final int yi, final int rgbaB,
                               final int rgbaF) {
    Stack<StructPoint> points = new Stack<>();
    points.add(new StructPoint(xi, yi));

    while (!points.isEmpty()) {
        StructPoint currentPoint = points.pop();
        int x = currentPoint.getX();
        int y = currentPoint.getY();

        if ((x >= 0 && x < Canvas.getWidth() && y >= 0 && y
            < Canvas.getHeight() && Canvas.getCanvas().getRGB(x, y) != rgbaB)
                              && (Canvas.getCanvas().getRGB(x, y) != rgbaF)) {
          Canvas.getCanvas().setRGB(x, y, rgbaF);
            points.push(new StructPoint(x + 1, y));
            points.push(new StructPoint(x - 1, y));
            points.push(new StructPoint(x, y + 1));
            points.push(new StructPoint(x, y - 1));
        }
    }
  }
}
