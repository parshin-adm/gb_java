package homeworklesson4;


public class Map {

    private final char DOT_EMPTY = '•';
    private final char DOT_HUMAN = 'X';
    private final char DOT_AI = 'O';
    private final String HEADER_FIRST_SYMBOL = "♯";
    private final String SPACE_MAP = " ";

    private final int size;
    private final char[][] map;


    public Map(int size) {
        this.size = size;
        this.map = new char[size][size];
        initializationMap(map);

    }

    private void initializationMap(char[][] map){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public void printMap() {
        System.out.println("\nИгровое поле:");
        printHeader(size);
        for (int i = 0; i < size; i++) {
            System.out.print((i+1) + spaceHeaderVertical(i+1));
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + spaceHeaderHorizontal(j+1));
            }
            System.out.println();
        }
    }

    private void printHeader(int size) {
        System.out.print(HEADER_FIRST_SYMBOL + spaceHeaderVertical(0));
        for (int i = 0; i < size ; i++) {
            System.out.print((i+1) + SPACE_MAP );
        }
        System.out.println();
    }

    private String spaceHeaderVertical(int currentNumber) {
        String maxNumberStr = Integer.toString(size);
        String currentNumberStr = Integer.toString(currentNumber);
        return SPACE_MAP.repeat(maxNumberStr.length() - currentNumberStr.length() + 1);
    }

    private String spaceHeaderHorizontal(int currentNumber) {
        String currentNumberStr = Integer.toString(currentNumber);
        return SPACE_MAP.repeat(currentNumberStr.length());
    }

    public boolean isCellFree(int columnNumber, int rowNumber) {
        return map[rowNumber][columnNumber] == DOT_EMPTY;
    }


    public void drawMap(int columnNumber, int rowNumber, char c) {
        map[rowNumber][columnNumber] = c;
    }

    public char getDotMap(int y, int x) {
        return map[y][x];
    }

    public char getDOT_HUMAN() {
        return DOT_HUMAN;
    }

    public char getDOT_AI() {
        return DOT_AI;
    }

    public int getSize() {
        return size;
    }

}
