/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styles.control;

import com.business.resources.fonts.Fonts;
import javafx.geometry.Insets;
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
public class FormFieldStyle {

    public static FormFieldStyle DEFAULT_FORM_FIELD_STYLE = new FormFieldStyle(
            "#333333",
            Background.EMPTY,
            new Border(new BorderStroke(Color.web("#333333"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))),
            Fonts.POPPINS.regular(18),
            Fonts.POPPINS.regular(12),
            Fonts.POPPINS.medium(14),
            Color.web("#808080"),
            Color.web("#BC3850")
    );
    public static FormFieldStyle DEFAULT_HOVER_FORM_FIELD_STYLE = new FormFieldStyle(
            "#111111",
            Background.EMPTY,
            new Border(new BorderStroke(Color.web("#111111"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))),
            Fonts.POPPINS.regular(18),
            Fonts.POPPINS.medium(12),
            Fonts.POPPINS.medium(14),
            Color.web("#111111"),
            Color.web("#BC3850")
    );
    public static FormFieldStyle DEFAULT_FOCUS_FORM_FIELD_STYLE = new FormFieldStyle(
            "#000000",
            Background.EMPTY,
            new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))),
            Fonts.POPPINS.regular(18),
            Fonts.POPPINS.medium(12),
            Fonts.POPPINS.medium(14),
            Color.web("#0C5891"),
            Color.web("#BC3850")
    );
    public static FormFieldStyle DEFAULT_ERROR_FORM_FIELD_STYLE = new FormFieldStyle(
            "#000000",
            Background.EMPTY,
            new Border(new BorderStroke(Color.web("#BC3850"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))),
            Fonts.POPPINS.regular(18),
            Fonts.POPPINS.medium(12),
            Fonts.POPPINS.medium(14),
            Color.web("#BC3850"),
            Color.web("#BC3850")
    );
    public static FormFieldStyle DEFAULT_WARNING_FORM_FIELD_STYLE = new FormFieldStyle(
            "#D35400",
            Background.EMPTY,
            new Border(new BorderStroke(Color.web("#D35400"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))),
            Fonts.POPPINS.regular(18),
            Fonts.POPPINS.medium(12),
            Fonts.POPPINS.medium(14),
            Color.web("#BC3850"),
            Color.web("#D35400")
    );

    private final String textColor;
    private final Background background;
    private final Border border;
    private final Font fieldFont;
    private final Font labelFont;
    private final Font errorFont;
    private final Color labelTextColor;
    private final Color errorTextColor;
    private Background labelBG;



    public FormFieldStyle(String textColor, Background background, Border border, Font fieldFont, Font labelFont, Font errorFont, Color labelTextColor, Color errorTextColor) {
        this.textColor = textColor;
        this.background = background;
        this.border = border;
        this.fieldFont = fieldFont;
        this.labelFont = labelFont;
        this.errorFont = errorFont;
        this.labelTextColor = labelTextColor;
        this.errorTextColor = errorTextColor;
        this.labelBG = new Background(new BackgroundFill(Color.web("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY));
    }



    public Background getLabelBG() {
        return labelBG;
    }



    public void setLabelBGColor(Color labelBGColor) {
        labelBG = new Background(new BackgroundFill(labelBGColor, CornerRadii.EMPTY, Insets.EMPTY));
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



    public Font getFieldFont() {
        return fieldFont;
    }



    public Font getLabelFont() {
        return labelFont;
    }



    public Font getErrorFont() {
        return errorFont;
    }



    public Color getLabelTextColor() {
        return labelTextColor;
    }



    public Color getErrorTextColor() {
        return errorTextColor;
    }

}
