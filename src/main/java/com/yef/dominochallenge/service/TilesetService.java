package com.yef.dominochallenge.service;

import com.yef.dominochallenge.dao.TilesetDao;
import com.yef.dominochallenge.domain.Tile;
import com.yef.dominochallenge.domain.Tileset;

import java.util.Set;

/**
 * Service class for Tile Set
 */
public class TilesetService {

    private TilesetDao tilesetDao = new TilesetDao();

    public Long save(Set<Tile> tileset) {
        return tilesetDao.create();
    }

    public Tileset read() {
        return tilesetDao.read();
    }

    public void delete(long tilesetId) {
        tilesetDao.delete();
    }

}
