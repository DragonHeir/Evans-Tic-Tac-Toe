import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener  {
	public static void main(String[] args) {
		Main m = new Main();
		Graphics g = new Graphics();
		Logic l = new Logic();
		g.setActionListener(m);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Boop");
		
	}
}
