/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controls.formfield;

import com.business.resources.icons.Icons;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author daan-
 */
public class PercentageField extends FormField {

    private IntegerProperty percentage;
    private ImageView percentageIcon;



    public PercentageField() {
        super();
        percentage = new SimpleIntegerProperty();
        percentageIcon = Icons.getPercentageIcon(24);
        StackPane.setAlignment(percentageIcon, Pos.CENTER_RIGHT);
        super.getChildren().add(percentageIcon);
        percentageIcon.translateXProperty().set(-8);
        initPercentageFiels();

    }



    @Override
    public void setInverted(boolean invert) {
        super.setInverted(invert);
        if (invert == true) {
            setPercentageIcon(Icons.getWhitePercentageIcon(24));
        } else {
            setPercentageIcon(Icons.getPercentageIcon(24));
        }
    }



    public void setValue(int value) {
        if (value != percentage.get()) {
            percentage.set(value);
            textField.setText(String.valueOf(value));
        }
        if (value < 0) {
            super.setWarningMessage("WARNING: negative percentage!");
        }
        if (value > 100) {
            super.setWarningMessage("WARNING: percentage over 100%");
        }
        if (value >= 0 && value <= 100) {
            super.setWarningMessage("");
        }
    }



    private void setPercentageIcon(ImageView symbol) {
        super.getChildren().remove(percentageIcon);
        this.percentageIcon = symbol;
        StackPane.setAlignment(percentageIcon, Pos.CENTER_RIGHT);
        super.getChildren().add(percentageIcon);
        percentageIcon.translateXProperty().set(-8);

    }



    private void initPercentageFiels() {

        textField.textProperty().addListener((o, v1, v2) -> {
            if (v2 == null || v2.isEmpty()) {
                setValue(0);
            } else {
                if (v2.matches("[0-9]*")) {
                    setValue(Integer.parseInt(v2));
                    super.setErrorMessage("");
                } else {
                    super.setErrorMessage("Only digits are allowed");
                }
            }
        });

    }

}
