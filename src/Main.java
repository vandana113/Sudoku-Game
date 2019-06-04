import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
import javax.swing.JPanel;
//import javax.swing.plaf.ButtonUI;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7643472570236631148L;

	JPanel mainPanel = new JPanel();
	//private static int K = 9;

	Main() {
		super("Sudoku");
		setSize(1500,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Grid grid = new Grid();
		ButtonPanel buttonPanel = new ButtonPanel(grid);
		GridPanel gridPanel = new GridPanel(grid);

		mainPanel.setLayout(new BorderLayout());

		mainPanel.add(buttonPanel, BorderLayout.EAST);

		mainPanel.add(gridPanel, BorderLayout.CENTER);

		add(mainPanel);
		//pack();
		setVisible(true);
	}
}
