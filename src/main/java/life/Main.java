package life;

import java.util.Random;
import java.util.Scanner;

import static java.util.stream.IntStream.range;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int seed = in.nextInt();
            Random r = new Random(seed);
            range(0, n).forEach(i -> {
                range(0, n).forEach(j -> {
                    if (r.nextBoolean()) {
                        System.out.print("O");
                    } else {
                        System.out.print(" ");
                    }
                });
                System.out.println();
            });
        }
    }
}
