package life.model;

public interface Map {

    boolean getNeighborState(int x, int y, Direction direction);

    void setCellState(int x, int y, boolean alive);
}
