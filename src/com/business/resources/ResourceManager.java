/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business.resources;

import java.io.File;

/**
 *
 * @author daan-
 */
public class ResourceManager {

    public static final File getLocalFXMLFolder() {
        return new File(getLocalFXMLPath());
    }



    public static final File getLocalBGGraphicsFolder() {
        return new File(getLocalBGGraphicsPath());
    }



    public static File getLocalButtonGraphicsFolder() {
        return new File(getLocalButtonGraphicsPath());
    }



    public static File getLocalCSSFolder() {
        return new File(getLocalCSSPath());
    }



    public static File getLocalFontsFolder() {
        return new File(getLocalFontsPath());
    }



    private static String getLocalFXMLPath() {
        String path = getLocalResourcePath() + "fxml/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }



    private static String getLocalBGGraphicsPath() {
        String path = getLocalResourcePath() + "graphics/bgs/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }



    private static String getLocalButtonGraphicsPath() {
        String path = getLocalResourcePath() + "graphics/buttons/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }



    private static String getLocalCSSPath() {
        String path = getLocalResourcePath() + "css/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }



    private static String getLocalFontsPath() {
        String path = getLocalResourcePath() + "fonts/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }



    private static String getLocalResourcePath() {
        String path = System.getProperty("user.home").replaceAll("\\\\", "/") + "/AppData/local/rwt_resources/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }

}
