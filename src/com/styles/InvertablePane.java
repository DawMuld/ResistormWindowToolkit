/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styles;

import javafx.scene.paint.Color;

/**
 *
 * @author daan-
 */
public interface InvertablePane extends Invertable {

    public void updateBackgroundColor(Color color, boolean invert);



    public default void setInverted(boolean invert) {

    }

}
