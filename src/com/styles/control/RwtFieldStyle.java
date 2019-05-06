/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styles.control;

import com.business.resources.fonts.Fonts;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author daan-
 */
public class RwtFieldStyle {

    private final String textColor;
    private final Background background;
    private final Border border;
    private final Font font;



    public RwtFieldStyle(String textColor, Background background, Border border, Font font) {
        this.textColor = textColor;
        this.background = background;
        this.border = border;
        this.font = font;
    }



    public String getTextColor() {
        return textColor;
    }



    public Background getBackground() {
        return background;
    }



    public Border getBorder() {
        return border;
    }



    public Font getFont() {
        return font;
    }

    public static final RwtFieldStyle DEFAULT_STYLE = new RwtFieldStyle("#000000", Background.EMPTY, new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))), Fonts.POPPINS.regular(16));
    public static final RwtFieldStyle INVERTED_STYLE = new RwtFieldStyle("#FFFFFF", Background.EMPTY, new Border(new BorderStroke(Color.web("#FFFFFF"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))), Fonts.POPPINS.regular(16));

}
