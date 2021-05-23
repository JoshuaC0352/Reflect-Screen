package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScanWindow extends JFrame 
{
	public static int windowWidth = 340;
	public static int windowHeight = 600;
	
	public static boolean mouseDown = false;
	
	public JPanel panel;
	
	private BufferedImage scannedImage;
	
	private Point lastMouseLocation;
	
	ScanWindow()
	{
		
		super("GradientTranslucentWindow");
	
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0.1f));
		setSize(windowWidth, windowHeight);
		this.setMinimumSize(new Dimension(100, 150));
		setVisible(true);
		setAlwaysOnTop(true);
		
		
		panel = new JPanel() 
		{
	        @Override
	        protected void paintComponent(Graphics g) 
	        {
	            setLayout(new FlowLayout());

	            
	        	Graphics2D g2 = (Graphics2D) g;
	        	
	        	
	        	g2.setStroke(new BasicStroke(5));
	        	g2.setColor(Color.GREEN);
	        	g2.drawRect(0, 0, getWidth() - 5, getHeight() - 5);
	        	
	        	//g2.setColor(new Color(50,0,0));
	        	//g2.fillRect(0, 0, windowWidth - 6, windowHeight - 6);
	        }
	        
	        
		};
	
		JButton scan = new JButton("Start Scan");
		JButton resize = new JButton("Resize");
		
		scan.addActionListener(e -> 
		{
			remove(scan);
			remove(resize);
			revalidate();
			repaint();
			//scan.hide();
//			panel.revalidate();
//			panel.repaint();
			Globals.startScanning();
		});
		
		resize.setAlignmentX(FlowLayout.RIGHT);
		
		resize.addMouseListener(new MouseListener()	
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {
				lastMouseLocation = MouseInfo.getPointerInfo().getLocation();
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		resize.addMouseMotionListener(new MouseMotionAdapter() 
		{
			public void mouseDragged(MouseEvent me) 
            {
            	
            	ReflectWindowInit.resizeScanWindow();
            }
        });
		
		panel.add(scan);
		panel.add(resize);
		panel.setBounds(0, 0, windowWidth, windowHeight);
		setContentPane(panel);
		panel.repaint();

	}
	
	
	
	public BufferedImage getScannedImage()
	{
		return scannedImage;
	}
	
	public void setScannedImage(BufferedImage scannedImage)
	{
		this.scannedImage = scannedImage;
	}

	public Point getLastMouseLocation() 
	{
		return lastMouseLocation;
	}

	public void setLastMouseLocation(Point lastMouseLocation) 
	{
		this.lastMouseLocation = lastMouseLocation;
	}
	

}
