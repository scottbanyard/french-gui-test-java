// scott banyard 2015
// french test - colours test


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ColoursTest extends JFrame {
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
		questions.put("What is 'blue'?", "bleu");
		questions.put("What is 'green'?", "vert");
		questions.put("What is 'red'?", "rouge");
		questions.put("What is 'purple'?", "violet");
		questions.put("What is 'grey'?", "gris");
		questions.put("What is 'yellow'?", "jaune");
		questions.put("What is 'brown'?", "marron");
		questions.put("What is 'white'?", "blanc");
		questions.put("What is 'black'?", "noir");
		questions.put("What is 'pink'?", "rose");
		
		// ends test after 5 questions
		if (questionCount != 5) {
			
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
	    			// if same as value in map, then increase score
	    			if (textfieldAnswer.equals(questions.get(randomQuestion))) {
	    				score++;
	    			}
	    			// increase question count and re-call function to ask new question
	     			questionCount++;
	     			test(frame);
	     		}
	     	});
			
			
	    	// creates a grid layout
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
    	
	    	frame.add(panel, BorderLayout.CENTER);
	    	
			frame.setVisible(true);
			
		} else {
			// END OF TEST - RETURNS SCORE
			
			// clears window
			frame.getContentPane().removeAll();
			frame.getContentPane().repaint();
			
			// sets up button to take you back to the main menu
			JButton menuButton = new JButton("Back to Menu");
			menuButton.setFont(new Font("Courier New", Font.ITALIC, 20));
	    	menuButton.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) 
	     		{
     				try {
     					// closes current window and opens main menu
     					frame.dispose();
						Menu.main(null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	     		}
	     	});
			
			// sets up label showing result of test
			JLabel result = new JLabel("That's the end of the test. You managed to score " + score + " out of 5.");
			result.setFont(new Font("Courier New", Font.BOLD, 20));
			
	    	// creates a grid layout
	    	GridBagConstraints c = new GridBagConstraints();
	    	
	    	c.insets = new Insets(10, 10, 10, 10);
	    	c.gridx = 0;
	    	c.gridy = 1;
	    	panel.add(result, c);
	    	
	    	c.gridx = 0;
	    	c.gridy = 2;
	    	panel.add(menuButton, c);
	    	
	    	frame.add(panel, BorderLayout.CENTER);
	    	frame.setVisible(true);
			
		}
		
	}
	
	
}
