package project.irfananda.homefood.object;

import java.util.ArrayList;
import java.util.List;

import project.irfananda.homefood.R;

/**
 * Created by irfananda on 22/03/16.
 */
public class DefineListFood {
    private List<Food> foodList = new ArrayList<>();
    private Food food;
    private int[] imgmedium = {
            R.drawable.starwars,
            R.drawable.ayam_bakar,
            R.drawable.ayam_goreng,
            R.drawable.burger,
            R.drawable.cake,
            R.drawable.donut,
            R.drawable.fried_rice,
            R.drawable.hotdog,
            R.drawable.makaroni,
            R.drawable.pizza
    };

    public List<Food> getFoodDiscover(){
        food = new Food(imgmedium[6], "Nasi goreng", 10000, false, "Rahayu");
        foodList.add(food);
        food = new Food(imgmedium[7], "Hotdog", 10000, false, "Rahayu");
        foodList.add(food);
        food = new Food(imgmedium[2], "Ayam Goreng", 12000, false, "Yuli");
        foodList.add(food);
        food = new Food(imgmedium[1], "Ayam Bakar", 12000, false, "Masboy");
        foodList.add(food);
        food = new Food(imgmedium[5], "Donut", 12000, false, "Yuli");
        foodList.add(food);
        food = new Food(imgmedium[4], "Cake", 17000, false, "Yuli");
        foodList.add(food);
        food = new Food(imgmedium[8], "Macaroni", 17000, false, "Dinda");
        foodList.add(food);
        food = new Food(imgmedium[9], "Pizza", 17000, false, "Meli");
        foodList.add(food);

        return foodList;
    }

    public List<Food> getFoodOrder(){
        food = new Food(imgmedium[3], "Burger", 10000, 2, "Rahayu", "20:00", 3);
        foodList.add(food);
        food = new Food(imgmedium[6], "Nasi goreng", 10000, 0, "Rahayu", "15:20", 1);
        foodList.add(food);
        food = new Food(imgmedium[5], "Donut", 12000, 1, "Yuli", "10:40", 5);
        foodList.add(food);

        return foodList;
    }

    public List<Food> getFoodWishlist(){
        food = new Food(imgmedium[9], "Pizza", 17000, 1, "Meli");
        foodList.add(food);
        food = new Food(imgmedium[5], "Donut", 12000, 1, "Yuli");
        foodList.add(food);

        return foodList;
    }
}
