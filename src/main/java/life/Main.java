package life;

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
            System.out.println(map);
        }
    }
}
