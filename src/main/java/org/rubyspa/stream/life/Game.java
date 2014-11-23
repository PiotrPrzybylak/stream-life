package org.rubyspa.stream.life;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.toMap;

public class Game {

    private final int width;
    private final int height;
    private final Map<Cell, Boolean> state;

    public Game(int width, int height, Map<Cell, Boolean> state) {
        this.width = width;
        this.height = height;
        this.state = state;
    }

    public Game evolve() {
        Map<Cell, Boolean> nextState = state.entrySet()
                .parallelStream()
                .map(this::applyRules)
                .collect(toMap(Entry::getKey, Entry::getValue));
        return new Game(this.width, this.height, nextState);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                if (state.get(new Cell(x, y))) {
                    sb.append('o');
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private Entry<Cell, Boolean> applyRules(Entry<Cell, Boolean> e) {
        int neighbors = countNeighbors(e.getKey());
        switch (neighbors) {
            case 3 : return new AbstractMap.SimpleEntry<>(e.getKey(), Boolean.TRUE);
            case 2 : return new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue());
            default : return new AbstractMap.SimpleEntry<>(e.getKey(), Boolean.FALSE);
        }
    }

    private int countNeighbors(Cell cell) {
        long neighbors = state.entrySet()
                .parallelStream()
                .filter(e -> islivingNeighbor(cell, e))
                .count();
        return (int) neighbors;
    }

    private boolean islivingNeighbor(Cell cell, Entry<Cell, Boolean> mapEntry) {
        return isNeighbor(cell, mapEntry)
                && mapEntry.getValue();
    }

    private boolean isNeighbor(Cell cell, Entry<Cell, Boolean> mapEntry) {
        return mapEntry.getKey() != cell
                && isXNeighbor(cell, mapEntry)
                && isYNeighbor(cell, mapEntry);
    }

    private boolean isXNeighbor(Cell cell, Entry<Cell, Boolean> mapEntry) {
        if (cell.x == 1) {
            return mapEntry.getKey().x == width
                    || mapEntry.getKey().x == 1
                    || mapEntry.getKey().x == 2;
        }
        else if (cell.x == width) {
            return mapEntry.getKey().x == width - 1
                    || mapEntry.getKey().x == width
                    || mapEntry.getKey().x == 1;
        }
        else return mapEntry.getKey().x >= cell.x - 1
                && mapEntry.getKey().x <= cell.x + 1;
    }

    private boolean isYNeighbor(Cell cell, Entry<Cell, Boolean> mapEntry) {
        if (cell.y == 1) {
            return mapEntry.getKey().y == height
                    || mapEntry.getKey().y == 1
                    || mapEntry.getKey().y == 2;
        }
        else if (cell.y == height) {
            return mapEntry.getKey().y == height - 1
                    || mapEntry.getKey().y == height
                    || mapEntry.getKey().y == 1;
        }
        else return mapEntry.getKey().y >= cell.y - 1
                && mapEntry.getKey().y <= cell.y + 1;
    }
}
