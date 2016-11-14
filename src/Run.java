
public class Run {

	public static void main(String[] args) {
		Model m = new Model();
		Controller c = new Controller(m);
		View v = new View(c);
		c.setView(v);

		m.addObserver(v);
	}
}
