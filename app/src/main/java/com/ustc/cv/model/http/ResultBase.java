package com.ustc.cv.model.http;

import com.ustc.cv.model.FilterOptions;
import com.ustc.cv.model.Person;

import java.util.List;

/**
 * Author        Daniel
 * Class:        ResultBase
 * Date:         2018/5/26 11:48
 * Description:  请求基类
 */
public class ResultBase {
    private Integer result;
    private String msg;
    private Object data;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
