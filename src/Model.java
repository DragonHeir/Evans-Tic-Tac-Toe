import java.util.Observable;

public class Model extends Observable {
	final static int B = 0;
	final static int O = 1;
	final static int X = 2;
	private int[] states = new int[9];
	public static final int xTurn = 0;
	public static final int oTurn = 1;
	private int turn = xTurn;
	private boolean gameOver = false;
	private String winner = "";

	public Model() {
		for (int i = 0; i < states.length; i++) {
			states[i] = B;
		}
	}

	public int getTurn() {
		return turn;
	}
	public String getWinner() {
		return winner;
	}

	public void changeTurn() {
		if (turn == xTurn) {
			turn = oTurn;
		} else {
			turn = xTurn;
		}
	}

	public void setState(int location) {
		if (turn == Model.xTurn) {
			turn = Model.oTurn;
			states[location] = X;
		} else {
			states[location] = O;
			turn = Model.xTurn;
		}
		setChanged();
		notifyObservers(null);;
	}

	public boolean checkForWin() {
		int value = 0;
		boolean isWin = false;
		if (turn == xTurn) {
			value = X;
		} else {
			value = O;
		}
		if (states[0] == value && states[1] == value && states[2] == value) {
			isWin = true;
		} else if (states[3] == value && states[4] == value && states[5] == value) {
			isWin = true;
		} else if (states[6] == value && states[7] == value && states[8] == value) {
			isWin = true;
		} else if (states[0] == value && states[3] == value && states[6] == value) {
			isWin = true;
		} else if (states[1] == value && states[4] == value && states[7] == value) {
			isWin = true;
		} else if (states[2] == value && states[5] == value && states[8] == value) {
			isWin = true;
		} else if (states[0] == value && states[4] == value && states[8] == value) {
			isWin = true;
		} else if (states[2] == value && states[4] == value && states[6] == value) {
			isWin = true;
		}
		if (isWin) {
			if (value == X) {
				winner = "X";
			}
			else {
				winner = "O";
			}
		}
		return isWin;
	}
	
	public void resetGame() {
		for (int i = 0; i < states.length; i++) {
			states[i] = B;
		}
	}
	public boolean isGameOver() {
		return gameOver;
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
