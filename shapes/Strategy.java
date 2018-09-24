// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

/**
 * Clasa de tipul enum folosita pentru tipul Formelor.
 *
 * Aceasta clasa ajuta la implementarea pattern-ului Factory.
 *
 * @author Gavan Adrian-George, 324CA
 */

public enum Strategy {

  LINE("LINE"),
  CANVAS("CANVAS"),
  SQUARE("SQUARE"),
  RECTANGLE("RECTANGLE"),
  CIRCLE("CIRCLE"),
  POLYGON("POLYGON"),
  TRIANGLE("TRIANGLE"),
  DIAMOND("DIAMOND");

  private final String tip;

  Strategy(final String tipNou) {
    this.tip = tipNou;
  }

  @Override
  public String toString() {
    return tip;
  }

}
