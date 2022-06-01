package homeworklesson6;

public abstract class Animal {

    private String nickName;
    private int maxRunDistance;
    private int maxSwimmingDistance;
    private static int countAnimal;

    public Animal(String nickName, int maxRunDistance, int maxSwimmingDistance) {
        this.nickName = nickName;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimmingDistance = maxSwimmingDistance;
        countAnimal++;
    }

    public abstract void run(int distance);

    public abstract void swimming(int distance);

    public String getNickName() {
        return nickName;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxSwimmingDistance() {
        return maxSwimmingDistance;
    }

    public static int getCountAnimal() {
        return countAnimal;
    }

    public static void printCountAnimal() {
        System.out.println("Всего животных " + getCountAnimal());
    }


}
