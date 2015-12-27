
public class Jet {
private int speed;
private int range;
private int price;
private int capacity;
private String name;

public Jet(String name, int speed, int range, int price, int capacity) {
	super();
	this.name = name;
	this.speed = speed;
	this.range = range;
	this.price = price;
	this.capacity = capacity;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public int getSpeed() {
	return speed;
}

public void setSpeed(int speed) {
	this.speed = speed;
}

public int getRange() {
	return range;
}

public void setRange(int range) {
	this.range = range;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getCapacity() {
	return capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}

@Override
public String toString() {
	return name + " Speed: " + speed + " mph, Range: " + range + " miles, Price: $" + price + " Capacity: " + capacity + " persons";
	
}


}