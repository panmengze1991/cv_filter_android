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

    /**
     * author:      Daniel
     * description: 返回输入字符串，如果为空返回null
     */
    public static String getStringText(EditText editText){
        return "".equals(getText(editText))?null:getText(editText);
    }

    /**
     * author:      Daniel
     * description: 返回输入数据，如果为空返回null
     */
    public static Integer getNumber(EditText editText){
        return "".equals(getText(editText))?null:Integer.valueOf(getText(editText));
    }
}
