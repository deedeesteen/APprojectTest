package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JInternalFrame;

public class StaffDashboard extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame stframe;
	private JLayeredPane desktop;
	private Image icon;
	private ImageIcon maleIcon, femaleIcon, bkgrd;
	private JLabel staffdash, bkgrdlabel;
	private JMenuBar menuBar;
	private JMenu equip, requests;
	private Color GRIZ = new Color(130, 110, 90);
	private Color TAN = new Color(232, 231, 177);
	private Color ROSY = new Color(255, 87, 70);
	
	public StaffDashboard() {
		this.dashGUI();
	}
	
	public void dashGUI() {
		//Create a new JFrame
		stframe = new JFrame("Grizzly's Entertainment Equipment Rental");
		//Create a new JDesktopPane
		desktop = new JDesktopPane();
		//Create a new JMenuBar
		menuBar = new JMenuBar();
		
		staffdash = new JLabel("Staff Dashboard");
		staffdash.setFont(new Font("Verdana", Font.BOLD, 30));
		staffdash.setForeground(Color.BLACK);
		staffdash.setBounds(600, 50, 1200, 50);
		
		//Loads the app icon (as seen in the task bar and top left of the window)
		icon = Toolkit.getDefaultToolkit().getImage("./images/icon.png");
		
		//Loads the app background image
		bkgrd = new ImageIcon("./images/bkgrd.png");
		//Set image to the label
		bkgrdlabel = new JLabel(bkgrd);
		bkgrdlabel.setBounds(370, 0, bkgrd.getIconWidth(), bkgrd.getIconHeight());
		
		equip = new JMenu("All Equipment");
		requests = new JMenu("Rental Requests");
		//Add JMenu components to the MenuBar
		menuBar.add(equip);
		menuBar.add(requests);
		
		//Add a new JInternalFrame to the JDesktopPane with a specified layer
		desktop.add(new JInternalFrame(), JLayeredPane.POPUP_LAYER);
		//Add components to the desktop & frame
		desktop.add(staffdash);
		desktop.add(bkgrdlabel, JLayeredPane.DEFAULT_LAYER);
		desktop.setBackground(TAN);
		stframe.getContentPane().add(desktop, BorderLayout.CENTER);
		stframe.setJMenuBar(menuBar);
		//Changes the app icon
		stframe.setIconImage(icon);
		stframe.setSize(1500,800);
		stframe.setVisible(true);
		stframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		new StaffDashboard();
	}
}