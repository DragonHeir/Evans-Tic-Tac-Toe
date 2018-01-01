import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

public class Controller implements ActionListener, Observer {
	View view = new View();
	Model model = new Model();

	public static void main(String[] args) {
		new Controller();
	}

	Controller() {
		view.setActionListener(this);
		model.addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(view.getClickedButtonLocation(e));
		int location = view.getClickedButtonLocation(e);
		view.setTileContents(model.getTurn(), location);
		model.setState(location);
		

	}

	private boolean checkForReplay() {
		if (model.checkForWin()) {
			int response = JOptionPane.showConfirmDialog(null, model.getWinner() + " wins! Do you want to play again?", "Win",
					JOptionPane.YES_NO_OPTION);
			return response == JOptionPane.YES_OPTION;
		}
		else {
			int response = JOptionPane.showConfirmDialog(null, "It's a draw! Do you want to play again?", "Draw",
					JOptionPane.YES_NO_OPTION);
			return response == JOptionPane.YES_OPTION;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Model) {
			boolean playAgain = false;
			Model model = (Model) o;
			if (model.isGameOver()) {
				playAgain = checkForReplay();
				if (playAgain) {
					view.resetGame();
					model.resetGame();
				} else {
					System.exit(0);
				}
			}
		}
		
	}
}
