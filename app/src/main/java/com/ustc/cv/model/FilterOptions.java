package com.ustc.cv.model;

/**
 * Author        Daniel
 * Class:        FilterOptions
 * Date:         2018/5/26 11:46
 * Description:  性别、年龄、学历-年限、毕业时间、离职率、是否民办
 */
public class FilterOptions {
    private String gender;
    private Integer age;
    private String durationBachelor; // 本科年限
    private String durationNormal;   // 专科年限
    private String graduateTime;   // 毕业时间
    private String leaveRate;   // 离职率
    private String isPublic;   // 是否限制公办

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDurationBachelor() {
        return durationBachelor;
    }

    public void setDurationBachelor(String durationBachelor) {
        this.durationBachelor = durationBachelor;
    }

    public String getDurationNormal() {
        return durationNormal;
    }

    public void setDurationNormal(String durationNormal) {
        this.durationNormal = durationNormal;
    }

    public String getGraduateTime() {
        return graduateTime;
    }

    public void setGraduateTime(String graduateTime) {
        this.graduateTime = graduateTime;
    }

    public String getLeaveRate() {
        return leaveRate;
    }

    public void setLeaveRate(String leaveRate) {
        this.leaveRate = leaveRate;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }
}
