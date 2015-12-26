import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Menu extends JFrame {

	public Menu() throws IOException {
		
		
		JFrame frame = new JFrame("French Test");
		
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel lbl = new JLabel("French Test");
		lbl.setFont(new Font("Courier New", Font.BOLD, 50));
		
		
		/* adds background image of french flag and frame adds the background
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon("/Users/Scott/Documents/Java/workspace/FrenchTest/src/flag.png"));
		background.setLayout(new FlowLayout());
		frame.add(background);
		*/
		
		JButton b1 = new JButton("Months");
		b1.setFont(new Font("Courier New", Font.ITALIC, 20));
    	b1.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     				MonthsTest monthtest = new MonthsTest();
     				try {
						MonthsTest.main(frame);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
     			}
     		});
    	
    	JButton b2 = new JButton("Numbers");
    	b2.setFont(new Font("Courier New", Font.ITALIC, 20));
    	b2.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     				NumbersTest numbtest = new NumbersTest();
     				try {
						NumbersTest.main(null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
     			}
     		});
    	
    	JButton b3 = new JButton("Colours");
    	b3.setFont(new Font("Courier New", Font.ITALIC, 20));
    	b3.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     				ColoursTest coltest = new ColoursTest();
     				try {
						ColoursTest.main(null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
     			}
     		});
		
    	JButton b4 = new JButton("Quit");
    	b4.setFont(new Font("Courier New", Font.ITALIC, 20));
    	b4.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) 
     		{
     			System.exit(0);
     		}
     	});
    	
    	// creates a grid
    	GridBagConstraints c = new GridBagConstraints();
    	
    	// insets cause space of 10 pixels between buttons
    	c.insets = new Insets(10, 10, 10, 10);
    	c.gridx = 0;
    	c.gridy = 1;
    	panel.add(lbl);
    	panel.add(b1, c);
    	
    	c.gridx = 0;
    	c.gridy = 2;
    	panel.add(b2, c);
    	
    	c.gridx = 0;
    	c.gridy = 3;
    	panel.add(b3, c);
    	
    	c.gridx = 0;
    	c.gridy = 4;
    	panel.add(b4, c);
    	
    	frame.add(panel, BorderLayout.CENTER);
    	
		
    	
		// sets frame centrally in screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
		
	}
	
	public static void main(String [] args) throws IOException {
		Menu menu = new Menu();
	}
}
