// "Copyright [2017] Gavan Adrian-George, 324CA"
package utils;

import java.util.ArrayList;

import shapes.Canvas;
import shapes.StructPoint;

/**
 * Clasa contine algoritmii (metodele) pentru desenarea contururilor formelor.
 *
 * @author Gavan Adrian-George, 324CA
 *
 */
public final class Algoritms {
  public static final int CNST2 = 2;
  public static final int CNST3 = 3;
  public static final int CNST4 = 4;
  public static final int CNST6 = 6;
  public static final int CNST10 = 10;

  private Algoritms() { }

  /**
   * Algoritmul Bresenham de trasare a unei linii (din enuntul temei).
   *
   * @param x1
   * @param y1
   * @param x2
   * @param y2
   * @param rgbaB
   */

  public static void bresenhamAlgLine(final int x1, final int y1, final int x2,
                                      final int y2, final int rgbaB) {
    int x = x1;
    int y = y1;
    int deltaX = Math.abs(x2 - x1);
    int deltaY = Math.abs(y2 - y1);
    int s1 = (int) (Math.signum(x2 - x1));
    int s2 = (int) (Math.signum(y2 - y1));

    int aux = 0;
    boolean interchanged = false;

    if (deltaY > deltaX) {
      aux = deltaY;
      deltaY = deltaX;
      deltaX = aux;
      interchanged = true;
    } else {
      interchanged = false;
    }

    int error = (2 * deltaY) - deltaX;

    for (int i = 0; i <= deltaX; i++) {
      if (!exitCanvas(x, y)) {
        Canvas.getCanvas().setRGB(x, y, rgbaB);
      }

      while (error > 0) {
        if (interchanged) {
          x = x + s1;
        } else {
          y = y + s2;
        }
        error = error - (2 * deltaX);
      }

      if (interchanged) {
        y = y + s2;
      } else {
        x = x + s1;
      }
      error = error + (2 * deltaY);
    }

  }

  /**
   * Metoda rectangleAlg se utilizeaza pentru desenarea conturului
   * Rectangle-urilor.
   *
   * Pentru Rectangle, avand doar linii "drepte" (paralele cu axa OX si OY)
   * nu este necesar sa se foloseasca algoritmul Bresenham de trasare a unei
   * linii. Este suficient cate un for care trece prin punctele unei linii.
   * Pentru fiecare punct prin care trece for-ul se verifica daca punctul este
   * sau nu in Canvas inainte de a fi colorat.
   *
   * @param x
   * @param y
   * @param dimensionH
   * @param dimensionW
   * @param rgbaB
   */

  public static void rectangleAlg(final int x, final int y,
                                  final int dimensionH, final int dimensionW,
                                  final int rgbaB) {
    // Linia de sus a dreptunghiului
    for (int i = x; i < x + dimensionW; i++) {
      if (!exitCanvas(i, y)) {
        Canvas.getCanvas().setRGB(i, y, rgbaB);
      }
    }

    // Linia din stanga a dreptunghiului
    for (int i = y; i < y + dimensionH; i++) {
      if (!exitCanvas(x, i)) {
        Canvas.getCanvas().setRGB(x, i, rgbaB);
      }
    }
    //Linia de jos a dreptunghiului
    for (int i = x; i < x + dimensionW; i++) {
      if (!exitCanvas(i, y + dimensionH - 1)) {
        Canvas.getCanvas().setRGB(i, y + dimensionH - 1, rgbaB);
      }
    }

    //Linia din stanga a dreptunghiului
    for (int i = y; i < y + dimensionH; i++) {
      if (!exitCanvas(x + dimensionW - 1, i)) {
        Canvas.getCanvas().setRGB(x + dimensionW - 1, i, rgbaB);
      }
    }
  }

  /**
   * Metoda squareAlg se utilizeaza pentru desenarea conturului
   * Square-urilor.
   *
   * Pentru Square, realizarea conturului se face in acelasi mod ca la
   * Rectangle, diferenta fiind faptul ca la Square avem doar o dimensiune
   * a laturii, pentru ca toate laturile sunt egale. Se apeleaza algoritmul
   * de desenare rectangleAlg, dar in loc de 2 dimensiuni diferite dimensionH
   * si dimensionW se va da ca parametru o singura latura dimensionL.
   *
   * @param x
   * @param y
   * @param dimensionL
   * @param rgbaB
   */

  public static void squareAlg(final int x, final int y, final int dimensionL,
                                final int rgbaB) {
    rectangleAlg(x, y, dimensionL, dimensionL, rgbaB);
  }

  /**
   * Metoda drawCircle este utilizata de algoritmul Bresenham pentru cercuri
   * (metoda bresenhamAlgCircle) si realizeaza colorarea celor 8 puncte, daca
   * acestea sa afla in Canvas.
   *
   * @param xc
   * @param yc
   * @param x
   * @param y
   * @param rgbaB
   */

  private static void drawCircle(final int xc, final int yc, final int x,
                                 final int y, final int rgbaB) {

    if (!exitCanvas(xc + x, yc + y)) {
      Canvas.getCanvas().setRGB(xc + x, yc + y, rgbaB);
    }
    if (!exitCanvas(xc - x, yc + y)) {
      Canvas.getCanvas().setRGB(xc - x, yc + y, rgbaB);
    }
    if (!exitCanvas(xc + x, yc - y)) {
      Canvas.getCanvas().setRGB(xc + x, yc - y, rgbaB);
    }
    if (!exitCanvas(xc - x, yc - y)) {
      Canvas.getCanvas().setRGB(xc - x, yc - y, rgbaB);
    }
    if (!exitCanvas(xc + y, yc + x)) {
      Canvas.getCanvas().setRGB(xc + y, yc + x, rgbaB);
    }
    if (!exitCanvas(xc - y, yc + x)) {
      Canvas.getCanvas().setRGB(xc - y, yc + x, rgbaB);
    }
    if (!exitCanvas(xc + y, yc - x)) {
      Canvas.getCanvas().setRGB(xc + y, yc - x, rgbaB);
    }
    if (!exitCanvas(xc - y, yc - x)) {
      Canvas.getCanvas().setRGB(xc - y, yc - x, rgbaB);
    }
  }

  /**
   * Metoda bresenhamAlgCircle se utilizeaza pentru desenarea conturului
   * Circle-urilor (din enuntul temei).
   *
   * @param xc
   * @param yc
   * @param r
   * @param rgbaB
   */
  public static void bresenhamAlgCircle(final int xc, final int yc,
                                        final int r, final int rgbaB) {
    int p = 0, q = r;
    int d = CNST3 - CNST2 * r;

    while (q >= p) {
      drawCircle(xc, yc, p, q, rgbaB);
      p++;

      if (d > 0) {
        q--;
        d = d + CNST4 * (p - q) + CNST10;
      } else {
        d = d + CNST4 * p + CNST6;
      }
      drawCircle(xc, yc, p, q, rgbaB);

    }
  }

  /**
   * Metoda poligonAlg se utilizeaza pentru desenarea conturului
   * Polygon-urilor.
   *
   * Metoda primeste ca parametrii o lista cu punctele poligonului,
   * culoarea conturlui si numarul de puncte. Se trece prin toate
   * punctele poligonului si se aplica algoritmul lui Bresenham de
   * trasare a unei linii pe 2 puncte consecutive (P1 la P2, P2 la P3 etc.).
   * Cu ajutorul for-ului se traseaza toate liniile din P0 pana in Pn, doar ca
   * nu se deseneaza si linia din Pn in P0, asa ca se mai aplica inca o data
   * Bresenham pentru linie pe acele 2 puncte.
   *
   * @param points
   * @param rgbaB
   * @param nrPoints
   */

  public static void polygonAlg(final ArrayList<StructPoint> points,
                                final int rgbaB, final int nrPoints) {
    for (int i = 0; i < nrPoints - 1; i++) {
      bresenhamAlgLine(points.get(i).getX(), points.get(i).getY(),
                    points.get(i + 1).getX(), points.get(i + 1).getY(), rgbaB);
    }
    bresenhamAlgLine(points.get(points.size() - 1).getX(),
                    points.get(points.size() - 1).getY(), points.get(0).getX(),
                    points.get(0).getY(), rgbaB);
  }

  /**
   * Metoda triangleAlg se utilizeaza pentru desenarea conturului
   * Triangle-urilor.
   *
   * Triunghiul este un poligon cu 3 laturi, asa ca se aplica algoritmul
   * de desenare al unui poligon (singura diferenta este ca lista de puncte
   * va avea mereu 3 puncte si numarul de puncte va fi mereu 3).
   *
   * @param points
   * @param rgbaB
   * @param nrPoints
   */

  public static void triangleAlg(final ArrayList<StructPoint> points,
                                 final int rgbaB, final int nrPoints) {
    polygonAlg(points, rgbaB, nrPoints);
  }

  /**
   * Metoda diamondAlg se utilizeaza pentru desenarea conturului
   * Diamond-urilor.
   *
   * Metoda primeste ca parametrii o lista cu punctele diamond-ului,
   * culoarea conturlui si numarul de puncte. Se trece prin toate
   * punctele poligonului si se aplica algoritmul lui Bresenham de
   * trasare a unei linii pe 2 puncte consecutive (P1 la P2, P2 la P3 etc.).
   * Cu ajutorul for-ului se traseaza toate liniile din P0 pana in Pn, doar ca
   * nu se deseneaza si linia din P0 in Pn, asa ca se mai aplica inca o data
   * Bresenham pentru linie pe acele 2 puncte.
   *
   * @param points
   * @param rgbaB
   * @param nrPoints
   */

  public static void diamondAlg(final ArrayList<StructPoint> points,
                                final int rgbaB, final int nrPoints) {
    for (int i = 0; i < nrPoints - 1; i++) {
      bresenhamAlgLine(points.get(i).getX(), points.get(i).getY(),
                    points.get(i + 1).getX(), points.get(i + 1).getY(), rgbaB);
    }
    bresenhamAlgLine(points.get(0).getX(), points.get(0).getY(),
                    points.get(points.size() - 1).getX(),
                    points.get(points.size() - 1).getY(), rgbaB);
  }

  /**
   * Metoda exitCanvas este utilizata pentru a vedea daca punctul (X,Y) este
   * sau nu in Canvas.
   *
   * @param x
   * @param y
   * @return
   */

  public static boolean exitCanvas(final int x, final int y) {
    if (x < 0 || x >= Canvas.getWidth()) {
      return true;
    }
    if (y < 0 || y >= Canvas.getHeight()) {
      return true;
    }
    return false;
  }
}
