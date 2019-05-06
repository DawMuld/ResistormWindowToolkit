/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controls.label;

import com.business.resources.fonts.Fonts;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

/**
 *
 * @author daan-
 */
public class TitleLabel extends Label {
    
    public TitleLabel(String text){
        super(text);
        super.setFont(Fonts.POPPINS.thin(64));
        super.setPadding(new Insets(16, 12, 16, 12));
        
    }
        
    
}
