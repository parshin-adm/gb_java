public class HomeWorkApp {

    public static void main(String[] args) {

    }

    private static boolean isCheckRangeNumbers(int a, int b) {
        int sum = a + b;
        return sum > 10 && sum <= 20;
    }

    private static void checkNumber(int a) {
        if(a >= 0)
            System.out.println("Положительное число");
        else
            System.out.println("Отрицательное число");
    }

    private static boolean isCheckNumber(int a) {
        return a < 0;
    }

    private static void print(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    private static boolean isCheckLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || (year % 100 == 0 && year % 400 == 0));
    }

}
