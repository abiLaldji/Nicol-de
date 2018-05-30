package showboard;

import javax.swing.JFrame;

public class BoardFrame extends JFrame {

	private static final long serialVersionUID = -6563585351564617603L;
	private final int FRAME_HEIGHT = 1080;
	private final int FRAME_WIDTH = 1920;
	private BoardPanel boardPanel;
	
	public BoardFrame() {
		
		this.boardPanel = new BoardPanel();
        this.setContentPane(this.boardPanel);
	        
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        
        this.setTitle("Lorann");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public int getFRAME_HEIGHT() {
		return FRAME_HEIGHT;
	}
	
	public int getFRAME_WIDTH() {
		return FRAME_WIDTH;
	}



}