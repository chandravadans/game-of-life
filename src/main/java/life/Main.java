package life;

import life.generator.DefaultGenerator;
import life.generator.Generator;
import life.model.DefaultMap;
import life.model.Map;

import java.util.Random;
import java.util.Scanner;

import static java.util.stream.IntStream.range;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int seed = in.nextInt();
            Random r = new Random(seed);
            Map map = new DefaultMap.Builder(n).build();
            range(0, n).forEach(i -> {
                range(0, n).forEach(j -> {
                    map.setCellState(i, j, r.nextBoolean());
                });
            });
            System.out.println("Initial Map: \n" + map);

            int numGenerations = in.nextInt();
            Generator generator = new DefaultGenerator();
            System.out.println("Generation # " + numGenerations + ": \n" + generateNthMap(generator, map, numGenerations));
        }
    }

    static Map generateNthMap(Generator generator, Map initial, int n) {
        if (n == 0) {
            return initial;
        } else {
            Map next = generator.nextMap(initial);
            System.out.println("Next generation: \n " + next);
            return generateNthMap(generator, next, n - 1);
        }
    }
}
