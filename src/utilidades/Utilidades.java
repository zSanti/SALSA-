package utilidades;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Utilidades {
	// Método para cargar y escalar la imagen
	public static ImageIcon createImageIcon(String path, int width, int height) {
		try {
			BufferedImage img = ImageIO.read(new File(path));
			Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			return new ImageIcon(scaledImg);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}