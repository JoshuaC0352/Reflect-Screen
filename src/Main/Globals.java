package Main;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;


public class Globals 
{
	
	/**
	 * captures the screen image occupied by the window and returns it as a buffered image
	 * @return BufferedImage
	 */
	public static BufferedImage scanCapture()
	{
		Robot robot;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Failed to create robot!");
			return null;
		}
		
		Rectangle captureRegion = new Rectangle();
		Point windowLoc = ReflectWindowInit.scanWindow.getLocation();
		
		
		captureRegion.setLocation(windowLoc);
		captureRegion.width = ReflectWindowInit.scanWindow.getWidth();
		captureRegion.height = ReflectWindowInit.scanWindow.getHeight();
		
		
		return robot.createScreenCapture(captureRegion);
	}
	
	public static void startScanning()
	{
		
		Thread screenScan = new Thread()
		{
			public void run()
			{

				
				while(true)
				{
					// Capture a screenshot inside the boxed region
					BufferedImage currentImage = Globals.scanCapture();
					ReflectWindowInit.scanWindow.setScannedImage(currentImage);
					ReflectWindowInit.reflectionWindow.repaint();
					
				}
			}
		};
		
		screenScan.start();
	}
	
	public static boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
	    System.out.println("Comparing Images");
		
		if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
	        for (int x = 0; x < img1.getWidth(); x++) {
	            for (int y = 0; y < img1.getHeight(); y++) {
	                if (img1.getRGB(x, y) != img2.getRGB(x, y))
	                    return false;
	            }
	        }
	    } else {
	        return false;
	    }
	    return true;
	}
	
	
}
