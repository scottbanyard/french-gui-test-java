import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MonthsTest extends JFrame {
	static int score = 0;
	static int questionCount = 0;
	static int randomNumber = 0;
	public static String randomQuestion = "";
	public static ArrayList<String> usedQuestions = new ArrayList<String>();
	
	public static void main(JFrame frame) throws IOException {
		
		test(frame);
	}
	
	public static void test(JFrame frame) {
		// removes all content on frame passed in (clears frame)
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		HashMap<String, String> questions = new HashMap<String, String>();
		questions.put("What is 'January'?", "janvier");
		questions.put("What is 'February'?", "fevrier");
		questions.put("What is 'March'?", "mars");
		questions.put("What is 'April'?", "avril");
		questions.put("What is 'May'?", "mai");
		questions.put("What is 'June'?", "juin");
		questions.put("What is 'July'?", "juillet");
		questions.put("What is 'August'?", "aout");
		questions.put("What is 'September'?", "septembre");
		questions.put("What is 'October'?", "octobre");
		questions.put("What is 'November'?", "novembre");
		questions.put("What is 'December'?", "decembre");
		
		if (questionCount != 5) {
			//JLabel feedback = new JLabel("");
			
			Random randomizer = new Random();
			
			// makes array with keys of hashmap (the questions)
			ArrayList<String> keysAsArray = new ArrayList<String>(questions.keySet());
			// gets a random question from keyset
			randomNumber = randomizer.nextInt(keysAsArray.size());
			randomQuestion = keysAsArray.get(randomizer.nextInt(keysAsArray.size()));

			
			// makes sure not using question that has already been used
			while (usedQuestions.contains(randomQuestion)) {
				randomNumber = randomizer.nextInt(keysAsArray.size());
				randomQuestion = keysAsArray.get(randomNumber);
			}
			usedQuestions.add(randomQuestion);
			
			// changes label to question
			JLabel lbl = new JLabel(randomQuestion);
			lbl.setFont(new Font("Courier New", Font.BOLD, 50));
			
			// sets up textfield
			JTextField textfield = new JTextField(15);
			
			// sets up submit button
			JButton submitButton = new JButton("Submit");
			submitButton.setFont(new Font("Courier New", Font.ITALIC, 20));
	    	submitButton.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) 
	     		{
	    			// gets answer given
	    			String textfieldAnswer = textfield.getText();
	    			// any case will be accepted
	    			textfieldAnswer = textfieldAnswer.toLowerCase();
	    			if (textfieldAnswer.equals(questions.get(randomQuestion))) {
	    				//feedback.setText("Correct!");
	    				score++;
	    			//} else {
	    				//feedback.setText("Wrong! The answer was '" + questions.get(randomQuestion) + "'");
	    			}
	     			questionCount++;
	     			test(frame);
	     		}
	     	});
			
			
	    	// creates a grid
	    	GridBagConstraints c = new GridBagConstraints();
	    	
	    	// insets cause space of 10 pixels between buttons
	    	c.insets = new Insets(10, 10, 10, 10);
	    	c.gridx = 0;
	    	c.gridy = 1;
	    	panel.add(lbl, c);
	    	
	    	c.gridx = 0;
	    	c.gridy = 2;
	    	panel.add(textfield, c);
	    	
	    	c.gridx = 0;
	    	c.gridy = 3;
	    	panel.add(submitButton, c);
	    	
	    	//c.gridx = 0;
	    	//c.gridy = 4;
	    	//panel.add(feedback, c);
	    	
	    	frame.add(panel, BorderLayout.CENTER);
	    	
			// sets frame centrally in screen
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
			frame.setVisible(true);
			
		} else {
			frame.getContentPane().removeAll();
			frame.getContentPane().repaint();
			
			JLabel result = new JLabel("That's the end of the test. You managed to score " + score + " out of 5.");
			result.setFont(new Font("Courier New", Font.BOLD, 20));
			
	    	// creates a grid
	    	GridBagConstraints c = new GridBagConstraints();
	    	
	    	c.insets = new Insets(10, 10, 10, 10);
	    	c.gridx = 0;
	    	c.gridy = 1;
	    	panel.add(result, c);
	    	
	    	frame.add(panel, BorderLayout.CENTER);
	    	frame.setVisible(true);
			
		}
		
	}
	
	
}
