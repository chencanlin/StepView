package com.org.ccl.stepview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.org.ccl.stepview.view.MyStepInfoBean;
import com.org.ccl.stepview.view.StepView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MyStepInfoBean> oneData = new ArrayList<>();
    private ArrayList<MyStepInfoBean> twoData = new ArrayList<>();
    private ArrayList<MyStepInfoBean> threeData = new ArrayList<>();
    private ArrayList<MyStepInfoBean> fourData = new ArrayList<>();
    private StepView mOne;
    private StepView mTwo;
    private StepView mThree;
    private StepView mFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initView();
        initData();
        setData();
    }

    private void initView() {
        mOne = (StepView) findViewById(R.id.sv_one);
        mTwo = (StepView) findViewById(R.id.sv_two);
        mThree = (StepView) findViewById(R.id.sv_three);
        mFour = (StepView) findViewById(R.id.sv_four);
    }

    private void initData() {
        oneData.add(new MyStepInfoBean("接单",MyStepInfoBean.StepStatus.COMPLETED));
        oneData.add(new MyStepInfoBean("打包",MyStepInfoBean.StepStatus.COMPLETING));
        oneData.add(new MyStepInfoBean("出发",MyStepInfoBean.StepStatus.UNCOMPLETED));

        twoData.add(new MyStepInfoBean("接单",MyStepInfoBean.StepStatus.COMPLETED));
        twoData.add(new MyStepInfoBean("打包",MyStepInfoBean.StepStatus.COMPLETED));
        twoData.add(new MyStepInfoBean("出发",MyStepInfoBean.StepStatus.COMPLETING));
        twoData.add(new MyStepInfoBean("送单",MyStepInfoBean.StepStatus.UNCOMPLETED));

        threeData.add(new MyStepInfoBean("接单",MyStepInfoBean.StepStatus.COMPLETED));
        threeData.add(new MyStepInfoBean("打包",MyStepInfoBean.StepStatus.COMPLETED));
        threeData.add(new MyStepInfoBean("出发",MyStepInfoBean.StepStatus.COMPLETED));
        threeData.add(new MyStepInfoBean("送单",MyStepInfoBean.StepStatus.COMPLETING));
        threeData.add(new MyStepInfoBean("完成",MyStepInfoBean.StepStatus.UNCOMPLETED));

        fourData.add(new MyStepInfoBean("接单",MyStepInfoBean.StepStatus.COMPLETED));
        fourData.add(new MyStepInfoBean("打包",MyStepInfoBean.StepStatus.COMPLETED));
        fourData.add(new MyStepInfoBean("出发",MyStepInfoBean.StepStatus.COMPLETED));
        fourData.add(new MyStepInfoBean("送单",MyStepInfoBean.StepStatus.COMPLETED));
        fourData.add(new MyStepInfoBean("完成",MyStepInfoBean.StepStatus.COMPLETING));
        fourData.add(new MyStepInfoBean("支付",MyStepInfoBean.StepStatus.UNCOMPLETED));
    }

    private void setData() {
        mOne.setData(oneData);
        mTwo.setData(twoData);
        mThree.setData(threeData);
        mFour.setData(fourData);
    }
}
