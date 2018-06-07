package com.ustc.cv.callback;

import com.ustc.cv.view.FilterDialog;

/**
 * @ClassName: OnItemClickListener.java
 * @Description: item点击事件
 * @author Daniel
 * @date 2017/10/12 13:38
 */
public interface OnDialogSubmitListener<T> {
    void onSubmit(T t, FilterDialog filterDialog);
}
