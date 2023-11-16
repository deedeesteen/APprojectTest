package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;

public class CustomerDashboard extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame cdframe;
	private JLayeredPane desktop;
	private Image icon;
	private ImageIcon maleIcon, femaleIcon, bkgrd;
	private JLabel custdash, bkgrdlabel;
	private JMenuBar menuBar;
	private JMenu equip, transac, custinfo, contact;
	private Color GRIZ = new Color(130, 110, 90);
	private Color TAN = new Color(232, 231, 177);
	private Color ROSY = new Color(255, 87, 70);
	
	public CustomerDashboard() {
		this.dashGUI();
	}
	
	public void dashGUI() {
		//Create a new JFrame
		cdframe = new JFrame("Grizzly's Entertainment Equipment Rental");
		//Create a new JDesktopPane
		desktop = new JDesktopPane();
		//Create a new JMenuBar
		menuBar = new JMenuBar();
		
		custdash = new JLabel("Customer Dashboard");
		custdash.setFont(new Font("Verdana", Font.BOLD, 30));
		custdash.setForeground(Color.BLACK);
		custdash.setBounds(550, 50, 1200, 50);
		
		//Loads the app icon (as seen in the task bar and top left of the window)
		icon = Toolkit.getDefaultToolkit().getImage("./images/icon.png");
		
		//Loads the app background image
		bkgrd = new ImageIcon("./images/bkgrd.png");
		//Set image to the label
		bkgrdlabel = new JLabel(bkgrd);
		bkgrdlabel.setBounds(370, 0, bkgrd.getIconWidth(), bkgrd.getIconHeight());
		
		equip = new JMenu("Rent Equipment");
		transac = new JMenu("Transactions");
		contact = new JMenu("Contact Us");
		custinfo = new JMenu("Customer Information");
		//Add JMenu components to the MenuBar
		menuBar.add(equip);
		menuBar.add(transac);
		menuBar.add(contact);
		menuBar.add(custinfo);
		/*maleIcon = new ImageIcon("./images/male.png");
		femaleIcon = new ImageIcon("./images/female.png");
		
		if(customer != null) {
			String gender = customer.getGender();
		}*/
		
		//Add a new JInternalFrame to the JDesktopPane with a specified layer
		desktop.add(new JInternalFrame(), JLayeredPane.POPUP_LAYER);
		//Add components to the desktop & frame
		desktop.add(custdash);
		desktop.add(bkgrdlabel, JLayeredPane.DEFAULT_LAYER);
		desktop.setBackground(TAN);
		cdframe.getContentPane().add(desktop, BorderLayout.CENTER);
		cdframe.setJMenuBar(menuBar);
		//Changes the app icon
		cdframe.setIconImage(icon);
		cdframe.setSize(1500,800);
		cdframe.setVisible(true);
		cdframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private ImageIcon getGenderIcon(String gender) {
		String path = (gender.equalsIgnoreCase("Male")) ? "./images/male.png" : "./images/female.png";
		return new ImageIcon(path);
	}
	
	/*public void registerListeners() {
		equip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}*/
	
	public static void main(String args[]) {
		new CustomerDashboard();
	}
}