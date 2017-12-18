
public class Logic {
	final static int B = 0;
	final static int O = 1;
	final static int X = 2;
	private int[] states = new int[9];
	private final int xTurn = 0;
	private final int yTurn = 1;
	private int turn = xTurn;

	public Logic() {
		for (int i = 0; i < states.length; i++) {
			states[i] = B;
		}		
	}
	public boolean checkWin(int buttonLocation) {
		boolean isWin = false;
		return isWin;
	}
	public boolean handleWinCondition() {
		boolean replay = false;
		
		return replay;
	}
	public boolean handleDrawCondition() {
boolean replay = false;
		return replay;
	}
}
