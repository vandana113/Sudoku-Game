
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ButtonPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Grid grid;

	JButton[] buttons;
	ButtonGroup group;
	JButton Exit, New;

	public ButtonPanel(Grid grid) {
		// TODO Auto-generated constructor stub
		super(new BorderLayout());
		this.grid = grid;

		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.PAGE_AXIS));

		JPanel pnlOptions = new JPanel(new FlowLayout(FlowLayout.LEADING));
		pnlOptions.setBorder(BorderFactory.createTitledBorder(" Options "));

		New = new JButton("New");
		New.addActionListener(this);
		pnlOptions.add(New);

		Exit = new JButton("Exit");
		New.addActionListener(this);
		pnlOptions.add(Exit);

		pnl.add(pnlOptions);

		JPanel Numbers = new JPanel();
		Numbers.setLayout(new BoxLayout(Numbers, BoxLayout.PAGE_AXIS));
		Numbers.setBorder(BorderFactory.createTitledBorder("Numbers"));

		JPanel numbersFlow = new JPanel();
		numbersFlow.setLayout(new FlowLayout(FlowLayout.LEADING));

		buttons = new JButton[9];
		group = new ButtonGroup();

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttons[i].setText("" + (i + 1));
			buttons[i].setPreferredSize(new Dimension(50, 40));
			buttons[i].addActionListener(this);

			group.add(buttons[i]);
			numbersFlow.add(buttons[i]);
		}

		Numbers.add(numbersFlow);
		pnl.add(Numbers);
		add(pnl, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton currButton = (JButton) e.getSource();
		String text = currButton.getText();
		if (text.equals("Exit"))
			System.exit(0);
		else if (text.equals("New")) {
			grid.newGame();
			
		} else {
			grid.setSelectedNo(Integer.parseInt(text));
			System.out.println(grid.getSelectedNumber());
		}

	}
}
