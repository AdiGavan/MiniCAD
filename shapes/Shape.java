// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

import java.awt.Color;
import java.io.IOException;

import fileio.implementations.FileReader;
import interfaces.Visitable;
import interfaces.Visitor;

/**
 * Clasa Shape contine campuri si metode generale pentru fiecare forma.
 *
 * Aceasta clasa implementeaza Visitable, pentru a realiza pattern-ul Visitor.
 *
 * @author Gavan Adrian-George, 324CA
 */

public abstract class Shape implements Visitable {
  // Constante pentru metoda calcRGBA
  private static final int POZ1 = 1;
  private static final int POZ2 = 2;
  private static final int POZ3 = 3;
  private static final int POZ4 = 4;
  private static final int POZ5 = 5;
  private static final int POZ6 = 6;
  private static final int BAZA = 16;

  /*
   * nameShape - tipul formei;
   * rgbaB - RGB A pentru conturul formei(border)
   */
  protected String nameShape;
  protected int rgbaB;

  public Shape(final String nameShape) {
    this.nameShape = nameShape;
  }

  /**
   * Metoda trebuie implementate de fiecare clasa ce extinde Shape pentru a
   * putea fi vizitata.
   */

  public abstract void accept(Visitor v);

  /**
   * Metoda pentru crearea fisierului PNG (va fi utilizata de catre Canvas).
   *
   * @throws IOException
   */

  public abstract void createImage() throws IOException;

  /**
   * Metoda calcRGBA calculeaza RGB A pentru contur sau pentru fill (primeste
   * reader ca parametru, citeste rgb-ul din fisier si valoarea Alpha de
   * opacitate si intoarce RGBA-ul corespunzator).
   *
   * In String-ul aux se retine sirul de caractere de forma "#RGB" din fisier.
   * In "a" se retine opacitatea.
   * Se parseaza sirul pentru a se lua cele 2 caractere care formeaza numarul
   * hexa corespunzator unei culori si se transforma intr-un intreg.
   * Dupa ce s-au gasit valorile corespunzatoare pentru rosu, verde si
   * albastru, se utilizeaza metoda getRGB() din clasa Color din Java pentru
   * a obtine RGBA-ul.
   *
   * @param reader
   * @return
   * @throws IOException
   */

  public int calcRGBA(final FileReader reader) throws IOException {
    String rgb = reader.nextWord();
    int a = reader.nextInt();

    String aux = Character.toString(rgb.charAt(POZ1)) + Character.toString(rgb.charAt(POZ2));
    int red = Integer.parseInt(aux, BAZA);

    aux = Character.toString(rgb.charAt(POZ3)) + Character.toString(rgb.charAt(POZ4));
    int green = Integer.parseInt(aux, BAZA);

    aux = Character.toString(rgb.charAt(POZ5)) + Character.toString(rgb.charAt(POZ6));
    int blue = Integer.parseInt(aux, BAZA);

    Color c = new Color(red, green, blue, a);

    return c.getRGB();
  }

  public final String getNameShape() {
    return nameShape;
  }

  public final int getRgbaB() {
    return rgbaB;
  }

}
