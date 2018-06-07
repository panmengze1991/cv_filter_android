package com.ustc.cv.model;

/**
 * Author        Daniel
 * Class:        FilterOptions
 * Date:         2018/5/26 11:46
 * Description:  性别、年龄、学历-年限、毕业时间、离职率、是否民办
 * {
 *     "ageTop":22,          // 年龄限制上界(可选，默认不限制)
 *     "ageBottom":24,       // 年龄限制下界(可选，默认不限制)
 *     "duration":[["doctor",0,0],["bachelor",0,3],["normal",3,5]]
 *     "gender":1,            // 性别(可选，默认不限制)
 *     "isPublic":"否",          // 要求公立(可选，默认不限制)
 *     "leaveRate":0.5,     // 离职率(可选，默认不限制)
 *     "career":"Java",          // 岗位（必选）
 *     "description":"具有..."   // 描述(必填)
 * }
 *
 */
public class FilterOptions {
    private Integer ageTop;
    private Integer ageBottom;
    private String[][] duration;
    private Integer gender;
    private String isPublic;   // 是否限制公办
    private Double leaveRate;   // 离职率
    private String career;   // 行业
    private String description;   // 要求

    public Integer getAgeTop() {
        return ageTop;
    }

    public void setAgeTop(Integer ageTop) {
        this.ageTop = ageTop;
    }

    public Integer getAgeBottom() {
        return ageBottom;
    }

    public void setAgeBottom(Integer ageBottom) {
        this.ageBottom = ageBottom;
    }

    public String[][] getDuration() {
        return duration;
    }

    public void setDuration(String[][] duration) {
        this.duration = duration;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public Double getLeaveRate() {
        return leaveRate;
    }

    public void setLeaveRate(Double leaveRate) {
        this.leaveRate = leaveRate;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
