import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphics {
	JFrame gameWindow = new JFrame("Tic Tac Toe");
	JPanel playField = new JPanel(new GridLayout(3,3));
	JButton[] tiles = new JButton[9];

	Graphics() {
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

	int getClickedButtonLocation() {
		return 0;
	}

	void resetGame() {

	}

	void setActionListener(ActionListener a) {
		for (int i = 0; i < tiles.length; i++) {
			tiles[i].addActionListener(a);			
		}

	}
}
