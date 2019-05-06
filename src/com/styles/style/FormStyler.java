/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styles.style;

import java.awt.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author daan-
 */
public interface FormStyler {
    public void styleTitleLabel(Label label);
    public void styleHeaderLabel(Label label);
    public void styleLabel(Label label);
    public void styleTextField(TextField textField);
    public void syleComboBox(ComboBox comboBox);
    public void styleRadioButton(RadioButton radioButton);
    public void styleButton(Button button);
    public void styleToggleButton(ToggleButton toggleButton);
    
    
}
