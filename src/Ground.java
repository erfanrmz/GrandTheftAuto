public class Ground {
    private int row;
    private int column;
    private int policeNumb;
    private char[][] ground;

    public Ground(int row, int column, int policeNumb) {
        this.row = row;
        this.column = column;
        this.policeNumb = policeNumb;
        ground = new char[row][column];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                ground[i][j] = '-';
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPoliceNumb() {
        return policeNumb;
    }

    public void setGround(int x, int y, char type) {
        ground[x][y] = type;
    }

    public char getGroundCell(int x, int y) {
        return ground[x][y];
    }

    public void PrintGround() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                System.out.print("|" + ground[i][j] + "|");
            System.out.println();
        }
    }


}
