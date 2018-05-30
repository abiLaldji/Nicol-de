package showboard;

import javax.swing.JFrame;


public class BoardFrame extends JFrame {
	
	this.add(new BoardPanel);
    
    this.setSize(900, 900);
    this.setResizable(false);
    
    this.setTitle("Lorann");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}