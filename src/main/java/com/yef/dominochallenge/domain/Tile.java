package com.yef.dominochallenge.domain;

import java.io.Serializable;

/**
 * Entity class for domino tile
 */
public class Tile implements Serializable {

    private Long id;
    private byte endOne;
    private byte endTwo;

    public Tile() {
    }

    public Tile(byte endOne, byte endTwo) {
        this.endOne = endOne;
        this.endTwo = endTwo;
    }

    public Tile(int endOne, int endTwo) {
        this.endOne = (byte)endOne;
        this.endTwo = (byte)endTwo;
    }

    public byte getEndOne() {
        return endOne;
    }

    public void setEndOne(byte endOne) {
        this.endOne = endOne;
    }

    public byte getEndTwo() {
        return endTwo;
    }

    public void setEndTwo(byte endTwo) {
        this.endTwo = endTwo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile domino = (Tile) o;

        if (endOne != domino.endOne) return false;
        return endTwo == domino.endTwo;

    }

    @Override
    public int hashCode() {
        int result = (int) endOne;
        result = 31 * result + (int) endTwo;
        return result;
    }
}
