package com.demo.test.library.widget;

import android.net.Uri;

import java.io.File;
import java.net.URL;

/**
 * drawable资源
 * Created by WuLe
 */
public class DrawableResource {

    public enum Type {
        Integer,        // Integer
        File,           // File
        URL,            // URL
        Uri,            // Uri
        String,         // String
        INVALID         // 无效资源
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public DrawableResource(Integer integer) {
        this.drawableRes = integer;
    }

    public DrawableResource(File file) {
        this.drawableRes = file;
    }

    public DrawableResource(URL url) {
        drawableRes = url;
    }

    public DrawableResource(Uri uri) {
        drawableRes = uri;
    }

    public DrawableResource(String string) {
        drawableRes = string;
    }

    Object drawableRes;

    public Type getType() {
        if (drawableRes != null) {
            if (drawableRes instanceof Integer) {
                return Type.Integer;
            } else if (drawableRes instanceof File) {
                return Type.File;
            } else if (drawableRes instanceof URL) {
                return Type.URL;
            } else if (drawableRes instanceof Uri) {
                return Type.Uri;
            } else if (drawableRes instanceof String) {
                return Type.String;
            }
        }
        return Type.INVALID;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean isInvalid() {
        return getType().equals(Type.INVALID);
    }

    public int getInteger() {
        return (Integer) drawableRes;
    }

    public File getFile() {
        return (File) drawableRes;
    }

    public URL getURL() {
        return (URL) drawableRes;
    }

    public Uri getUri() {
        return (Uri) drawableRes;
    }

    public String getString() {
        return (String) drawableRes;
    }
}
