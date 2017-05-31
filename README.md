# StepView #

[[![](https://jitpack.io/v/chencanlin/StepView.svg)](https://jitpack.io/#chencanlin/StepView)]([![](https://jitpack.io/v/chencanlin/StepView.svg)](https://jitpack.io/#chencanlin/StepView) "How to")

**STEP1** Add it in your root build.gradle at the end of repositories:

    	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

**STEP2 Add the dependency**

	    dependencies {
	        compile 'com.github.chencanlin:StepView:1.1.0'
	}

**效果预览**

![](http://i.imgur.com/HCqbYXB.png)

**使用**
    
	<com.org.ccl.stepview.view.StepView
            android:id="@+id/sv_four"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#66C9F7"
            app:orientation="horizontal"
			app:icon_completed="@drawable/icon_check"
            app:icon_uncompleted="@drawable/icon_circle"
            app:icon_completing="@drawable/icon_exclamation_mark"
            />

	 fourData.add(new MyStepInfoBean("接单",MyStepInfoBean.StepStatus.COMPLETED));
     fourData.add(new MyStepInfoBean("打包",MyStepInfoBean.StepStatus.COMPLETED));
     fourData.add(new MyStepInfoBean("出发",MyStepInfoBean.StepStatus.COMPLETED));
     fourData.add(new MyStepInfoBean("送单",MyStepInfoBean.StepStatus.COMPLETED));
     fourData.add(new MyStepInfoBean("完成",MyStepInfoBean.StepStatus.COMPLETING));
     fourData.add(new MyStepInfoBean("支付",MyStepInfoBean.StepStatus.UNCOMPLETED));

		mOne.setData(oneData);
        mTwo.setData(twoData);
        mThree.setData(threeData);
        mFour.setData(fourData);

**效果预览**

![](http://i.imgur.com/zn1LIkg.png)

**使用**

	<com.org.ccl.stepview.view.StepView
            android:id="@+id/sv_four"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#66C9F7"
            app:orientation="vertical"
			app:icon_completed="@drawable/icon_check"
            app:icon_uncompleted="@drawable/icon_circle"
            app:icon_completing="@drawable/icon_exclamation_mark"
            />
		fourData.add(new MyStepInfoBean("接单",MyStepInfoBean.StepStatus.COMPLETED));
        fourData.add(new MyStepInfoBean("打包",MyStepInfoBean.StepStatus.COMPLETED));
        fourData.add(new MyStepInfoBean("出发",MyStepInfoBean.StepStatus.COMPLETED));
        fourData.add(new MyStepInfoBean("送单",MyStepInfoBean.StepStatus.COMPLETED));
        fourData.add(new MyStepInfoBean("完成",MyStepInfoBean.StepStatus.COMPLETING));
        fourData.add(new MyStepInfoBean("支付",MyStepInfoBean.StepStatus.UNCOMPLETED));

		mOne.setData(oneData);
        mTwo.setData(twoData);
        mThree.setData(threeData);
        mFour.setData(fourData);