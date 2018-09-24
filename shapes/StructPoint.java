// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

/**
 * Clasa utilizata pentru retinerea unui Point.
 *
 * @author Gavan Adrian-George, 324CA
 */

public class StructPoint {
  private int x;
  private int y;

  public StructPoint(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  public final int getX() {
    return x;
  }

  public final void setX(final int x) {
    this.x = x;
  }

  public final int getY() {
    return y;
  }

  public final void setY(final int y) {
    this.y = y;
  }

}
