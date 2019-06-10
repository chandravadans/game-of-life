package life.model;

public interface Map {

    int getDimension();

    boolean getNeighborState(int x, int y, Direction direction);

    void setCellState(int x, int y, boolean alive);

    boolean getCellState(int x, int y);

    //Map copy();
}
