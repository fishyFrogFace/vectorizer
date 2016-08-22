package vectorizer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;

public class FileImageLoader extends ImageLoader {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5537594853848937469L;
	private Optional<BufferedImage> img = Optional.empty();
	
	public FileImageLoader(String image) {
		try {
			this.img = Optional.of(ImageIO.read(new File(image)));
		}
		catch (IOException e) {
			this.img = Optional.empty();
		}
	}
	
	public FileImageLoader(Optional<BufferedImage> img) {
		this.img = img;
	}
	
	/* (non-Javadoc)
	 * @see vectorizer.ImageLoader#getImage()
	 */
	@Override
	public Optional<BufferedImage> getImage() {
		return this.img;
	}
	
	/* (non-Javadoc)
	 * @see vectorizer.ImageLoader#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(img.get(), 0, 0, null);
	}
	
	/* (non-Javadoc)
	 * @see vectorizer.ImageLoader#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		if (img.isPresent()) {
			return new Dimension(img.get().getWidth(null), img.get().getHeight(null));
		}
		else {
			return new Dimension(100, 100);
		}
	}
}