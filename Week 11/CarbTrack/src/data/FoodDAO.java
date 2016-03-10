package data;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entity.Food;



@Component
@Transactional
public class FoodDAO {
	@PersistenceContext
	EntityManager em;
	

	public List<Food> foodList() {
		List<Food> breakfast = new ArrayList<>();
		List<Food> bigmeal = new ArrayList<>();
		List<Food> snack = new ArrayList<>();
		List<Food> todaysmenu = new ArrayList<>();
		
		Food firstMeal = new Food();
		Food firstSnack = new Food();
		Food firstBigMeal = new Food();
		Food secondSnack = new Food();
		Food secondBigMeal = new Food();
		
		String breakParam = "breakfast";
		String bigmealParam = "bigmeal";
		String snackParam = "snack";
		
		TypedQuery breakfastQuery = (TypedQuery) em.createNamedQuery("Food.getFoodByMealtime").setParameter("mealtime", breakParam);
		TypedQuery bigmealQuery = (TypedQuery) em.createNamedQuery("Food.getFoodByMealtime").setParameter("mealtime", bigmealParam);
		TypedQuery snackQuery = (TypedQuery) em.createNamedQuery("Food.getFoodByMealtime").setParameter("mealtime", snackParam);
		
		breakfast = breakfastQuery.getResultList();
		bigmeal = bigmealQuery.getResultList();
		snack = snackQuery.getResultList();
		
		Collections.shuffle(breakfast);
		Collections.shuffle(bigmeal);
		Collections.shuffle(snack);
		
		firstMeal = breakfast.get(0);
		firstSnack = snack.get(0);
		firstBigMeal = bigmeal.get(0);
		secondSnack = snack.get(1);
		secondBigMeal = bigmeal.get(1);
		
		todaysmenu.add(firstMeal);
		todaysmenu.add(firstSnack);
		todaysmenu.add(firstBigMeal);
		todaysmenu.add(secondSnack);
		todaysmenu.add(secondBigMeal);
		
		return todaysmenu;	
	}
	public Boolean createFood(Food f) {
        em.persist(f);
        if (!em.contains(f)) {
            return false;
        } else {
            return true;
        }
    }
}
