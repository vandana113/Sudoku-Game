import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GridPanel extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel[][] smallgrids;
	GridButton[][] buttons;
	Grid grid;

	GridPanel(Grid grid) {
		super(new GridLayout(3, 3));
		// setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		this.grid = grid;
		smallgrids = new JPanel[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				smallgrids[i][j] = new JPanel(new GridLayout(3, 3));
				smallgrids[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
				smallgrids[i][j].setSize(new Dimension(20, 20));
				add(smallgrids[i][j]);
			}
		}

		buttons = new GridButton[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				buttons[i][j]=new GridButton(i,j);
				smallgrids[i/3][j/3].add(buttons[i][j]);
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int num = grid.getNumber(i, j);
				buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				if (num != 0) {
					buttons[i][j].setNumber(num);

					buttons[i][j].setBackground(Color.YELLOW);
					buttons[i][j].setorgColor(Color.yellow);
				} else {
					buttons[i][j].setText("");
					buttons[i][j].setBackground(Color.cyan);
					buttons[i][j].setorgColor(Color.cyan);
				}
				buttons[i][j].setNumber(num);
				buttons[i][j].setBackground(Color.cyan);
				buttons[i][j].setorgColor(Color.cyan);
				buttons[i][j].addMouseListener(this);
				 buttons[i][j].setSize(new Dimension(40, 40));

			}

		}

	}

	public void mouseEntered(MouseEvent e) {
		// GridButton curr = (GridButton) e.getSource();
		// curr.setBackground(Color.WHITE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		GridButton curr = (GridButton) e.getSource();
		if (curr.orgcolor == Color.cyan) {
			int number = grid.getSelectedNumber();
			int x = curr.getX();
			int y = curr.getY();
			grid.setNumber(x, y, number);
			curr.setNumber(number);
		} else {
			JOptionPane.showMessageDialog(this, "You cannot change this Number");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		// GridButton curr = (GridButton) e.getSource();
		// curr.setBackground(curr.getorgColor());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
