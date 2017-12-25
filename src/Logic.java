import javax.swing.JOptionPane;

public class Logic {
	final static int B = 0;
	final static int O = 1;
	final static int X = 2;
	private int[] states = new int[9];
	public static final int xTurn = 0;
	public static final int oTurn = 1;
	private int turn = xTurn;

	public Logic() {
		for (int i = 0; i < states.length; i++) {
			states[i] = B;
		}
	}

	public int handleWinCondition() {
		String winner = "";
		if (turn == xTurn) {
			winner = "X";
		} else {
			winner = "O";
		}
		JOptionPane.showConfirmDialog(null, winner + " wins! Do you want to play again?", "Win",
				JOptionPane.YES_NO_OPTION);
		return 0;
	}

	public boolean handleDrawCondition() {
		boolean replay = false;
		return replay;
	}

	public int getTurn() {
		return turn;
	}

	public void changeTurn() {
		if (turn == xTurn) {
			turn = oTurn;
		} else {
			turn = xTurn;
		}
	}

	public void setState(int location) {
		if (turn == Logic.xTurn) {
			states[location] = X;
		} else {
			states[location] = O;
		}
	}

	public boolean checkForWin() {
		int value = 0;
		if (turn == xTurn) {
			value = X;
		} else {
			value = O;
		}
		if (states[0] == value && states[1] == value && states[2] == value) {
			return true;
		} else if (states[3] == value && states[4] == value && states[5] == value) {
			return true;
		} else if (states[6] == value && states[7] == value && states[8] == value) {
			return true;
		} else if (states[0] == value && states[3] == value && states[6] == value) {
			return true;
		} else if (states[1] == value && states[4] == value && states[7] == value) {
			return true;
		} else if (states[2] == value && states[5] == value && states[8] == value) {
			return true;
		} else if (states[0] == value && states[4] == value && states[8] == value) {
			return true;
		} else if (states[2] == value && states[4] == value && states[6] == value) {
			return true;
		}
		return false;
	}

	public boolean checkForDraw() {
		for (int i = 0; i < states.length; i++) {
			if (states[i] == B) {
				return false;
			}
		}
		return true;
	}
}
