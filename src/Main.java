import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Ground losSantos = new Ground(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Thief michael = new Thief(rand.nextInt(losSantos.getRow()),rand.nextInt(losSantos.getColumn()));
        losSantos.setGround(michael.getX(),michael.getY(),1);
        Police[] polices = new Police[losSantos.getPoliceNumb()];
        for (int i = 0 ; i < losSantos.getPoliceNumb() ; i++) //creates polices
        {
            int x = rand.nextInt(losSantos.getRow()),y = rand.nextInt(losSantos.getColumn());
            while (losSantos.getGroundCell(x,y) != 0)
            {
                x = rand.nextInt(losSantos.getRow());
                y = rand.nextInt(losSantos.getColumn());
            }
            polices[i] = new Police(x,y);
            losSantos.setGround(x,y,2);
        }
        while (true)
        {
            if (losSantos.busted(polices))
            {
                System.out.println("WASTED");
                System.exit(0);
            }
            losSantos.CheckSeen();
            for (int i = 0 ; i < losSantos.getPoliceNumb() ;i++)
                polices[i].movement(losSantos);
            michael.movement(losSantos);
            losSantos.PrintGround();
            System.out.println("==================================================");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}