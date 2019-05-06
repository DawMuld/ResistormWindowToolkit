/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controls.chooser;

import com.business.resources.icons.Icons;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

/**
 *
 * @author daan-
 */
public class ChooserItemFactory {

    public static ChooserItem createChooserItem(File file) {
        ImageView imageView = null;
        ImageView imageViewWhite = null;
        if (file.isDirectory()) {
            imageView = Icons.getFolderIcon(24);
            imageViewWhite = Icons.getWhiteFolderIcon(24);
        } else {
            imageView = Icons.getFileIcon(24);
            imageViewWhite = Icons.getWhiteFileIcon(24);
        }
        String name = file.getName();
        return new ChooserItem(imageView, imageViewWhite, name, file);
    }



    public static ObservableList<ChooserItem> createFolder(File file) {
        ObservableList<ChooserItem> list = FXCollections.observableArrayList();
        File[] files = file.listFiles();
        for (File item : files) {
            list.add(createChooserItem(item));
        }
        return list;
    }

}
