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

    public int getXthief() {
        return xthief;
    }

    public int getYthief() {
        return ythief;
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
        ground[x][y] += type;
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
                else if (ground[i][j] % 2 == 0)
                    c = 'P';
                System.out.print("|" + c);
            }
            System.out.println("|");
        }
    }

    public Boolean CheckSeen() {
        seen = false;
        if (xthief - 2 >= 0 && ythief - 2 >= 0 && ground[xthief - 2][ythief - 2] % 2 == 0)
            seen = true;
        else if (xthief - 2 >= 0 && ythief - 1 >= 0 && ground[xthief - 2][ythief - 1] % 2 == 0)
            seen = true;
        else if (xthief - 2 >= 0 && ground[xthief - 2][ythief] % 2 == 0)
            seen = true;
        else if (xthief - 2 >= 0 && ythief + 1 < column && ground[xthief - 2][ythief + 1] % 2 == 0)
            seen = true;
        else if (xthief - 2 >= 0 && ythief + 2 < column && ground[xthief - 2][ythief + 2] % 2 == 0)
            seen = true;

        else if (xthief - 1 >= 0 && ythief - 2 >= 0 && ground[xthief - 1][ythief - 2] % 2 == 0)
            seen = true;
        else if (xthief - 1 >= 0 && ythief - 1 >= 0 && ground[xthief - 1][ythief - 1] % 2 == 0)
            seen = true;
        else if (xthief - 1 >= 0 && ground[xthief - 1][ythief] % 2 == 0)
            seen = true;
        else if (xthief - 1 >= 0 && ythief + 1 < column && ground[xthief - 1][ythief + 1] % 2 == 0)
            seen = true;
        else if (xthief - 1 >= 0 && ythief + 2 < column && ground[xthief - 1][ythief + 2] % 2 == 0)
            seen = true;

        else if (ythief - 2 >= 0 && ground[xthief][ythief - 2] % 2 == 0)
            seen = true;
        else if (ythief - 1 >= 0 && ground[xthief][ythief - 1] % 2 == 0)
            seen = true;
        else if (ythief + 1 < column && ground[xthief][ythief + 1] % 2 == 0)
            seen = true;
        else if (ythief + 2 < column && ground[xthief][ythief + 2] % 2 == 0)
            seen = true;

        else if (xthief + 1 < row && ythief - 2 >= 0 && ground[xthief + 1][ythief - 2] % 2 == 0)
            seen = true;
        else if (xthief + 1 < row && ythief - 1 >= 0 && ground[xthief + 1][ythief - 1] % 2 == 0)
            seen = true;
        else if (xthief + 1 < row && ground[xthief + 1][ythief] % 2 == 0)
            seen = true;
        else if (xthief + 1 < row && ythief + 1 < column && ground[xthief + 1][ythief + 1] % 2 == 0)
            seen = true;
        else if (xthief + 1 < row && ythief + 2 < column && ground[xthief + 1][ythief + 2] % 2 == 0)
            seen = true;

        else if (xthief + 2 < row && ythief - 2 >= 0 && ground[xthief + 2][ythief - 2] % 2 == 0)
            seen = true;
        else if (xthief + 2 < row && ythief - 1 >= 0 && ground[xthief + 2][ythief - 1] % 2 == 0)
            seen = true;
        else if (xthief + 2 < row && ground[xthief + 2][ythief] % 2 == 0)
            seen = true;
        else if (xthief + 2 < row && ythief + 1 < column && ground[xthief + 2][ythief + 1] % 2 == 0)
            seen = true;
        else if (xthief + 2 < row && ythief + 2 < column && ground[xthief + 2][ythief + 2] % 2 == 0)
            seen = true;
        return seen;
    }

    public Boolean busted(Police[] polices) {
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                if (ground[i][j] % 2 == 1 && ground[i][j] != 1)
                    return true;
        for (int i = 0; i < polices.length; i++)
            if (polices[i].getLastX() == xthief && polices[i].getLastY() == ythief)
                return true;
        return false;
    }

}
