// "Copyright [2017] Gavan Adrian-George, 324CA"
package shapes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fileio.implementations.FileReader;
import interfaces.Visitor;

/**
 * Clasa Canvas extinde clasa Shape si contine campurile si metodele
 * specifice formei Canvas.
 *
 * @author Gavan Adrian-George, 324CA
 */

public class Canvas extends Shape {
  /*
   * - height - inaltimea Canvas-ului;
   * - width - latimea Canvas-ului;
   * - canvas - este variabila de tipul BufferedImage, unde se seteaza pixelii;
   */

  private static int height;
  private static int width;
  private static BufferedImage canvas;

  public Canvas(final String nameShape, final FileReader reader)
                throws IOException {
    super(nameShape);
    height = reader.nextInt();
    width = reader.nextInt();
    canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    // Se calculeaza RGBA cu ajutorul functiei calcRGBA din Shape.
    this.rgbaB = calcRGBA(reader);
  }

  /**
   * Metoda utilizata pentru acceptarea unui Visitor.
   */

  public void accept(final Visitor v) {
    v.visit(this);
  }

  /**
   * Metoda utilizata de catre Canvas pentru a crea fisierul "drawing.png".
   */

  public void createImage() throws IOException {
    File outputfile = new File("drawing.png");
    ImageIO.write(canvas, "png", outputfile);
  }

  public static int getHeight() {
    return height;
  }

  public static int getWidth() {
    return width;
  }

  public static BufferedImage getCanvas() {
    return canvas;
  }
}
