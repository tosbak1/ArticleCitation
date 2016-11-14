import java.util.Observable;
import java.util.Scanner;

public class Model extends Observable {
	private String firstName;
	private String lastName;
	private String result;

	public void setFirst(String first) {
		if(first == null){
			System.out.println("Enter a valid first name");
		}
		else{
			this.firstName = first;
		}
	}

	public void setLast(String last) {
		if(last == null){
			System.out.println("Enter a valid first name");
		}
		else{
			this.lastName = last;
		}
	}

	public String getResult() {
		return this.result;
	}

	public String getFirst() {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		System.out.println("Enter your first name: ");
		String first = reader.next(); // Scans the next token of the input as a
										// String.
		this.firstName = first;
		return first;
	}

	public String getLast() {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		System.out.println("Enter your last name: ");
		String last = reader.next(); // Scans the next token of the input as a
										// String
		this.lastName = last;
		return last;
	}

	public void ieee() {
		String first = this.firstName.substring(0, 1);
		this.result = first + ". " + this.lastName;
		this.setChanged();
		this.notifyObservers(this.getResult());

	}

	public void acm() {
		this.result = this.firstName + " " + this.lastName + ".";
		this.setChanged();
		this.notifyObservers(this.getResult());
	}

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method
	 * stub Model cm = new Model(); String first = cm.getFirst(); String last =
	 * cm.getLast(); String result1 = cm.ieee(); String result2 = cm.acm();
	 * System.out.println("IEEE format: " + result1);
	 * System.out.println("ACM format: " + result2);
	 * 
	 * 
	 * }
	 */

}
