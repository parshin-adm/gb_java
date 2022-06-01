package homeworklesson6;

public class Cat extends Animal{

    private static int countCat;

    public Cat(String nickName) {
        super(nickName, 200, 0);
        countCat++;
    }

    @Override
    public void run(int distance) {
        if(distance <= getMaxRunDistance()) {
            System.out.printf("Кот по кличке %s пробежал(а) %d метров.\n", getNickName(), distance);
        }
        else {
            System.out.printf("Кот по кличке %s не может пробежать %d метров. Пожалейте котика!\n", getNickName(), distance);
        }
    }

    @Override
    public void swimming(int distance) {
        System.out.printf("Кот по кличке %s не может проплыть %d метров. Коты не плавают!!!\n", getNickName(), distance);
    }

    public static int getCountCat() {
        return countCat;
    }

    public static void printCountCat() {
        System.out.println("Всего котов " + getCountCat());
    }
}
