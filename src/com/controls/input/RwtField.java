/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controls.input;

import com.styles.Invertable;
import com.styles.control.RwtFieldStyle;
import javafx.scene.control.TextField;

/**
 *
 * @author daan-
 */
public class RwtField extends TextField implements Invertable {

    public RwtField() {
        super();
        initRwtStyle(RwtFieldStyle.DEFAULT_STYLE);
    }



    @Override
    public void setInverted(boolean invert) {
        if (invert == true) {
            initRwtStyle(RwtFieldStyle.INVERTED_STYLE);
        } else {
            initRwtStyle(RwtFieldStyle.DEFAULT_STYLE);
        }
    }



    public void initRwtStyle(RwtFieldStyle style) {
        super.setStyle("-fx-text-fill: " + style.getTextColor() + ";");
        super.setFont(style.getFont());
        super.setBackground(style.getBackground());
        super.setBorder(style.getBorder());
    }

}
