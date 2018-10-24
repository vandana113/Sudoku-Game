import java.awt.Color;

import javax.swing.JButton;

public class GridButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x, y;
	Color orgcolor;

	GridButton(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return x;
	}

	public void setNumber(int number) {
		setText("" + number);
	}

	public int getNumber() {
		return Integer.parseInt(getText());
	}

	public void setorgColor(Color c) {
		orgcolor=c;
	}

	public Color getorgColor() {
		return orgcolor;
	}
}
