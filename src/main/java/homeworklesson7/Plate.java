package homeworklesson7;

import java.util.concurrent.ThreadLocalRandom;

public class Plate {

    private int foodCount;

    public Plate(int foodCount) {

        this.foodCount = foodCount;
    }

    @Override
    public String toString() {
        return "В миске находится " + foodCount + " корма.";
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void decreaseFood(int catEatFoodCount) {
        foodCount -= catEatFoodCount;
    }
    public void increaseFood() {
        int food = ThreadLocalRandom.current().nextInt(50, 100);
        foodCount += food;
        System.out.println("В миску добавили " + food + " корма.");
    }
}
