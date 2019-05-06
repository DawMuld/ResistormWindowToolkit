/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controls.formfield;

import com.business.resources.buttons.Buttons;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 *
 * @author daan-
 */
public class SpinnerField extends FormField {

    private Button spinnerUp;
    private Button spinnerDown;
    private IntegerProperty value;



    public SpinnerField() {
        super();
        value = new SimpleIntegerProperty();
        initSpinnerButtons();
        setValue(1);
    }



    public void setValue(int value) {
        this.value.set(value);
    }



    public void increment() {
        int hold = value.get();
        value.set(hold + 1);
    }



    public void decrement() {
        int hold = value.get();
        value.set(hold - 1);
    }



    private void initSpinnerButtons() {
        spinnerUp = Buttons.createSpinnerUp();
        spinnerDown = Buttons.createSpinnerDown();
        Group wrapper = new Group(spinnerUp, spinnerDown);
        spinnerUp.translateYProperty().set(-8);
        spinnerDown.translateYProperty().set(8);
        wrapper.translateXProperty().set(-8);
        StackPane.setAlignment(wrapper, Pos.CENTER_RIGHT);
        super.getChildren().add(wrapper);
        spinnerUp.setOnAction((event) -> {
            increment();
        });
        spinnerDown.setOnAction((event) -> {
            decrement();
        });
        textField.textProperty().addListener((o, v1, v2) -> {
            if (v2 != null && !v2.isEmpty()) {
                if (!v2.matches("[0-9]*")) {
                    super.setErrorMessage("Input other than 0-9 is invalid");
                } else {
                    super.setErrorMessage("");
                    value.set(Integer.parseInt(v2));
                }
            } else {
                super.setErrorMessage("");
            }
        });
        value.addListener((o, v1, v2) -> {
            if ((int) v2 <= 1) {
                spinnerDown.setDisable(true);
            } else {
                spinnerDown.setDisable(false);
            }
            if (v1 != v2) {
                textField.setText(String.valueOf(v2));
            }
        });
    }

}
