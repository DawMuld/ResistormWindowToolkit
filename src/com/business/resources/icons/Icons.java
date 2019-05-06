/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business.resources.icons;

import java.io.File;
import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author daan-
 */
public class Icons {

    public static ImageView getEuroIcon(double size) {
        return createIcon(size, "euro.png");
    }



    public static ImageView getWhiteEuroIcon(double size) {
        return createIcon(size, "euro_white.png");
    }



    public static ImageView getPercentageIcon(double size) {
        return createIcon(size, "percentage.png");
    }



    public static ImageView getWhitePercentageIcon(double size) {
        return createIcon(size, "percentage_white.png");
    }



    public static ImageView getFileIcon(double size) {
        return createIcon(size, "file.png");
    }



    public static ImageView getWhiteFileIcon(double size) {
        return createIcon(size, "file_white.png");
    }



    public static ImageView getFolderIcon(double size) {
        return createIcon(size, "folder.png");
    }



    public static ImageView getWhiteFolderIcon(double size) {
        return createIcon(size, "folder_white.png");
    }



    public static ImageView createIcon(double size, String name) {
        File file = new File(Icons.class.getResource(name).getFile());
        try {
            Image image = new Image(new FileInputStream(file));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(size);
            imageView.setFitHeight(size);
            return imageView;
        } catch (Exception e) {
        }
        return null;
    }

}
