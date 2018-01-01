import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
	JFrame gameWindow = new JFrame("Tic Tac Toe");
	JPanel playField = new JPanel(new GridLayout(3,3));
	JButton[] tiles = new JButton[9];

	View() {
		gameWindow.add(playField);
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new JButton();
			playField.add(tiles[i]);
		}
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setSize(270, 294);
	}

	void setButtonState(int buttonLocation, int state) {

	}

	int getClickedButtonLocation(ActionEvent e) {
		for (int i = 0; i < tiles.length; i++) {
			if (e.getSource() == tiles[i]) {
				return i;
			}
		}
		return -1;
	}

	void resetGame() {
		for (int i = 0; i < tiles.length; i++) {
			tiles[i].setText("");
			tiles[i].setEnabled(true);
		}
	}

	void setActionListener(ActionListener a) {
		for (int i = 0; i < tiles.length; i++) {
			tiles[i].addActionListener(a);			
		}

	}
	public void setTileContents(int turn, int tile){
		if (turn == Model.xTurn) {
			tiles[tile].setText("X");
		}
		else {
			tiles[tile].setText("O");
		}
		tiles[tile].setEnabled(false);
	}
}
