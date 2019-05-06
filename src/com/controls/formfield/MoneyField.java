/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controls.formfield;

import com.business.resources.icons.Icons;
import java.text.DecimalFormat;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;

/**
 *
 * @author daan-
 */
public class MoneyField extends FormField {

    private static final DecimalFormat DF = new DecimalFormat("#0.00");
    private final DoubleProperty value = new SimpleDoubleProperty();
    private ImageView moneyIcon;


    public MoneyField() {
        super();
        initEuroSymbol();
        initErrorChecking();
        setValue(0);
    }

    
    @Override
    public void setInverted(boolean invert){
        super.setInverted(invert);
        if(invert == true){
            replaceEuroSymbol(Icons.getWhiteEuroIcon(24));
        }else{
            replaceEuroSymbol(Icons.getEuroIcon(24));
        }
        
    }


    public void setValue(double value) {
        if (value != this.value.get()) {
            this.value.set(value);
            int pos = textField.getCaretPosition();
            textField.setText(DF.format(value));
            textField.positionCaret(Math.min(pos, textField.getLength()));
            if (value < 0.0) {
                setWarningMessage("WARNING: negative price!");
            } else {
                setWarningMessage("");
            }
        }
    }


    public void replaceEuroSymbol(ImageView imgView){
        super.getChildren().remove(moneyIcon);
        this.moneyIcon = imgView;
        super.getChildren().add(moneyIcon);
        moneyIcon.translateXProperty().set(4);
    }
    

    private void initEuroSymbol() {
        moneyIcon = Icons.getEuroIcon(24);
        textField.setPadding(new Insets(16, 8, 16, 34));
        super.getChildren().add(moneyIcon);
        moneyIcon.translateXProperty().set(4);
    }
    



    private void initErrorChecking() {
        textField.textProperty().addListener((o, v1, v2) -> {
            if (v2 != null && !v2.isEmpty()) {
                if (!v2.matches("(\\d{0,7}([\\.,]\\d{0,3})?)")) {
                    super.setErrorMessage("Please enter a valid price");
                } else {

                    updateInput(v2);
                    super.setErrorMessage("");

                }
            } else {
                setValue(0.0);
                super.setErrorMessage("");

            }
        });
    }



    private void updateInput(String v) {
        if (v == null || v.isEmpty()) {
            setValue(0);
        } else {
            if (!v.matches("\\d{0,7}([\\.,]\\d{0,4})?")) {
                super.setErrorMessage("ERROR: only digits allowed");
            } else {
                super.setErrorMessage("");
                String digitString = v.replaceAll("\\D", "");
                String valueString = normalizeDigitString(digitString);
                setValue(Double.parseDouble(valueString));
            }
        }

    }



    private String normalizeDigitString(String digits) {
        if (digits.length() < 3) {
            digits = "0" + digits;
            return normalizeDigitString(digits);
        }
        String p1 = digits.substring(0, digits.length()-2);
        String p2 = digits.substring(digits.length()-2);
        return p1 + "." + p2;
    }

}
