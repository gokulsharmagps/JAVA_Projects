import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameFrame extends JFrame implements GameConstants {
	public GameFrame() {
		setSize(GWidth, GHeight);
		setResizable(false);
		setLocationRelativeTo(null);
		// setTitle("Helicopter");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);

		// this.addWindowListener(new WindowAdapter() {
		// @Override
		// public void windowClosing(WindowEvent e) {
		//
		// String ObjButtons[] = {"Yes","No"};
		// int PromptResult = JOptionPane.showOptionDialog(GameFrame.this,"Are
		// you sure you want to exit ?","Confirmation Required",
		// JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		// if(PromptResult==JOptionPane.YES_OPTION)
		// {
		// System.exit(0);
		// }
		// }
		// });
		// this.addWindowListener(new WindowAdapter() {
		// @Override
		// public void windowClosing(WindowEvent e){
		// GameFrame.this.setVisible(false);
		// GameFrame.this.dispose();
		// }
		// });
		//
	}

	public void loadBoard() {
		Board board = new Board();
		this.add(board);
		board.bindEvent();
	}

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// GameFrame obj=new GameFrame();
	// Toolkit.getDefaultToolkit().sync();
	// obj.loadBoard();
	// }

}
