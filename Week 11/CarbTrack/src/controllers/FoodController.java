package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import data.FoodDAO;
import entity.Food;


@Controller
public class FoodController {
	@Autowired
	FoodDAO foodDAO;
	

	@ResponseBody
	@RequestMapping("meals")
	public List<Food> getFoodList() {
		return foodDAO.foodList();
	}
	
    @ResponseBody
    @RequestMapping(path = "newMeal", method = RequestMethod.POST)
    public Boolean createMeal(@RequestBody Food f) {
        return foodDAO.createFood(f);
    }
}
