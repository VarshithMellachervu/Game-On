import javax.swing.JFrame;
public class TGameFrame1 extends JFrame
{
	private static final long serialVersionUID = 1L;

	TGameFrame1() {
		TGamePanel panel = new TGamePanel();
		this.add(panel);
		this.setTitle("Tic Tac Toe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}




