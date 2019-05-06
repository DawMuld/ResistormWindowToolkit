/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styles.control;

import com.business.resources.fonts.Fonts;
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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
public class RwtButtonStyle {
    private final Color textColor;
    private final Font font;
    private final Border border;
    private final Background background;
    private final Effect effect;
    
    public RwtButtonStyle(Color textColor, Font font, Border border, Background background, Effect effect){
        this.textColor = textColor;
        this.font = font;
        this.border = border;
        this.background = background;
        this.effect = effect;
    }



    public Color getTextColor() {
        return textColor;
    }



    public Font getFont() {
        return font;
    }



    public Border getBorder() {
        return border;
    }



    public Background getBackground() {
        return background;
    }



    public Effect getEffect() {
        return effect;
    }
    
    public static final RwtButtonStyle DEFAULT_IDLE_STYLE = new RwtButtonStyle(Color.web("#000000"), Fonts.POPPINS.regular(16), new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))), new Background(new BackgroundFill(Color.web("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)), null);
    public static final RwtButtonStyle DEFAULT_HOVER_STYLE = new RwtButtonStyle(Color.web("#000000"), Fonts.POPPINS.bold(16), new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))), new Background(new BackgroundFill(Color.web("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)), new DropShadow(4, 1, 1, Color.web("#000000")));
    public static final RwtButtonStyle DEFAULT_FOCUS_STYLE = new RwtButtonStyle(Color.web("#000000"), Fonts.POPPINS.regular(16), new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.DASHED, CornerRadii.EMPTY, new BorderWidths(1))), new Background(new BackgroundFill(Color.web("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)), null);
    
    public static final RwtButtonStyle INVERTED_IDLE_STYLE = new RwtButtonStyle(Color.web("#FFFFFF"), Fonts.POPPINS.regular(16), new Border(new BorderStroke(Color.web("#FFFFFF"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))),new Background(new BackgroundFill(Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)), null);
    public static final RwtButtonStyle INVERTED_HOVER_STYLE = new RwtButtonStyle(Color.web("#FFFFFF"), Fonts.POPPINS.bold(16), new Border(new BorderStroke(Color.web("#FFFFFF"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))), new Background(new BackgroundFill(Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)), new DropShadow(4, 1, 1, Color.web("#FFFFFF")));
    public static final RwtButtonStyle INVERTED_FOCUS_STYLE = new RwtButtonStyle(Color.web("#FFFFFF"), Fonts.POPPINS.regular(16), new Border(new BorderStroke(Color.web("#FFFFFF"), BorderStrokeStyle.DASHED, CornerRadii.EMPTY, new BorderWidths(1))), new Background(new BackgroundFill(Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)), null);
}
