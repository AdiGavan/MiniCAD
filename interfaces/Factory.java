// "Copyright [2017] Gavan Adrian-George, 324CA"
package interfaces;

import java.io.IOException;

import fileio.implementations.FileReader;
import shapes.Shape;

/**
 * Interfata care contine metoda de creare a formelor.
 * Interfata este utilizata pentru implementarea pattern-ului Factory.
 *
 * @author Gavan Adrian-George, 324CA
 */


public interface Factory {
  Shape createShape(String numeShape, FileReader reader) throws IOException;
}
