import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	private Model m;
	private View v;

	public Controller(Model m) {
		this.m = m;
	}

	public void setView(View v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		String first = v.getFirst();
		String last = v.getLast();
		m.setFirst(first);
		m.setLast(last);

		if (action.equals(v.actionCmdIEEE())) {
			m.ieee();
		} else {
			m.acm();
		}

	}

}
