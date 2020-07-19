package view.menus.icons;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Icon {
	
	private ImageIcon icon;
	
	public Icon(String path) {
		
		icon = findImage(path);
	}

	private ImageIcon findImage(String path) {
		
		java.net.URL url = getClass().getResource(path);
		if (url != null)
			return (new ImageIcon(url));
		return null;
	}
	
	public ImageIcon resizeImage(ImageIcon initialImage, int width, int height) {
		
		if (initialImage == null)
			return null;
		
		Image image = initialImage.getImage();
		Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		
		return new ImageIcon(newImage);
	}
	
	public ImageIcon getIcon() {
		return icon;
	}
}
