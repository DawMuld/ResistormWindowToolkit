/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styles.style;

import javafx.scene.paint.Color;

/**
 *
 * @author daan-
 */
public interface ColorStyle {

    public default Color primary() {
        return Color.web("#6200EE");
    }



    public default Color primaryVar() {
        return Color.web("#3700B3");
    }



    public default Color secondary() {
        return Color.web("#03DAC6");
    }



    public default Color secondaryVar() {
        return Color.web("#018786");
    }



    public default Color background() {
        return Color.web("#FFFFFF");
    }



    public default Color surface() {
        return Color.web("#FFFFFF");
    }



    public default Color error() {
        return Color.web("#C51162");
    }



    public default Color onPrimary() {
        return Color.web("#FFFFFF");
    }



    public default Color onSecondary() {
        return Color.web("#000000");
    }



    public default Color onBackground() {
        return Color.web("#000000");
    }



    public default Color onSurface() {
        return Color.web("#000000");
    }



    public default Color onError() {
        return Color.web("#FFFFFF");
    }

}
