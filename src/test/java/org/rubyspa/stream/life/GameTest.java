package org.rubyspa.stream.life;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GameTest {

    @Test
    public void testOscillator() {
        int width = 5;
        int height = 5;
        Map<Cell, Boolean> state = emptyState(width, height);
        state.put(new Cell(3,1), false);
        state.put(new Cell(3,2), true);
        state.put(new Cell(3,3), true);
        state.put(new Cell(3,4), true);
        state.put(new Cell(3,5), false);
        Game g1 = new Game(width, height, state);
        Game g2 = g1.evolve();
        Assert.assertEquals("     \n     \n ooo \n     \n     \n", g2.toString());
        Game g3 = g2.evolve();
        Assert.assertEquals("     \n  o  \n  o  \n  o  \n     \n", g3.toString());
        Game g4 = g3.evolve();
        Assert.assertEquals("     \n     \n ooo \n     \n     \n", g4.toString());
    }

    private Map<Cell, Boolean> emptyState(int width, int height) {
        Map<Cell, Boolean> state = new HashMap<>();
        for (int x = 1; x <= width; x++) {
            for (int y = 1; y <= height; y++) {
                state.put(new Cell(x,y), false);
            }
        }
        return state;
    }
}
