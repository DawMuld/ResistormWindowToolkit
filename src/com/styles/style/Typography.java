/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styles.style;

import com.business.resources.fonts.Fonts;
import javafx.scene.text.Font;

/**
 *
 * @author daan-
 */
public interface Typography {
    
    public default Font h1(){return Fonts.ROBOTO.thin(96);}
    public default Font h2(){return Fonts.ROBOTO.thin(60);}
    public default Font h3(){return Fonts.ROBOTO.regular(48);}
    public default Font h4(){return Fonts.ROBOTO.regular(34);}
    public default Font h5(){return Fonts.ROBOTO.regular(24);}
    public default Font h6(){return Fonts.ROBOTO.medium(20);}
    
    public default Font subtitle(){return Fonts.ROBOTO.regular(16);}
    public default Font body(){return Fonts.ROBOTO.regular(16);}
    public default Font button(){return Fonts.ROBOTO.regular(16);}
}
