package org.rubyspa.stream.life;

import java.util.HashMap;
import java.util.Map;

public class MicroBench {

    public static void main(String[] args) {
        int width = 16;
        int height = 16;
        Map<Cell, Boolean> state = emptyState(width, height);
        state.put(new Cell(3,2), true);
        state.put(new Cell(3,3), true);
        state.put(new Cell(3,4), true);

        state.put(new Cell(13,12), true);
        state.put(new Cell(13,13), true);
        state.put(new Cell(13,14), true);

        Game gn = new Game(width, height, state);
        long then = System.currentTimeMillis();
        for (int i = 1; i <= 30000; i++) {
            gn = gn.evolve();
            if (i % 2000 == 0) {
                System.out.println(i + " generations done, last 2000 took " + (System.currentTimeMillis() - then));
                then = System.currentTimeMillis();
            }
        }
    }

    protected static Map<Cell, Boolean> emptyState(int width, int height) {
        Map<Cell, Boolean> state = new HashMap<>();
        for (int x = 1; x <= width; x++) {
            for (int y = 1; y <= height; y++) {
                state.put(new Cell(x,y), false);
            }
        }
        return state;
    }
}
