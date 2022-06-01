package homeworklesson6;

public class Main {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Гектор");
        Dog dog2 = new Dog("Кай");
        Cat cat1 = new Cat("Мурлык");
        Cat cat2 = new Cat("Мурка");

        dog1.run(300);
        dog1.run(600);
        dog2.swimming(10);
        dog2.swimming(15);
        cat1.swimming(100);
        cat1.run(100);
        cat2.run(200);
        cat2.run(300);

        Dog.printCountDog();
        Cat.printCountCat();
        Animal.printCountAnimal();
    }

}
