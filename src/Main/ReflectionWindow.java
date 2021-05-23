package Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReflectionWindow extends JFrame 
{
	public static int windowWidth = 360;
	public static int windowHeight = 620;
	
	public static boolean mouseDown = false;
	
	public JPanel panel; 
	
	ReflectionWindow()
	{
		
		//super("GradientTranslucentWindow");
	
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		//setBackground(new Color(0,0,0,0.1f));
		setSize(windowWidth, windowHeight);
		setResizable(false);
		setVisible(true);
		setAlwaysOnTop(true);
		
		
		panel = new JPanel() 
		{
	        @Override
	        protected void paintComponent(Graphics g) 
	        {
	            //setLayout(new FlowLayout());
	        	BufferedImage scannedImage = ReflectWindowInit.scanWindow.getScannedImage();
	        	
	        	if(scannedImage != null)
	        	{
	        		int height = scannedImage.getHeight();
		        	int width = scannedImage.getWidth();
		        	
		        	
		        	g.drawImage(scannedImage, 0, 0, width, height, null);
	        	}
	        	
	        	

	        }
	        
	        
		};
	
		setContentPane(panel);
		panel.repaint();

	}
}
