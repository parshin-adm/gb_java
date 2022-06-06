package homeworklesson7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(50);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Мурлык");
        cats[1] = new Cat("Василий");
        cats[2] = new Cat("Федор");
        cats[3] = new Cat("Рыжий");

        for (Cat cat : cats) {
            System.out.println(cat);
            System.out.println(plate);
            if(plate.getFoodCount() == 0) {
                plate.increaseFood();
            }
            cat.eat(plate);
        }

        System.out.println("Сытые коты: ");

        for (Cat cat : cats) {
            if(cat.isMaxAppetite()) {
                System.out.println(cat);
            }
        }


    }
}
