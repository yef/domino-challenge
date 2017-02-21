package com.yef.dominochallenge.util;

import com.yef.dominochallenge.domain.Tile;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Test for domino util
 */
public class DominoUtilTest {

    private static final int BONEYARD = 28;

    @Test
    public void createBoneyard() throws Exception {

        Set<Tile> testSet = DominoUtil.createBoneyard();
        assertEquals(BONEYARD, testSet.size());
        assertEquals(new Tile(1,1), testSet.toArray()[2]);
        assertEquals(new Tile(3,2), testSet.toArray()[8]);
        assertEquals(new Tile(5,4), testSet.toArray()[19]);
        assertEquals(new Tile(6,6), testSet.toArray()[27]);
    }

    @Test
    public void createTileSet() throws Exception {
        Set<Tile> boneyard = DominoUtil.createBoneyard();
        assertEquals(BONEYARD, boneyard.size());
        Set<Tile> testSet = DominoUtil.createTileSet(boneyard, BONEYARD);
        assertEquals(0, boneyard.size());
        assertEquals(BONEYARD, testSet.size());
        boneyard = DominoUtil.createBoneyard();
        testSet = DominoUtil.createTileSet(boneyard, BONEYARD - 7);
        assertEquals(7, boneyard.size());
        assertEquals(BONEYARD - 7, testSet.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTileSetWithNullBoneyardShouldFail() throws Exception {
        DominoUtil.createTileSet(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTileSetWithTooBigSizeShouldFail() throws Exception {
        Set<Tile> boneyard = DominoUtil.createBoneyard();
        DominoUtil.createTileSet(boneyard, 100);
    }

}