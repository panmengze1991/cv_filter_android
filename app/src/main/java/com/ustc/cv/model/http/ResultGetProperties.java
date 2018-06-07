package com.ustc.cv.model.http;

import java.util.List;

/**
 * Author        Daniel
 * Class:        ResultGetProperties
 * Date:         2018/6/7 14:58
 * Description:  获取职位信息
 */
public class ResultGetProperties extends ResultBase{
    private List<String> data;

    @Override
    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
