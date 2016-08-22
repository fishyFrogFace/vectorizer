package vectorizer;

import java.awt.image.BufferedImage;
import java.util.Optional;

/**
 * Created by Mangler on 8/11/2016.
 */
public class Image {

    private Optional<BufferedImage> image;
    private boolean gray = false;
    private boolean sobel = false;
    private boolean canny = false;

    public Image(Optional<BufferedImage> img) {
        this.image = img;
    }
}
