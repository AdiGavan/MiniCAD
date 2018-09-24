// "Copyright [2017] Gavan Adrian-George, 324CA"
import java.io.FileNotFoundException;
import java.io.IOException;

import fileio.implementations.FileReader;
import shapes.DrawVisitor;
import shapes.Shape;
import shapes.ShapeFactory;

/**
 * Clasa Main este entry-point-ul aplicatiei noastre.
 *
 * Se foloseste API-ul pus la dispozitie pentru a citi datele din fisier.
 * Fisierul din care se va face citirea este dat ca argument 1(args[0]).
 *
 * Se citeste numarul total de forme din fisier. Se initializeaza un vizitator
 * drawVisitor(pentru desenarea figurilor) si un ShapeFactory care creeaza
 * formele. Se initializeaza Canvas-ul (prima figura va fi mereu Canvas-ul) si
 * acesta primeste vizitatorul drawVisitor. Apoi, pentru fiecare linie in parte
 * se initializeaza forma folosind factory-ul si fiecare noua figura accepta
 * vizitatorul drawVisitor v. Dupa ce toate figurile au fost "desenate" pe
 * canvas, se apeleaza metoda createImage() din Canvas care realizeaza fisierul
 * PNG.
 *
 * @author Gavan Adrian-George, 324CA
 */

public final class Main {

  /* Se declara un constructor privat pentru ca Main nu
   * trebuie sa poata fi instantiata.
   */
  private Main() { }

  public static void main(final String[] args) throws FileNotFoundException,
                                                                IOException {
    /*
     * Variabile:
     * - reader - variabila utilizata pentru citirea datelor din fisier
     * - nrForme - variabila in care se retine numarul total de forme
     * - nameShape - se retine numele formei (primul cuvant de pe fiecare
     * linie) pentru a il folosi in factory la crearea formelor.
     * - v - vizitatorul drawVisitor;
     * - factory - factory-ul care creeaza formele;
     * - canv - Canvas-ul (se memoreaza intr-o variabila pentru ca trebuie
     * apelata metoda de creare a PNG-ului la final)l
     */

    FileReader reader = new FileReader(args[0]);
    int nrForme = reader.nextInt();
    String nameShape = null;
    Shape shape = null;
    DrawVisitor v = new DrawVisitor();
    ShapeFactory factory = ShapeFactory.getInstance();
    nameShape = reader.nextWord();

    Shape canv = factory.createShape(nameShape, reader);
    canv.accept(v);

    for (int i = 1; i < nrForme; i++) {
      nameShape = reader.nextWord();
      shape = factory.createShape(nameShape, reader);
      shape.accept(v);
    }
    canv.createImage();
    reader.close();
  }
}
