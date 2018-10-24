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

//	private void menu() {
//		JMenuBar menuBar = new JMenuBar();
//
//		JMenu diffculty = new JMenu("Diffculty");
//		JMenuItem easy = new JMenuItem("Easy");
//		JMenuItem medium = new JMenuItem("Medium");
//		JMenuItem hard = new JMenuItem("Hard");
//		diffculty.add(easy);
//		diffculty.add(medium);
//		diffculty.add(hard);
//		menuBar.add(diffculty);
//
//		JMenu about = new JMenu("About");
//		JMenuItem game = new JMenuItem("About the Game");
//		JMenuItem rules = new JMenuItem("Rules");
//		about.add(game);
//		about.add(rules);
//		menuBar.add(about);
//
//	}

}
