// "Copyright [2017] Gavan Adrian-George, 324CA"
package interfaces;

/**
 * Interfata este utilizata pentru a putea accepta un Visitor.
 *
 * Interfata este utilizata pentru implementarea pattern-ului Visitor.
 *
 * @author Gavan Adrian-George, 324CA
 */

public interface Visitable {
  void accept(Visitor v);
}
