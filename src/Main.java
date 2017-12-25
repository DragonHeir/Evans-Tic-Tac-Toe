import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener  {
	Graphics g = new Graphics();
	Logic l = new Logic();
	public static void main(String[] args) {
		Main m = new Main();
	}
	Main() {
		g.setActionListener(this);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(g.getClickedButtonLocation(e));
		int location = g.getClickedButtonLocation(e);
		g.setTileContents(l.getTurn(), location);
		l.setState(location);
		if (l.checkForWin() == false) {
			if (l.checkForDraw() == true) {
				l.handleDrawCondition();
			}
			l.changeTurn();
		}
		else {
			l.handleWinCondition();
		}
	}
}
