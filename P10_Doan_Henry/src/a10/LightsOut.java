package a10;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LightsOut extends JFrame implements ActionListener {
	private LightsButtons[][] buttons;
	private JButton quitButton;
	private JButton restartButton;
    private JLabel counterMSG;
    
	public LightsOut() {
		
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// new instance of the button
		buttons = new LightsButtons[5][5];
		
		//Grid panel
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(5, 5));
		for( int i = 0; i < 5; i++) {
			for( int c = 0; c < 5; c++) {
				buttons[i][c] = new LightsButtons(i, c);
				buttons[i][c].addActionListener(this);
			
				gridPanel.add(buttons[i][c]);
				
				//randomize the color placement
				int random = (int)(Math.random() * 3);
				btnColor(buttons[i][c]);
				if(random == 2) {
					btnColor(buttons[i][c]);
				}		
			}
			
		}
		
		//quit option
		JPanel quitPanel = new JPanel();
		quitButton = new JButton("quit");
		quitButton.addActionListener(this);
		quitPanel.add(quitButton);
		
		//restart option
		JPanel restartPanel = new JPanel();
		restartButton = new JButton("restart");
		restartButton.addActionListener(this);
		restartPanel.add(restartButton);
		
		//Layout
		setTitle("LightsOut");
		setPreferredSize(new Dimension(500, 500));
		this.add(gridPanel, BorderLayout.CENTER);
		this.add(quitPanel, BorderLayout.NORTH);
		this.add(restartPanel, BorderLayout.SOUTH);
		pack();
		
	}
	
	// Magic happens
	public void actionPerformed(ActionEvent e) {	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		int counterOfPress = 0;
		
		// clicked button
		JButton clickedButton = (JButton)e.getSource();	
		
		// counter for counting the moves
		counterOfPress++;
		counterMSG = new JLabel("You have pressed" + counterOfPress + "times" );
		
		// if the button is quitButton
		if (clickedButton == quitButton) {
			dispose();
			return;
		}
		
		// if the clicked Button is restart
		if (clickedButton == restartButton) {
			restart();
			return;
		}
		
		// change btn color
		btnColor(clickedButton);
		
		
		//have the location of the button pressed
		//converting them to numbuers so it will be easier to work with
		String location = clickedButton.getName();
		char colChar = location.charAt(0);
		char rowChar = location.charAt(1);
		int col = Character.getNumericValue(colChar);
		int row = Character.getNumericValue(rowChar);
		
		//have new variables be the surrounding the button
		JButton btnSelected = new JButton();			
		JButton northNeighbor = new JButton();				
		JButton westNeighbor = new JButton();				
		JButton eastNeighbor = new JButton();				
		JButton southNeighbor = new JButton();				
		
		//have the instance be the slected button
		btnSelected = buttons[col][row];	
		
		
		// Try catch method, purpose for more practice and another way of solving the problem
		// Each button is attempted, if it can then it will, if it can't then the catch will
		// Do nothing
		// This be the north of the button button
		try {
			btnSelected = buttons[col - 1][row];	
			northNeighbor = btnSelected;
			btnColor(northNeighbor);					
		 } catch(ArrayIndexOutOfBoundsException i) {
			
		}
		
		// This be the west of the button button
		try {
			btnSelected = buttons[col][row - 1];	
			westNeighbor = btnSelected;
			btnColor(westNeighbor);					
		} catch(ArrayIndexOutOfBoundsException i) {
			
		}
		
		// This be the east of the button button
		try {
			btnSelected = buttons[col][row + 1];	
			eastNeighbor = btnSelected;
			btnColor(eastNeighbor);					
		} catch(ArrayIndexOutOfBoundsException i) {
			
		}
		
		// This be the south of the button button
		try {
			btnSelected = buttons[col + 1][row];		
			southNeighbor = btnSelected;
			btnColor(southNeighbor);				
		} catch(ArrayIndexOutOfBoundsException i) {
			
		}
	
		// run the win method will all of the squares
		won(clickedButton);
		
	}
	
	//calutates winning
	private void won(JButton btn) {
		int count = 0;	
		//logic of winning
		//Loop through all of the tiles so far
		//have the count go up with each black btn
		for( int i = 0; i < 5; i++) {
			for( int c = 0; c < 5; c++) {
				if (btn.getBackground() == Color.BLACK) {
					count++;
				}
			}
		}
		
		// if the black is count of 25 then message
		if(count == 25)	{
			JOptionPane.showMessageDialog(this, "You have won!");
		}
	}

	//toggles the color since the Lights Buttons toggle did not work
	private void btnColor(JButton btn) {
		if(btn.getBackground() == Color.BLACK) {											
			btn.setBackground(Color.WHITE);
		} else {
			btn.setBackground(Color.BLACK);
		}
	}
	
	//restarts the game
	// this will have the new game be generated as the users disposal
	private void restart() {
		dispose();
		LightsOut l = new LightsOut();
		l.setVisible(true);
		return;		
	}
	
	//main method to run everything
	public static void main(String[] args) {
		LightsOut l = new LightsOut();
		l.setVisible(true);
	}
	
}
