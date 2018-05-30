package showboard;

import javax.swing.JFrame;

public class BoardFrame extends JFrame {
	
	private final int FRAME_HEIGHT = 1080;
	private final int FRAME_WIDTH = 1920;
	
	public BoardFrame() {
		  add(new BoardPanel());
	        
	        setSize(FRAME_HEIGHT, FRAME_WIDTH);
	        setResizable(false);
	        
	        setTitle("Lorann");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}