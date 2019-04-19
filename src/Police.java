import java.util.Random;

public class Police {
    private int x;
    private int y;
    private int lastX;
    private int lastY;

    public Police(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void movement(Ground ground)
    {
        ground.setGround(x,y,-2);
        lastY = y;
        lastX = x;
        if (ground.getSeen())
        {
            if (x < ground.getXthief())
                x++;
            else if (x > ground.getXthief())
                x--;
            if (y < ground.getYthief())
                y++;
            else if (y > ground.getYthief())
                y--;
            ground.setGround(x,y,2);
        }
        else
        {
            Random rand = new Random();
            while (true)
            {
                int w = rand.nextInt(8) + 1;
                if (w == 1 && x-1 >= 0 && y-1 >= 0)
                {
                    x -= 1;
                    y -= 1;
                    ground.setGround(x,y,2);
                    return;
                }
                else if (w == 2 && y-1 >= 0)
                {
                    y -= 1;
                    ground.setGround(x,y,2);
                    return;
                }
                else if (w == 3 && y-1 >= 0 && x+1 < ground.getRow())
                {
                    x += 1;
                    y -= 1;
                    ground.setGround(x,y,2);
                    return;
                }
                else if (w == 4 && x-1 > 0)
                {
                    x -= 1;
                    ground.setGround(x,y,2);
                    return;
                }
                else if (w == 5 && x+1 < ground.getRow())
                {
                    x+= 1;
                    ground.setGround(x,y,2);
                    return;
                }
                else if (w == 6 && y+1 < ground.getColumn() && x-1 > 0)
                {
                    x -= 1;
                    y += 1;
                    ground.setGround(x,y,2);
                    return;
                }
                else if (w == 7 && y+1 < ground.getColumn() && x+1 < ground.getRow())
                {
                    x += 1;
                    y += 1;
                    ground.setGround(x,y,2);
                    return;
                }
                else if (w == 8 && y+1 < ground.getColumn())
                {
                    y += 1;
                    ground.setGround(x,y,2);
                    return;
                }
            }

        }

    }

}
