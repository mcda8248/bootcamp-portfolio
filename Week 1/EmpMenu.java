package examples;

import java.util.Scanner;

public class EmpMenu {
	public static void main(String[] args) {

		int optionSelected;
		String list[] = { "Adam McDaniel" };

		Scanner keyboard = new Scanner(System.in);

		while (true) {
			printMenu();
			optionSelected = keyboard.nextInt();
			if (optionSelected == 4)
				break;

			switch (optionSelected) {

			case 1: // call list
				printList(list);
				break;
			case 2: // call hire
				list = hireEmp(list);
				break;
			case 3: // call Fire
				list = fireEmp(list);
				break;
			default:
				System.out.println("Invalid Response");
				break;

			}

		}

	}

	public static void printMenu() {

		System.out.println("Option 1: List Employees");
		System.out.println("Option 2: Hire Employees");
		System.out.println("Option 3: Fire Employee :( ");
		System.out.println("Option 4: Quit");
		System.out.println("Please select an option");

	}

	public static void printList(String[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}

	public static String[] hireEmp(String[] list)

	{
		Scanner keyboard = new Scanner(System.in);

		String toPush[] = new String[list.length + 1];

		for (int i = 0; i < list.length; i++) {
			toPush[i] = list[i];
			System.out.println(toPush[i]);

		}
		System.out.println("Please enter the name of the new employee.");
		toPush[toPush.length - 1] = keyboard.next();
		return toPush;

	}

	public static String[] fireEmp(String[] list) {

		Scanner keyboard = new Scanner(System.in);
		int temp = 0;
		boolean found = false;
		String toSearch;
		String toPush[] = new String[list.length];
		for (int i = 0; i < list.length; i++) {
			toPush[i] = list[i];
		}

		System.out.println("Please enter the name of the employee to fire.");
		toSearch = keyboard.next();

		for (int i = 0; i < list.length; i++) {
			if (list[i].equalsIgnoreCase(toSearch)) {
				temp = i;
				found = true;
			}
		}

		if (found == true) {
			list[temp] = list[list.length - 1];
			toPush = new String[list.length - 1];
			for (int i = 0; i < list.length - 1; i++) {
				toPush[i] = list[i];
			}
			return toPush;
		} else {
			System.out.println("Employee not found");
			return toPush;
		}
	}

}