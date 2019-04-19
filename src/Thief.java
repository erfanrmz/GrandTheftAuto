import java.util.Random;

public class Thief {
    private int x;
    private int y;

    public Thief(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void movement(Ground ground)
    {
        Random rand = new Random();
        ground.setGround(x,y,-1);

        while (true)
        {
            int w = rand.nextInt(8) + 1;

            if (w == 1 && x-1 >= 0 && y-1 >= 0)
            {
                x -= 1;
                y -= 1;
                ground.setGround(x,y,1);
                return;
            }
            else if (w == 2 && y-1 >= 0)
            {
                y -= 1;
                ground.setGround(x,y,1);
                return;
            }
            else if (w == 3 && y-1 >= 0 && x+1 < ground.getRow())
            {
                x += 1;
                y -= 1;
                ground.setGround(x,y,1);
                return;
            }
            else if (w == 4 && x-1 > 0)
            {
                x -= 1;
                ground.setGround(x,y,1);
                return;
            }
            else if (w == 5 && x+1 < ground.getRow())
            {
                x+= 1;
                ground.setGround(x,y,1);
                return;
            }
            else if (w == 6 && y+1 < ground.getColumn() && x-1 > 0)
            {
                x -= 1;
                y += 1;
                ground.setGround(x,y,1);
                return;
            }
            else if (w == 7 && y+1 < ground.getColumn() && x+1 < ground.getRow())
            {
                x += 1;
                y += 1;
                ground.setGround(x,y,1);
                return;
            }
            else if (w == 8 && y+1 < ground.getColumn())
            {
                y += 1;
                ground.setGround(x,y,1);
                return;
            }
        }

    }
}
