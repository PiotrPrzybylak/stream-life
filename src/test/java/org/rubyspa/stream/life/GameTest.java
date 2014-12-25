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
        Map<Cell, Boolean> state = MicroBench.emptyState(width, height);
        state.put(new Cell(3,2), true);
        state.put(new Cell(3,3), true);
        state.put(new Cell(3,4), true);

        Game g1 = new Game(width, height, state);
        Assert.assertEquals(
                "     \n" +
                "  o  \n" +
                "  o  \n" +
                "  o  \n" +
                "     \n",
                g1.toString());

        Game g2 = g1.evolve();
        Assert.assertEquals(
                "     \n" +
                "     \n" +
                " ooo \n" +
                "     \n" +
                "     \n",
                g2.toString());

        Game g3 = g2.evolve();
        Assert.assertEquals(
                "     \n" +
                "  o  \n" +
                "  o  \n" +
                "  o  \n" +
                "     \n",
                g3.toString());

        Game g4 = g3.evolve();
        Assert.assertEquals(
                "     \n" +
                "     \n" +
                " ooo \n" +
                "     \n" +
                "     \n",
                g4.toString());
    }

    @Test
    public void testGlider() {
        int width = 5;
        int height = 5;
        Map<Cell, Boolean> state = MicroBench.emptyState(width, height);
        state.put(new Cell(3,1), true);
        state.put(new Cell(1,2), true);
        state.put(new Cell(3,2), true);
        state.put(new Cell(2,3), true);
        state.put(new Cell(3,3), true);

        Game g1 = new Game(width, height, state);
        Assert.assertEquals(
                "  o  \n" +
                "o o  \n" +
                " oo  \n" +
                "     \n" +
                "     \n",
                g1.toString());

        Game g2 = g1.evolve();
        Assert.assertEquals(
                " o   \n" +
                "  oo \n" +
                " oo  \n" +
                "     \n" +
                "     \n",
                g2.toString());

        Game g3 = g2.evolve();
        Assert.assertEquals(
                "  o  \n" +
                "   o \n" +
                " ooo \n" +
                "     \n" +
                "     \n",
                g3.toString());

        Game g4 = g3.evolve();
        Assert.assertEquals(
                "     \n" +
                " o o \n" +
                "  oo \n" +
                "  o  \n" +
                "     \n",
                g4.toString());

        Game g5 = g4.evolve();
        Assert.assertEquals(
                "     \n" +
                "   o \n" +
                " o o \n" +
                "  oo \n" +
                "     \n",
                g5.toString());
    }
}
