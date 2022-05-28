package homeworklesson4;

import java.util.Scanner;

public class Game {
    private int turnsCount = 0;
    private int size;
    private int countDot;

    private Scanner in = new Scanner(System.in);
    private Map map;
    private Human human;
    private AI ai;


    public void turnGame() {
        do {
            System.out.println("\nДобро пожаловать в игру крестики-нолики!");
            init();
            playGame();
        } while (isContinueGame());
        endGame();
    }

    private void init() {
        size = initSize();
        map = new Map(size);
        initCountDot(size);
        ruleGame(size);
        map.printMap();
        human = new Human(map);
        ai = new AI(map);
    }

    private void playGame() {
        while (true) {
            human.humanTurn();
            map.printMap();
            turnsCount++;
            if (checkEnd(turnsCount)) {
                break;
            }

            ai.aiTurn();
            map.printMap();
            turnsCount++;
            if (checkEnd(turnsCount)) {
                break;
            }
        }
    }

    private void initCountDot(int size) {

        countDot = switch (size) {
                case 3,4,5,6 -> 3;
                case 7,8,9,10 -> 4;
                default -> 5;
        };
    }

    private boolean isRuleGame() {
        System.out.println("Желаете ознакомится с правилами для вашего размера поля? y\\n");
        return switch (in.next()) {
            case "y", "yes", "да", "+", "д" -> true;
            default -> false;
        };
    }
    private void ruleGame(int size) {
        if(isRuleGame()) {
            switch (size) {
                case 3,4,5,6 -> System.out.println("Победная серия равна 3");
                case 7,8,9,10 -> System.out.println("Победная серия равна 4");
                default ->  System.out.println("Победная серия равна 5");
            };
        }
    }

    private int initSize() {
        System.out.println("Введите нужный размер поля. P.S. " +
                "Не рекомендуем размер поля делать больше 9!");
        int size;
        while (true) {
            if (in.hasNextInt()) {
                size = in.nextInt();
                if(isSizeValid(size)) {
                    break;
                }
                }
            else {
                System.out.println("Нужно ввести целочисленное число. Давайте попробуем снова!");
                in.next();
            }
        }
        return size;
    }


    private boolean isSizeValid(int size) {
        if(size > 2) {
            return true;
        }
        System.out.println("Размер поля должен быть больше или равен 3м");
        return false;
    }

    private boolean isTurnHuman() {
        return turnsCount %2 != 0;
    }



    private boolean checkEnd(int turnsCount) {

       if(isTurnHuman()) {
           if(checkWin(human.getColumnNumber(), human.getRowNumber() )){
               System.out.println("Ура!!!Вы победил");
               return true;
           }
       }
       else if(turnsCount == (map.getSize() * map.getSize())) {
           System.out.println("Ничья");
           return true;
       }
       else {
           if(checkWin(ai.getColumnNumber(), ai.getRowNumber())){ //AI
               System.out.println("Компьютер победил");
               return true;
           }
       }
       return false;

    }

    private boolean checkWin(int x, int y) {
        if(checkWinStr(getStringHorizontal(y))) {
            return true;
        }
        else if(checkWinStr(getStringVertical(x))){
            return true;
        }
        else if(checkWinStr(getStringPositiveDiagonal(x, y))) {
            return true;
        }
        else return checkWinStr(getStringNegativeDiagonal(x, y));

    }

    private String getStringVertical(int x) {
        StringBuilder str = new StringBuilder();
        for (int y = 0; y < map.getSize(); y++) {
            str.append(map.getDotMap(y, x));
        }
        return str.toString();
    }

    private String getStringHorizontal(int y) {
        StringBuilder str = new StringBuilder();
        for (int x = 0; x < map.getSize(); x++) {
            str.append(map.getDotMap(y, x));
        }
        return str.toString();
    }

    private String getStringPositiveDiagonal(int x, int y) {
        // y = x + b
        int b = y - x;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < map.getSize(); i++) {
            x = i;
            y = x + b;
            if(y >= 0 && y < map.getSize()) {
                str.append(map.getDotMap(y, x));
            }

        }
        return str.toString();
    }

    private String getStringNegativeDiagonal(int x, int y) {
        // y = -x + b
        int b = y + x;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < map.getSize(); i++) {
            x = i;
            y = -x + b;
            if(y >= 0 && y < map.getSize()) {
                str.append(map.getDotMap(y, x));
            }
        }
        return str.toString();
    }

    private boolean checkWinStr(String str) {
        int count = 0;
        if(isTurnHuman()) {
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == map.getDOT_HUMAN()){
                    count++;
                }
            }
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == map.getDOT_AI()){
                    count++;
                }
            }
        }
        return count >= countDot;
    }

    private void endGame() {
        in.close();
        System.out.println("THE EHD");
    }

    private boolean isContinueGame() {
        System.out.println("Хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "yes", "да", "+", "д" -> true;
            default -> false;
        };
    }


}
