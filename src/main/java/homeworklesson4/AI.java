package homeworklesson4;

import java.util.Random;

public class AI {


    private int rowNumber;
    private int columnNumber;

    Random random = new Random();
    private final Map map;

    public AI(Map map) {
        this.map = map;
    }


    public void aiTurn() {
        System.out.println("Идет ход противника!");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        do {
            rowNumber = random.nextInt(map.getSize());
            columnNumber = random.nextInt(map.getSize());

        } while (!map.isCellFree(columnNumber, rowNumber));

        map.drawMap(columnNumber, rowNumber, map.getDOT_AI());

    }
    public int getColumnNumber() {
        return columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }





}
