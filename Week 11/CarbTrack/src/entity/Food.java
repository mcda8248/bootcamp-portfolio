package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="food")
@NamedQueries(
{ @NamedQuery(name = "Food.getFoodByMealtime", query = "select f from Food f where f.mealtime= :mealtime"),
		@NamedQuery(name = "Food.getFoodByCarbCount", query = "select f from Food f where f.carbcount =:carbcount"),
		 })
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mealtime;
	private int carbcount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMealtime() {
		return mealtime;
	}
	public void setMealtime(String mealtime) {
		this.mealtime = mealtime;
	}
	public int getCarbcount() {
		return carbcount;
	}
	public void setCarbCount(int carbcount) {
		this.carbcount = carbcount;
	}
}