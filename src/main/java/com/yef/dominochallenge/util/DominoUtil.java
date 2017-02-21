package com.yef.dominochallenge.util;

import com.yef.dominochallenge.domain.Tile;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Utility class for domino
 */
public class DominoUtil {

    private DominoUtil() {
    }

    public static Set<Tile> createBoneyard() {
        Set<Tile> ret = new LinkedHashSet<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < i + 1; j++) {
                ret.add(new Tile(i, j));
            }
        }
        return ret;
    }

    public static Set<Tile> createTileSet(Set<Tile> boneyard, int tileSetSize) {
        if (boneyard == null || tileSetSize > boneyard.size()) {
            throw new IllegalArgumentException();
        }
        Set<Tile> ret = new LinkedHashSet<>();
        for (int i = 0; i < tileSetSize; i++) {
            Object[] array = boneyard.toArray();
            int index;
            int bound = array.length;
            if (bound == 0) {
                index = 0;
            } else {
                index = new Random().nextInt(bound);
            }
            Tile domino = (Tile) array[index];
            ret.add(domino);
            boneyard.remove(domino);
        }
        return ret;
    }

}
