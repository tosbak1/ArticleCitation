import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class View extends JFrame implements Observer {
	private ActionListener listener;
	private JFrame jframe;
	private JPanel jpanel;
	private JTextArea text, text2, text3;
	private JRadioButton radio1, radio2;
	private Border border;
	private JLabel label1;
	private JLabel label2;

	private Model cm;

	public View(ActionListener listener) {
		this.listener = listener;
		// Frame set up with label Counter and size
		jframe = new JFrame("Name Format");
		jframe.setSize(300, 300);

		jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jframe.setLayout(new BorderLayout());

		// Panel set up with a grid layout of 4X2
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(4, 2));

		// Set up for the Text area where first and last name will be entered
		text = new JTextArea();
		text2 = new JTextArea();
		text3 = new JTextArea();

		// Set a border for the first and last name blocks
		border = BorderFactory.createLineBorder(Color.BLACK);

		// Initialize the lebels for First name and last name
		label1 = new JLabel("First name");
		label2 = new JLabel("Last Name");

		// set the borders of the text areas and set it to editable
		text.setBorder(border);
		text2.setBorder(border);
		text3.setBorder(border);

		text.setEditable(true);
		text2.setEditable(true);
		text3.setEditable(false);

		// Initialize the radio with their respective labels and add action listener always
		radio1 = new JRadioButton("IEEE");
		radio2 = new JRadioButton("ACM");

		//You do not want to be able to click on two buttons at the same time so add them to a group
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(radio1);
		bgroup.add(radio2);

		radio1.addActionListener(listener);
		radio2.addActionListener(listener);

		// add all the labels, text and radio buttons to the panel
		jpanel.add(label1);
		jpanel.add(text);
		jpanel.add(label2);
		jpanel.add(text2);
		jpanel.add(radio1);
		jpanel.add(radio2);
		jpanel.add(text3);

		jframe.getContentPane().add(jpanel, BorderLayout.CENTER);
		jframe.setVisible(true);

	}

	// returns the first name that was entered
	public String getFirst() {
		if(text.getText().equals("")){
			return "Unknown";
		}
		else{
			return this.text.getText();
		}
		
	}
	
	// returns the second name that was entered
	public String getLast() {
	if(text2.getText().equals("")){
			return "Unknown";
	}
		return this.text2.getText();
	}

	// returns the text for IEEE radio button
	public String actionCmdIEEE() {
		return radio1.getText();
	}
/*
	// returns the text for ACM radio button
	public String actionCmdACM() {
		return radio2.getText();
	}

*/

	/*
	 * public static void main(String[] args){ Controller c = new Controller();
	 * View cv = new View(c);
	 * 
	 * }
	 */

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//Model m = (Model) o;
		String result = (String) arg;
		this.text3.setText(result);

	}

}
