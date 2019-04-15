import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Ground losSantos = new Ground(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Thief michael = new Thief(rand.nextInt(losSantos.getRow()),rand.nextInt(losSantos.getColumn()));
        losSantos.setGround(michael.getX(),michael.getY(),'T');

    }
}