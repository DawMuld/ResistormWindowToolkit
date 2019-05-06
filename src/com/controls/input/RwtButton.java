/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controls.input;

import com.styles.Invertable;
import com.styles.control.RwtButtonStyle;
import javafx.scene.control.Button;

/**
 *
 * @author daan-
 */
public class RwtButton extends Button implements Invertable {

    private RwtButtonStyle idleStyle;
    private RwtButtonStyle hoverStyle;



    public RwtButton() {
        super();
        idleStyle = RwtButtonStyle.DEFAULT_IDLE_STYLE;
        hoverStyle = RwtButtonStyle.DEFAULT_HOVER_STYLE;
        initStyle();

        super.hoverProperty().addListener((o, v1, v2) -> {

            if (v2 == true) {
                initRwtStyle(hoverStyle);
            } else {
                initRwtStyle(idleStyle);
            }

        });
    }



    @Override
    public void setInverted(boolean invert) {
        if (invert == false) {
            idleStyle = RwtButtonStyle.DEFAULT_IDLE_STYLE;
            hoverStyle = RwtButtonStyle.DEFAULT_HOVER_STYLE;
        } else {
            idleStyle = RwtButtonStyle.INVERTED_IDLE_STYLE;
            hoverStyle = RwtButtonStyle.INVERTED_HOVER_STYLE;
        }
        initStyle();
    }



    private void initStyle() {
        if (super.isHover()) {
            initRwtStyle(hoverStyle);
        } else {
            initRwtStyle(idleStyle);
        }

    }



    private void initRwtStyle(RwtButtonStyle style) {
        super.setFont(style.getFont());
        super.setTextFill(style.getTextColor());
        super.setBackground(style.getBackground());
        super.setBorder(style.getBorder());
        super.setEffect(style.getEffect());
    }

}
