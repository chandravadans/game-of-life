package life.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DefaultMapTest {

    private DefaultMap underTest;

    @Before
    public void setUp() throws Exception {
        /**
         * OOOO
         * O O
         *    O
         * OOO
         */
        underTest = new DefaultMap.Builder(4).build();
        underTest.setCellState(0,0,true);
        underTest.setCellState(0,1, true);
        underTest.setCellState(0,2, true);
        underTest.setCellState(0,3, true);

        underTest.setCellState(1,0, true);
        underTest.setCellState(1,1, false);
        underTest.setCellState(1,2, true);
        underTest.setCellState(1,3,false);

        underTest.setCellState(2,0, false);
        underTest.setCellState(2,1, false);
        underTest.setCellState(2,2, false);
        underTest.setCellState(2,3,true);

        underTest.setCellState(3,0, true);
        underTest.setCellState(3,1, true);
        underTest.setCellState(3,2, true);
        underTest.setCellState(3,3,false);
    }

    @Test
    public void getNeighborStateCenter() {
        assertThat(underTest.getNeighborState(0,0, Direction.NORTH_WEST), is(false));
        assertThat(underTest.getNeighborState(0,0, Direction.NORTH_EAST), is(true));
        assertThat(underTest.getNeighborState(0,0, Direction.SOUTH_WEST), is(false));

    }
}