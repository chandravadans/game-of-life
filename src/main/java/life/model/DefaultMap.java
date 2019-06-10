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
        assert x >= 0 && x < dimension && y >= 0 &&  y < dimension;

        internalState[x][y] = alive;
    }

    /*@Override
    public Map copy() {
        Map cloned = new Builder(this.getDimension()).build();
        range(0, cloned.getDimension()).forEach(i -> {
            range(0, cloned.getDimension()).forEach(j -> {
                cloned.setCellState(i, j, this.getCellState(i, j));
            });
        });
        return cloned;
    }*/

    @Override
    public boolean getCellState(int x, int y) {
        assert x >= 0 && x < dimension && y >= 0 && y < dimension;

        return internalState[x][y];
    }

    @Override
    public int getDimension() {
        return this.dimension;
    }

    @Override
    public boolean getNeighborState(int x, int y, Direction direction) {
        int dx = direction.getDx();
        int dy = direction.getDy();

        int targetX = (x + dx) % dimension;
        int targetY = (y + dy) % dimension;

        if (targetX < 0) {
            targetX = dimension + targetX;
        }

        if (targetY < 0) {
            targetY = dimension + targetY;
        }
        return internalState[targetX][targetY];
    }

    public static class Builder {

        int dimensions;

        public Builder(int dimensions) {
            this.dimensions = dimensions;
        }

        public DefaultMap build() {
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
                sb.append(internalState[i][j] ? ALIVE_CHAR : DEAD_CHAR);
                sb.append("|");
            });
            sb.append("\n");
        });
        return sb.toString();
    }
}
