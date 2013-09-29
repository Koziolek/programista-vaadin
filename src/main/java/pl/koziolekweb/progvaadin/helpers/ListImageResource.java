package pl.koziolekweb.progvaadin.helpers;

import com.vaadin.server.StreamResource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 29.09.13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
public class ListImageResource implements StreamResource.StreamSource {

	private final String text;

	public ListImageResource(String text) {
		this.text = text;
	}

	@Override
	public InputStream getStream() {
		BufferedImage image = new BufferedImage(20, 20,
				BufferedImage.TYPE_INT_RGB);
		Graphics drawable = image.getGraphics();
		drawable.setColor(Color.RED);
		drawable.fillRect(0, 0, 20, 20);
		drawable.setColor(Color.BLACK);
		drawable.drawString(text, 5, 5);
		try {
			ByteArrayOutputStream imagebuffer = new ByteArrayOutputStream();
			ImageIO.write(image, "png", imagebuffer);
			return new ByteArrayInputStream(
					imagebuffer.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
