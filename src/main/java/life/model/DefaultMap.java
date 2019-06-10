package life.model;

import static java.util.stream.IntStream.range;

public class DefaultMap implements Map {

    private final int dimension;
    private final boolean[][] internalState;
    private final char ALIVE_CHAR = 'O';
    private final char DEAD_CHAR = ' ';

    private DefaultMap(Builder builder) {
        this.dimension = builder.getDimensions();
        internalState = new boolean[dimension][dimension];
    }

    @Override
    public void setCellState(int x, int y, boolean alive) {
        assert x >= 0 && x < dimension && y > 0 &&  y < dimension;

        internalState[x][y] = alive;
    }

    @Override
    public boolean getNeighborState(int x, int y, Direction direction) {
        return false;
    }

    public static class Builder {

        int dimensions;

        public Builder(int dimensions) {
            this.dimensions = dimensions;
        }

        public Map build() {
            return new DefaultMap(this);
        }

        int getDimensions() {
            return dimensions;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        range(0,dimension).forEach(i -> {
            range(0,dimension).forEach(j -> {
                if(internalState[i][j]) {
                    sb.append(ALIVE_CHAR);
                } else {
                    sb.append(DEAD_CHAR);
                }
            });
            sb.append("\n");
        });
        return sb.toString();
    }
}
