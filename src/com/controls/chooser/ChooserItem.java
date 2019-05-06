/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controls.chooser;

import java.io.File;
import javafx.scene.image.ImageView;

/**
 *
 * @author daan-
 */
public class ChooserItem {

    private final ImageView thumbnail;
    private final ImageView thumbnailWhite;
    private final String name;
    private final File file;



    public ChooserItem(ImageView thumbnail, ImageView thumbnailWhite, String name, File file) {
        this.thumbnail = thumbnail;
        this.thumbnailWhite = thumbnailWhite;
        this.name = name;
        this.file = file;
    }



    public ImageView getThumbnail() {
        return thumbnail;
    }



    public ImageView getThumbnailWhite() {
        return thumbnailWhite;
    }



    public String getName() {
        return name;
    }



    public File getFile() {
        return file;
    }

}
