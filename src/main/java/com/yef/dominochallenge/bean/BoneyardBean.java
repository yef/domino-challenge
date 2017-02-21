package com.yef.dominochallenge.bean;

import com.yef.dominochallenge.Constants;
import com.yef.dominochallenge.domain.Tile;
import com.yef.dominochallenge.service.TilesetService;
import com.yef.dominochallenge.util.DominoUtil;

import java.util.Random;
import java.util.Set;

/**
 * Web bean for game
 */
public class BoneyardBean {

    private static final String ACTION_CREATE_SET = "create-set";
    private static final String ACTION_SAVE = "save";
    private static final int MIN_TILES_SIZE = 3;
    private static final int MAX_TILES_SIZE = 28;

    private TilesetService tilesetService = new TilesetService();

    private Set<Tile> boneyard = DominoUtil.createBoneyard();
    private Set<Tile> tileSet;
    private String message;
    private String action;
    private Integer numberOfTiles;
    private String errorMessage;
    private String redirectUrl;


    public boolean isDone() {
        redirectUrl = null;
        errorMessage = "";
        message = "";
        try {
            if (ACTION_CREATE_SET.equals(action)) {
                createTileSet();
            } else if (ACTION_SAVE.equals(action)) {
                if (tileSet != null) {
                    Long tilesetId = saveTileSet();
                    redirectUrl = Constants.CHAINMAKER_PAGE + "?tilesetId=" + tilesetId;
                } else {
                    errorMessage = "Tile set is empty!";
                }
            }
        } catch (Exception ex) {
            errorMessage = "Error. Please check your input";
            return false;
        }
        return true;
    }

    private Long saveTileSet() {
        return tilesetService.save(tileSet);
    }

    private void createTileSet() {
        boneyard = DominoUtil.createBoneyard();
        int tilesSize;
        if (numberOfTiles == null) {
            tilesSize = MIN_TILES_SIZE + new Random().nextInt(MAX_TILES_SIZE - MIN_TILES_SIZE);
        } else {
            tilesSize = numberOfTiles;
        }
        tileSet = DominoUtil.createTileSet(boneyard, tilesSize);
        message = "A new Tile Set has been created!";
    }

    public Set<Tile> getBoneyard() {
        return boneyard;
    }

    public void setBoneyard(Set<Tile> boneyard) {
        this.boneyard = boneyard;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getNumberOfTiles() {
        return numberOfTiles;
    }

    public void setNumberOfTiles(Integer numberOfTiles) {
        this.numberOfTiles = numberOfTiles;
    }

    public Set<Tile> getTileSet() {
        return tileSet;
    }

    public void setTileSet(Set<Tile> tileSet) {
        this.tileSet = tileSet;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }
}
