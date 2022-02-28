import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGame extends JFrame implements ActionListener {

	JButton[] button = new JButton[10];

	JLabel redLabel, blueLabel, statusLabel;
	JTextField redField, blueField;
	JButton redButton, blueButton, enterButton, exitButton;
	
	String choice = "";
	String color = "";
	
	int redNum = 0;
	int blueNum = 0;

	public NumberGame() {
		
		super("Number Game");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel northP = new JPanel();

		// RED SIDE
		redLabel = new JLabel("RED: ");
		northP.add(redLabel);
		redField = new JTextField(10);
		northP.add(redField);
		redButton = new JButton("RED SIDE");
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = "red";
			}
		});

		// BLUE SIDE
		blueLabel = new JLabel("BLUE: ");
		northP.add(blueLabel);
		blueField = new JTextField(10);
		northP.add(blueField);
		blueButton = new JButton("BLUE SIDE");
		blueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = "blue";
			}
		});

		add(northP, BorderLayout.NORTH);
		
		

		JPanel centerP = new JPanel();

		// NUMBER BUTTONS
		for (int i = 0; i < 10; i++) {

			button[i] = new JButton((int) (Math.random() * 10) + "");
			button[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					choice = e.getActionCommand();
					int num = Integer.parseInt(e.getActionCommand());
					System.out.println(choice);
					if (color == "blue") {
						blueField.setText(blueField.getText() + " " + choice);
						blueNum = blueNum + num;
					}
					if (color == "red") {
						redField.setText(redField.getText() + " " + choice);
						redNum = redNum + num;
					}
				}
			});

			centerP.add(button[i]);

		}
		
		
		statusLabel = new JLabel("Make Red and Blue Equal Each Other :P ");
		
		add(centerP, BorderLayout.CENTER);

		
		
		JPanel southP = new JPanel();

		// RED SIDE BUTTON
		southP.add(redButton);
		
		// BLUE SIDE BUTTON
		southP.add(blueButton);
		
	
		// ENTER BUTTON
		enterButton = new JButton("ENTER");
		enterButton.addActionListener(this);
		southP.add(enterButton);
		
		// FINISHED BUTTON
		exitButton = new JButton("EXIT");
		exitButton.addActionListener(this);
		southP.add(exitButton);

		add(southP, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {

		String answer = e.getActionCommand();

		if (answer.equals("ENTER")) {
			if (redNum == blueNum) {
				statusLabel.setText("SUCESSFUL :D");
			} else {
				statusLabel.setText("FAILED :(");
			}
		}

		if (answer.equals("EXIT")) {
			dispose();
		}

	}

}
