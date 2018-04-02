package com.yapa.api;

import android.os.Build;

public class Utilities {

    public static boolean isNycMR1OrAbove() {
        return Build.VERSION.SDK_INT >= 25; //Build.VERSION_CODES.N_MR1;
    }

    public static boolean isNycOrAbove() {
        return Build.VERSION.SDK_INT >= 24; //Build.VERSION_CODES.N;
    }

    public static final boolean ATLEAST_MARSHMALLOW =
            Build.VERSION.SDK_INT >= 23; //Build.VERSION_CODES.M;

    public static final boolean ATLEAST_LOLLIPOP_MR1 =
            Build.VERSION.SDK_INT >= 22; //Build.VERSION_CODES.LOLLIPOP_MR1;

    public static final boolean ATLEAST_LOLLIPOP =
            Build.VERSION.SDK_INT >= 21; //Build.VERSION_CODES.LOLLIPOP;

    public static final boolean ATLEAST_KITKAT =
            Build.VERSION.SDK_INT >= 19; //Build.VERSION_CODES.KITKAT;

    public static final boolean ATLEAST_JB_MR2 =
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;

    public static final boolean ATLEAST_JB_MR1 =
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;

}
