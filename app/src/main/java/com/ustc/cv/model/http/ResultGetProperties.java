package com.ustc.cv.model.http;

import java.util.ArrayList;

/**
 * Author        Daniel
 * Class:        ResultGetProperties
 * Date:         2018/6/7 14:58
 * Description:  获取职位信息
 */
public class ResultGetProperties extends ResultBase{
    private ArrayList<String> data;

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
