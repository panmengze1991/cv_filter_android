package com.ustc.cv.model.http;

import com.ustc.cv.model.Person;

import java.util.List;

/**
 * Author        Daniel
 * Class:        ResultBase
 * Date:         2018/5/26 11:48
 * Description:  提交过滤选项返回的名单结果
 */
public class ResultPostProperties extends ResultBase{
    private List<Person> data;

    @Override
    public List<Person> getData() {
        return data;
    }

    public void setData(List<Person> data) {
        this.data = data;
    }
}
