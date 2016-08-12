package vectorizer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class SobelOperator {
	
	private static Integer[][] horizontal = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
	private static Integer[][] vertical = {{-1, -2, -1}, {0, 0, 0}, {1, 2, 1}};
	private static Integer sizeOfGrid = 3;
	
	public static Optional<BufferedImage> ApplyGradientMagnitude(Optional<BufferedImage> img) {
		Optional<BufferedImage> sobel;
		if (img.isPresent()) {
			sobel = Optional.of(new BufferedImage(img.get().getWidth()-1, img.get().getHeight(), 5));
			for (int i = 1; i < img.get().getWidth()-1; i++) {
				for (int j = 1; j < img.get().getHeight()-1; j++) {
					//System.out.println("Pixel: "+i+' '+j);
					Optional<BufferedImage> part = Optional.of(img.get().getSubimage(i-1, j-1, sizeOfGrid, sizeOfGrid));
					Optional<Integer> gradientX = convolute(part, horizontal);
					Optional<Integer> gradientY = convolute(part, vertical);
					Optional<Integer> gradient = magnitude(gradientX, gradientY);
					Color c = new Color(gradient.get(), gradient.get(), gradient.get());
					sobel.get().setRGB(i, j, c.getRGB());
				}
			}
			return sobel;
		}
		else {
			return Optional.empty();
		}
	}
	
	public static Optional<Integer> convolute(Optional<BufferedImage> img, Integer[][] dir) {
		Optional<Integer> gradient = Optional.of(0);
		if (img.isPresent()) {
			for (Integer i = 0; i < sizeOfGrid; i++) {
				for (Integer j = 0; j < sizeOfGrid; j++) {
					//System.out.println("Pixel: "+i+' '+j);
					Integer shade = new Color(img.get().getRGB(j, i)).getRed();
					//show operands
					//System.out.println("pixel: "+shade+' '+dir[i][j]);
					gradient = Optional.of(gradient.get()+(shade*dir[i][j]));
			}
			}
			gradient = Optional.of(gradient.get()/Math.IntPow(sizeOfGrid, 2));
			return gradient;
		}
		else {
			return Optional.empty();
		}
	}
	
	public static Optional<Integer> magnitude(Optional<Integer> gradientX, Optional<Integer> gradientY) {
		return Optional.of(Math.IntSqrt(Math.IntPow(gradientX.get(), 2)+Math.IntPow(gradientY.get(), 2)));
	}
}