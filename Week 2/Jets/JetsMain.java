import java.util.*;
public class JetsMain {
public static void main(String[] args) {
	
	int choice;
	boolean exit = false;
	Scanner scanner = new Scanner(System.in);
	Jet Concorde = new Jet("Concorde", 1200, 2000, 4000000, 200);
	Jet SevThirSev = new Jet("737", 400, 1200, 2000000, 400);
	Jet C130 = new Jet("C130", 200, 700, 500000, 50);
	Jet Supafly = new Jet("Supafly", 100, 5000, 1500000, 30);
	
	Jet array[] = {C130, SevThirSev, Concorde, Supafly};
	
	do {
		System.out.println("Welcome to the MCDANIEL AIRLINE");
		System.out.println("Press 1 to List The Fleet");
		System.out.println("Press 2 to Show the Fastest Jet");
		System.out.println("Press 3 to Show the Jet with Longest Range");	
		System.out.println("Press 4 To Add Jet to Fleet");
		System.out.println("Press 5 to Quit");
		choice = scanner.nextInt();
		
		switch (choice) {
		
		case 1: 
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
			break;
		case 2:
			System.out.println(fastest(array));
			break;
		case 3: 
			System.out.println(rangiest(array));
			break;
		case 4: 
			array = addJet(array);
			System.out.println("Your new List of Jets is as follows:");
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
			break;
		case 5:
			System.out.println("Goodbye.");
			exit = true;
			break;
		default: 
			System.out.println("Invalid Selection");
			break;
			
		}
	} while (exit == false);
}
public static Jet fastest(Jet[] array) {
	int speed = 0;
	Jet fastest = array[0];
	for (int i = 0; i < array.length; i++) {
		if (array[i].getSpeed() > speed) {
			speed = array[i].getSpeed();
			fastest = array[i];
		}
	}
	return fastest;
}
public static Jet rangiest(Jet[] array) {
	int range = 0;
	Jet rangiest = array[0];
	for (int i = 0; i < array.length; i++) {
		if (array[i].getRange() > range) {
			range = array[i].getSpeed();
			rangiest = array[i];
		}
	}
	return rangiest;
}
public static Jet[] addJet(Jet[] array) {
	Scanner scanner = new Scanner(System.in);
	Jet newArray[] = new Jet[(array.length + 1)];
	for (int i = 0; i < array.length; i++) {
		newArray[i] = array[i];
	}
	String name;
	int speed;
	int range;
	int price;
	int capacity;
	System.out.println("Please input the name of the new Jet.");
	name = scanner.next();
	System.out.println("Please input the speed of the new Jet");
	speed = scanner.nextInt();
	System.out.println("Please input the range of the new Jet");
	range = scanner.nextInt();
	System.out.println("Please input the price of the new Jet");
	price = scanner.nextInt();
	System.out.println("Please input the capacity of the new Jet");
	capacity = scanner.nextInt();
	Jet add = new Jet(name, speed, range, price, capacity);
	newArray[(array.length)] = add;
	
	return newArray;
}
}