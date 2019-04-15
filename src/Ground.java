public class Ground {
    private int row;
    private int column;
    private int policeNumb;
    private int[][] ground;
    private int xthief;
    private int ythief;
    private Boolean seen = false;

    public Ground(int row, int column, int policeNumb) {
        this.row = row;
        this.column = column;
        this.policeNumb = policeNumb;
        ground = new int[row][column];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                ground[i][j] = 0;
    }

    public Boolean getSeen() {
        return seen;
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

    public void setGround(int x, int y, int type) {
        ground[x][y] = type;
        if (type == 1) {
            xthief = x;
            ythief = y;
        }
    }

    public int getGroundCell(int x, int y) {
        return ground[x][y];
    }

    public void PrintGround() {
        char c = '-';
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (ground[i][j] == 0)
                    c = '-';
                else if (ground[i][j] == 1)
                    c = 'T';
                else if (ground[i][j] == 2)
                    c = 'P';
                System.out.print("|" + c + "|");
            }
            System.out.println();
        }
    }
    //TODO Seen
    //public Boolean CheckSeen() {

    //}
    public boolean checkEmptiness(int x, int y) {
        if (ground[x][y] == 0)
            return true;
        return false;
    }
}
