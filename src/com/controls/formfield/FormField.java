/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controls.formfield;

import com.business.resources.fonts.Fonts;
import com.styles.InvertablePane;
import com.styles.control.FormFieldStyle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 *
 * @author daan-
 */
public class FormField extends StackPane implements InvertablePane {

    protected TextField textField;
    protected Label label;
    protected Label errorLabel;

    private FormFieldStyle idleStyle;
    private FormFieldStyle hoverStyle;
    private FormFieldStyle focusStyle;
    private FormFieldStyle errorStyle;
    private FormFieldStyle warningStyle;

    private final StringProperty errorMessage;
    private final StringProperty warningMessage;



    public FormField() {
        super();
        textField = new TextField();
        label = new Label();
        errorLabel = new Label();
        errorMessage = new SimpleStringProperty();
        warningMessage = new SimpleStringProperty();
        idleStyle = FormFieldStyle.DEFAULT_FORM_FIELD_STYLE;
        hoverStyle = FormFieldStyle.DEFAULT_HOVER_FORM_FIELD_STYLE;
        focusStyle = FormFieldStyle.DEFAULT_FOCUS_FORM_FIELD_STYLE;
        errorStyle = FormFieldStyle.DEFAULT_ERROR_FORM_FIELD_STYLE;
        warningStyle = FormFieldStyle.DEFAULT_WARNING_FORM_FIELD_STYLE;
        initFormField();
    }



    @Override
    public void updateBackgroundColor(Color color, boolean invert) {
        setInverted(invert);
        idleStyle.setLabelBGColor(color);
        hoverStyle.setLabelBGColor(color);
        focusStyle.setLabelBGColor(color);
        errorStyle.setLabelBGColor(color);
        warningStyle.setLabelBGColor(color);
        updateStyleState();
    }



    @Override
    public void setInverted(boolean invert) {
        if (invert == false) {
            idleStyle = FormFieldStyle.DEFAULT_FORM_FIELD_STYLE;
            hoverStyle = FormFieldStyle.DEFAULT_HOVER_FORM_FIELD_STYLE;
            focusStyle = FormFieldStyle.DEFAULT_FOCUS_FORM_FIELD_STYLE;
            errorStyle = FormFieldStyle.DEFAULT_ERROR_FORM_FIELD_STYLE;
            warningStyle = FormFieldStyle.DEFAULT_WARNING_FORM_FIELD_STYLE;
        } else {
            idleStyle = INVERTED_IDLE_STYLE;
            hoverStyle = INVERTED_HOVER_STYLE;
            focusStyle = INVERTED_FOCUS_STYLE;
            errorStyle = INVERTED_ERROR_STYLE;
            warningStyle = INVERTED_WARNING_STYLE;
        }
    }



    public void updateStyleState() {
        if (!errorMessage.getValueSafe().isEmpty()) {
            initErrorStyle();
        } else if (!warningMessage.getValueSafe().isEmpty()) {
            initWarningStyle();
        } else if (textField.isFocused()) {
            initFocutStyle();
        } else if (textField.isHover()) {
            initHoverStyle();
        } else {
            initIdleStyle();
        }
    }



    public FormFieldStyle getIdleStyle() {
        return idleStyle;
    }



    public void setIdleStyle(FormFieldStyle idleStyle) {
        this.idleStyle = idleStyle;
    }



    public FormFieldStyle getHoverStyle() {
        return hoverStyle;
    }



    public void setHoverStyle(FormFieldStyle hoverStyle) {
        this.hoverStyle = hoverStyle;
    }



    public FormFieldStyle getFocusStyle() {
        return focusStyle;
    }



    public void setFocusStyle(FormFieldStyle focusStyle) {
        this.focusStyle = focusStyle;
    }



    public FormFieldStyle getErrorStyle() {
        return errorStyle;
    }



    public void setErrorStyle(FormFieldStyle errorStyle) {
        this.errorStyle = errorStyle;
    }



    public FormFieldStyle getWarningStyle() {
        return warningStyle;
    }



    public void setWarningStyle(FormFieldStyle warningStyle) {
        this.warningStyle = warningStyle;
    }



    public void adjustWidth(double value) {
        textField.setPrefColumnCount((int) value);
    }



    public void setLabelText(String text) {
        label.setText(text);
    }



    public String getLabelText() {
        return label.getText();
    }



    public void setPromptText(String text) {
        textField.setPromptText(text);
    }



    public StringProperty getTextProperty() {
        return textField.textProperty();
    }



    public void setErrorMessage(String msg) {
        errorMessage.set(msg);
    }



    public void setWarningMessage(String msg) {
        warningMessage.set(msg);
    }



    public void initIdleStyle() {
        initStyle(idleStyle);
    }



    public void initHoverStyle() {
        initStyle(hoverStyle);
    }



    public void initFocutStyle() {
        initStyle(focusStyle);
    }



    public void initErrorStyle() {
        initStyle(errorStyle);

    }



    public void initWarningStyle() {
        initStyle(warningStyle);
    }



    private void initFormField() {
        textField.setPrefColumnCount(18);
        textField.setPadding(new Insets(16, 8, 16, 14));
        textField.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))));
        super.setAlignment(Pos.CENTER_LEFT);
        textField.setBackground(Background.EMPTY);
        label.setBackground(new Background(new BackgroundFill(Color.web("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)));
        label.setText("Lorem Ipsum");
        label.setFont(Fonts.ROBOTO.regular(12));
        label.setPadding(new Insets(2, 8, 2, 8));
        errorLabel.setTextFill(Color.web("#BC3850"));
        errorLabel.setBackground(Background.EMPTY);
        errorLabel.setFont(Fonts.ROBOTO.regular(16));

        super.getChildren().addAll(textField, label, errorLabel);
        super.setPadding(new Insets(8, 8, 32, 8));
        label.translateYProperty().set(-28);
        label.translateXProperty().set(12);
        errorLabel.translateYProperty().set(38);
        errorLabel.translateXProperty().set(8);

        errorMessage.addListener((o, v1, v2) -> {
            if (v2 == null || v2.isEmpty()) {
                errorLabel.setText("");
                if (textField.isFocused()) {
                    initFocutStyle();
                } else {
                    initIdleStyle();
                }
            } else {
                errorLabel.setText(v2);
                initErrorStyle();
            }
        });
        warningMessage.addListener((o, v1, v2) -> {
            if (errorMessage.get() == null || errorMessage.get().isEmpty()) {
                if (v2 == null || v2.isEmpty()) {
                    errorLabel.setText("");
                    if (textField.isFocused()) {
                        initFocutStyle();
                    } else {
                        initIdleStyle();
                    }
                } else {
                    errorLabel.setText(v2);
                    initWarningStyle();
                }
            }
        });
        initStyle(idleStyle);
        textField.hoverProperty().addListener((o, v1, v2) -> {
            if (!textField.isFocused()) {
                if (v2 == true) {
                    initHoverStyle();
                } else {
                    initIdleStyle();
                }
            }
        });
        textField.focusedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                initFocutStyle();
            } else {
                initIdleStyle();
            }
        });
    }



    private void initStyle(FormFieldStyle style) {
        textField.setStyle("-fx-text-fill: " + style.getTextColor());
        textField.setBackground(style.getBackground());
        textField.setBorder(style.getBorder());
        textField.setFont(style.getFieldFont());
        label.setTextFill(style.getLabelTextColor());
        label.setFont(style.getLabelFont());
        errorLabel.setTextFill(style.getErrorTextColor());
        errorLabel.setFont(style.getErrorFont());
        label.setBackground(style.getLabelBG());
    }

    private static final FormFieldStyle INVERTED_IDLE_STYLE = new FormFieldStyle(
            "#DEDEDE",
            Background.EMPTY,
            new Border(new BorderStroke(Color.web("#DEDEDE"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))),
            Fonts.POPPINS.regular(18),
            Fonts.POPPINS.regular(12),
            Fonts.POPPINS.medium(14),
            Color.web("#DEDEDE"),
            Color.web("#E94D36")
    );
    private static final FormFieldStyle INVERTED_HOVER_STYLE = new FormFieldStyle(
            "#ECF0F1",
            Background.EMPTY,
            new Border(new BorderStroke(Color.web("#ECF0F1"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))),
            Fonts.POPPINS.regular(18),
            Fonts.POPPINS.regular(12),
            Fonts.POPPINS.medium(14),
            Color.web("#ECF0F1"),
            Color.web("#E94D36")
    );
    private static final FormFieldStyle INVERTED_FOCUS_STYLE = new FormFieldStyle(
            "#FFFFFF",
            Background.EMPTY,
            new Border(new BorderStroke(Color.web("#FFFFFF"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))),
            Fonts.POPPINS.regular(18),
            Fonts.POPPINS.regular(12),
            Fonts.POPPINS.medium(14),
            Color.web("#FFFFFF"),
            Color.web("#E94D36")
    );
    private static final FormFieldStyle INVERTED_ERROR_STYLE = new FormFieldStyle(
            "#E94D36",
            Background.EMPTY,
            new Border(new BorderStroke(Color.web("#E94D36"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))),
            Fonts.POPPINS.regular(18),
            Fonts.POPPINS.regular(12),
            Fonts.POPPINS.medium(14),
            Color.web("#E94D36"),
            Color.web("#E94D36")
    );
    private static final FormFieldStyle INVERTED_WARNING_STYLE = new FormFieldStyle(
            "#FFFFFF",
            Background.EMPTY,
            new Border(new BorderStroke(Color.web("#F39C11"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))),
            Fonts.POPPINS.regular(18),
            Fonts.POPPINS.regular(12),
            Fonts.POPPINS.medium(14),
            Color.web("#FFFFFF"),
            Color.web("#F39C11")
    );

}
