package com.org.ccl.stepview.view;

/**
 * Created by ccl on 2017/5/24.
 */

public class MyStepInfoBean {
    private String name;
    private Enum status;

    public MyStepInfoBean(String name, Enum status) {
        this.name = name;
        this.status = status;
    }

    public enum StepStatus {
        COMPLETED,UNCOMPLETED,COMPLETING
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }
}
