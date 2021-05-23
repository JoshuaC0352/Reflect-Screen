package Main;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;



public class ReflectWindowInit {

	public static ScanWindow scanWindow;
	public static ReflectionWindow reflectionWindow;
	
	public static boolean dontExit = true;
	
	//private BufferedImage previousImage;
	
	
	public static void main(String[] args) 
	{
				
		scanWindow = new ScanWindow();
		reflectionWindow = new ReflectionWindow();
		
		// Mouse adapter for draggin a window
		scanWindow.addMouseMotionListener(new MouseMotionAdapter() 
		{
            public void mouseDragged(MouseEvent me) 
            {
        		moveScnaWindow();
            }
        });

	}
	
	public static void resizeScanWindow()
	{
		if(scanWindow.getLastMouseLocation() != null)
		{
			Point newMousePoint = MouseInfo.getPointerInfo().getLocation();
			
			//scanWindow.setLocation(new Point(mousePoint.x - 50, mousePoint.y - 50));
			
			int difX = (newMousePoint.x - scanWindow.getLastMouseLocation().x) * 2; 
			int difY = (newMousePoint.y - scanWindow.getLastMouseLocation().y) * 2;
			
			scanWindow.setBounds(new Rectangle(scanWindow.getBounds().x, scanWindow.getBounds().y, scanWindow.getBounds().width + difX, scanWindow.getBounds().height + difY));
		}
		
		scanWindow.setLastMouseLocation(MouseInfo.getPointerInfo().getLocation());
		
		reflectionWindow.setBounds(reflectionWindow.getBounds().x, reflectionWindow.getBounds().y, scanWindow.getWidth(), scanWindow.getHeight());
		
	}
	
	public static void moveScnaWindow()
	{
		Point mousePoint = MouseInfo.getPointerInfo().getLocation();
		
		scanWindow.setLocation(new Point(mousePoint.x - 50, mousePoint.y - 50));
	}
	
	
																	
}
