import java.awt.*;

public class imageLoader {
	static imageLoader il1 = new imageLoader();
	
	public static Image getImage(String filename) {
		return Toolkit.getDefaultToolkit().getImage(il1.getClass().getResource("images/"+ filename));
	}

}
