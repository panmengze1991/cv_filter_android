package com.ustc.cv.utils;

import android.widget.EditText;

public class CommonUtils {

    public static boolean isNotEmpty(EditText et1,EditText et2){
        return isNotEmpty(et1)&&isNotEmpty(et2);
    }

    public static boolean isNotEmpty(EditText editText){
        return !getText(editText).isEmpty();
    }

    public static String getText(EditText editText){
        return editText.getText().toString().trim();
    }
}
