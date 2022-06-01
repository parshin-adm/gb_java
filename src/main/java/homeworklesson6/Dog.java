package homeworklesson6;

public class Dog extends Animal{

    private static int countDog;

    public Dog(String nickName) {
        super(nickName, 500, 10);
        countDog++;
    }

    @Override
    public void run(int distance) {
        if(distance <= getMaxRunDistance()) {
            System.out.printf("Собака по кличке %s пробежал(а) %d метров.\n", getNickName(), distance);
        }
        else {
            System.out.printf("Собака по кличке %s не может пробежать %d метров. Пожалейте песика!\n", getNickName(), distance);
        }
    }

    @Override
    public void swimming(int distance) {
        if(distance <= getMaxSwimmingDistance()) {
            System.out.printf("Собака по кличке %s проплыл(а) %d метров.\n", getNickName(), distance);
        }
        else {
            System.out.printf("Собака по кличке %s не может проплыть %d метров. Пожалейте песика!\n", getNickName(), distance);
        }

    }

    public static int getCountDog() {
        return countDog;
    }

    public static void printCountDog() {
        System.out.println("Всего собак " + getCountDog());
    }
}
