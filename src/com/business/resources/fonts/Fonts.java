/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business.resources.fonts;

import java.io.File;
import java.io.FileInputStream;
import javafx.scene.text.Font;

/**
 *
 * @author daan-
 */
public class Fonts {

    public static final Fonts ROBOTO = new Fonts(
            new File(Fonts.class.getResource("roboto/thin.ttf").getFile()),
            new File(Fonts.class.getResource("roboto/regular.ttf").getFile()),
            new File(Fonts.class.getResource("roboto/medium.ttf").getFile()),
            new File(Fonts.class.getResource("roboto/bold.ttf").getFile())
    );

    public static final Fonts NUNITO = new Fonts(
            new File(Fonts.class.getResource("nunito/thin.ttf").getFile()),
            new File(Fonts.class.getResource("nunito/regular.ttf").getFile()),
            new File(Fonts.class.getResource("nunito/medium.ttf").getFile()),
            new File(Fonts.class.getResource("nunito/bold.ttf").getFile())
    );

    public static final Fonts POPPINS = new Fonts(
            new File(Fonts.class.getResource("poppins/thin.ttf").getFile()),
            new File(Fonts.class.getResource("poppins/regular.ttf").getFile()),
            new File(Fonts.class.getResource("poppins/medium.ttf").getFile()),
            new File(Fonts.class.getResource("poppins/bold.ttf").getFile())
    );

    private final File thin;
    private final File regular;
    private final File medium;
    private final File bold;



    public Fonts(File thin, File regular, File medium, File bold) {
        this.thin = thin;
        this.regular = regular;
        this.medium = medium;
        this.bold = bold;
    }



    public Font thin(double size) {
        try {
            return Font.loadFont(new FileInputStream(thin), size);
        } catch (Exception e) {
        }
        return null;
    }



    public Font regular(double size) {
        try {
            return Font.loadFont(new FileInputStream(regular), size);
        } catch (Exception e) {
        }
        return null;
    }



    public Font medium(double size) {
        try {
            return Font.loadFont(new FileInputStream(medium), size);
        } catch (Exception e) {
        }
        return null;
    }



    public Font bold(double size) {
        try {
            return Font.loadFont(new FileInputStream(bold), size);
        } catch (Exception e) {
        }
        return null;
    }

}
