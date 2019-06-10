package life.generator;

import life.model.DefaultMap;
import life.model.Direction;
import life.model.Map;

import static java.util.stream.IntStream.range;

public class DefaultGenerator implements Generator {

    @Override
    public Map nextMap(Map current) {
        Map next = new DefaultMap.Builder(current.getDimension()).build();
        range(0, current.getDimension()).forEach(i -> {
            range(0, current.getDimension()).forEach(j -> {
                int numActiveNeighbors = 0;
                for (Direction d : Direction.values()) {
                    if (current.getNeighborState(i, j, d)) {
                        numActiveNeighbors++;
                    }
                }
                if (current.getCellState(i, j)) {
                    if (numActiveNeighbors < 2 || numActiveNeighbors > 3) {
                        next.setCellState(i, j, false);
                    }
                } else {
                    if (numActiveNeighbors > 3) {
                        next.setCellState(i, j, true);
                    }
                }
            });
        });
        return next;
    }
}
