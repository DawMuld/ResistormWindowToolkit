/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business.resources.buttons;

import java.io.File;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

/**
 *
 * @author daan-
 */
public class Buttons {

    public static Button createSpinnerUp() {
        Button button = new Button();
        button.setPadding(Insets.EMPTY);
        button.setBorder(Border.EMPTY);
        button.setBackground(Background.EMPTY);
        ImageView idle = load("spinner/spinner_up_idle.png");
        ImageView hover = load("spinner/spinner_up_hover.png");
        button.setGraphic(idle);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(hover);
            } else {
                button.setGraphic(idle);
            }
        });
        return button;
    }



    public static Button createWhiteSpinnerUp() {
        Button button = new Button();
        button.setPadding(Insets.EMPTY);
        button.setBorder(Border.EMPTY);
        button.setBackground(Background.EMPTY);
        ImageView idle = load("spinner/spinner_up_idle_white.png");
        ImageView hover = load("spinner/spinner_up_hover_white.png");
        button.setGraphic(idle);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(hover);
            } else {
                button.setGraphic(idle);
            }
        });
        return button;
    }



    public static Button createSpinnerDown() {
        Button button = new Button();
        button.setPadding(Insets.EMPTY);
        button.setBorder(Border.EMPTY);
        button.setBackground(Background.EMPTY);
        ImageView idle = load("spinner/spinner_down_idle.png");
        ImageView hover = load("spinner/spinner_down_hover.png");
        button.setGraphic(idle);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(hover);
            } else {
                button.setGraphic(idle);
            }
        });
        return button;
    }



    public static Button createWhiteSpinnerDown() {
        Button button = new Button();
        button.setPadding(Insets.EMPTY);
        button.setBorder(Border.EMPTY);
        button.setBackground(Background.EMPTY);
        ImageView idle = load("spinner/spinner_down_idle_white.png");
        ImageView hover = load("spinner/spinner_down_hover_white.png");
        button.setGraphic(idle);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(hover);
            } else {
                button.setGraphic(idle);
            }
        });
        return button;
    }



    private static ImageView load(String name) {
        try {
            File file = new File(Buttons.class.getResource(name).getFile());
            Image image = new Image(new FileInputStream(file));
            ImageView imageView = new ImageView(image);
            return imageView;
        } catch (Exception e) {
        }
        return null;
    }
}
