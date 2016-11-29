import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class minimap extends JPanel {
	
	private static final long serialVersionUID = 1L; 
	private ArrayList<BufferedImage> images; 
	private int frameNumber; 
	
	/** 
	 * Construct a panel with a starter images  
	 * @param img  
	 */ 
	
	public minimap(BufferedImage img) {
		images = new ArrayList<BufferedImage>();
		images.add(img); frameNumber = 0; 
		setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
	}
	
	/**
	 * Add img to the ArrayList of images  
	 * @param img  
	 */ 
	
	public void add(BufferedImage img) {
		images.add(img);
	}
	
	/**
	 * Cycle through the frames using the % mod operation  
	 */ 
	public void nextFrame() { 
		frameNumber = (frameNumber + 1)%images.size(); 
	}
	
	/** 
	 * Implement the paint method to draw the images  
	 */ 
	@Override   
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		g.drawImage(images.get(frameNumber),  0,  0, null);
		// System.out.println("redraw " + frameNumber);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mini Map");
		BufferedImage image = null;
		
		try {                
			image = ImageIO.read(new File("./imgs/sprite_0.png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		 frame.getContentPane().add(new minimap(image));
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setPreferredSize(new Dimension(300, 300));
	     frame.pack();
	     frame.setVisible(true);
	}

}
