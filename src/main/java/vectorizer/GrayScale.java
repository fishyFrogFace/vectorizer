package vectorizer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class GrayScale {
	
	public static Optional<BufferedImage> ApplyGrayScale(Optional<BufferedImage> img) {
		if (img.isPresent()) {
			int height = img.get().getHeight();
			int width = img.get().getWidth();
			
			for (int i = 0; i < width;  i++) {
				for (int j = 0; j < height; j++) {
					Optional<Color> c = Optional.of(new Color(img.get().getRGB(i, j)));
					Optional<Color> gr = pixelGray(c);
                    if (gr.isPresent()) {
                        img.get().setRGB(i, j, gr.get().getRGB());
                    }
                    else {
                        return Optional.empty();
                    }
				}
			}
			return img;
		}
		else {
			return Optional.empty();
		}
	}

	public static Optional<Color> pixelGray(Optional<Color> pixel) {
		if (pixel.isPresent()) {
			if (pixel.get().getBlue() != pixel.get().getGreen() || pixel.get().getBlue() != pixel.get().getRed()) {
				int r = pixel.get().getRed() * 299 / 1000;
				int g = pixel.get().getGreen() * 587 / 1000;
				int b = pixel.get().getBlue() * 114 / 1000;
				int graytone = r + g + b;
				Color gr = new Color(graytone, graytone, graytone);
				return Optional.of(gr);
			}
		}
		return Optional.empty();
	}
}