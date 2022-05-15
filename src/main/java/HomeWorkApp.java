public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

    }

    private static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    private static void checkSumSign(){
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * -10);

        if((a+b) >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    private static void printColor() {
        int value = (int) (Math.random() * 500) - 100;

        if(value <= 0)
            System.out.println("Красный");
        else if(value <= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }

    private static void compareNumbers() {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);

        if(a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }
}
