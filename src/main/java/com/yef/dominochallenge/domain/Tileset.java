package com.yef.dominochallenge.domain;

import java.util.Date;
import java.util.Set;

/**
 * Entity class for Tileset
 */
public class Tileset {

    private long id;
    private Date date;

    private Set<Tile> tileset;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Tile> getTileset() {
        return tileset;
    }

    public void setTileset(Set<Tile> tileset) {
        this.tileset = tileset;
    }



}
