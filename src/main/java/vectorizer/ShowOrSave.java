package vectorizer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ShowOrSave {
	
	//private static String image = "src/savedImages/grayminions.bmp";
	private static String image = "src/images/girl.png";
	
	public static void showImage(ImageLoader imglo) {
		JFrame f = new JFrame("Load image sample");
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.add(imglo);
		f.pack();
		f.setVisible(true);
	}
	
	public static void saveImage(Optional<BufferedImage> img, String name) {
		try {
			File newFile = new File("src/savedImages/"+name);
			ImageIO.write(img.get(), "bmp", newFile);
			System.out.println("Changes saved to file");
		}
		catch (IOException e) {
			System.out.println("Error while saving image.");
		}
	}
/*
	public static void main(String[] args) {
		ImageLoader i = new FileImageLoader(image);
		Optional<BufferedImage> bi = i.getImage();
		Optional<BufferedImage> another = GrayScale.ApplyGrayScale(bi);
        Optional<BufferedImage> check = SobelOperator.applyGradientMagnitude(another);
		ImageLoader yo = new FileImageLoader(check);
		showImage(yo);
		saveImage(check, "dog3.bmp");
	}*/
}
