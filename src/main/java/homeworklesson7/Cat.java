package homeworklesson7;

import java.util.concurrent.ThreadLocalRandom;

public class Cat {

    private String name;
    private int maxAppetite;
    private int appetite;

    public Cat(String name) {
        this.name = name;
        maxAppetite = ThreadLocalRandom.current().nextInt(70, 101);
        appetite = ThreadLocalRandom.current().nextInt(30, maxAppetite);
    }


    private void setAppetite(int appetite) {
        this.appetite += appetite;
    }

    public boolean isMaxAppetite() {
        return maxAppetite == appetite;
    }

    private int differenceAppetite() {
        return maxAppetite - appetite;
    }

    private int eatFoodCount() {
        int catEatFoodCount = ThreadLocalRandom.current().nextInt(3, 8);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if((differenceAppetite() - catEatFoodCount) < 0 ) {
            return differenceAppetite();
        }
        return catEatFoodCount;
    }

    public void eat(Plate plate) {
        if(!isMaxAppetite()) {
            int catEatFoodCount  = eatFoodCount();

            if(plate.getFoodCount() - catEatFoodCount > 0) {
                plate.decreaseFood(catEatFoodCount);
                setAppetite(catEatFoodCount);
                System.out.println("Котик " + name + " съел " + catEatFoodCount + " корма");
                eat(plate);
            }
            else {
                plate.decreaseFood(plate.getFoodCount());
                setAppetite(catEatFoodCount);
                System.out.println("Котик " + name + " съел " + catEatFoodCount + " корма и опустошил миску. Нужен новый корм!");
            }
        }
        else {
            System.out.println("Котик " + name + " сытый.");
        }

    }

    @Override
    public String toString() {
        return String.format("Кот по кличке %s. Максимальная сытость равна %d, " +
                "а текущая равна %d.", name, maxAppetite, appetite);
    }
}
