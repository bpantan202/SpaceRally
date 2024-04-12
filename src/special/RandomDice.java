package special;

import java.util.Random;

public class RandomDice {

    public static int roleDice() {
        Random rand = new Random();

        int rand_int1 = roleOneDice();
        int rand_int2 = roleOneDice();

        System.out.println(rand_int1);
        System.out.println(rand_int2);

        return rand_int1 + rand_int2;
    }

    private static int roleOneDice() {
        Random rand = new Random();
        return (rand.nextInt(996) % 6) + 1;
    }

}
