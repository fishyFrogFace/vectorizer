package vectorizer;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Optional;

public abstract class ImageLoader extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8607136770960154247L;

	public abstract Optional<BufferedImage> getImage();

	public abstract void paint(Graphics g);

	public abstract Dimension getPreferredSize();

}