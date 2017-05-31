package com.org.ccl.stepview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.org.ccl.stepview.R;

import java.util.ArrayList;
import java.util.List;

import static com.org.ccl.stepview.R.drawable.icon_circle;

/**
 * Created by ccl on 2017/5/24.
 */

public class StepView extends View {

    private static final int DEFAULT_RADIU = 35;
    private static final int DEFAULT_LINE_HEIGHT = 120;
    private static final int DEFAULT_DASH_PADDING = 6;
    private static final int DEFAULT_DASH_HEIGHT = 15;
    private static final int ORIENTATION_VERTICAL = 0;
    private static final int ORIENTATION_HORIZONTAL = 1;
    private static final int DEFAULT_COMPLETED_DRAWABLE_ID = R.drawable.icon_check;
    private static final int DEFAULT_UNCOMPLETED_DRAWABLE_ID = icon_circle;
    private static final int DEFAULT_COMPLETING_DRAWABLE_ID = R.drawable.icon_exclamation_mark;

    private int mRadiu;
    private int mLineLength;
    private int mDashPadding;
    private int mDashLength;
    private int mOrientation;
    private int mCompletedDrawableResourceId;
    private int mUncompletedDrawableResourceId;
    private int mCompletingDrawableResourceId;

    private Bitmap mIconCompleted;
    private Bitmap mIconCompleting;
    private Bitmap mIconUncompleted;
    private Paint mCompletePaint;
    private Paint mUnCompleted;
    private List<MyStepInfoBean> mData = new ArrayList<>();
    private int mWidth;
    private int mHeight;
    private Rect mCheckRect;
    private Rect mExclamationMarkRect;
    private Rect mCircleRect;
    private Paint mIconPaint;

    public StepView(Context context) {
        this(context, null);
    }

    public StepView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StepView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StepView);
        mRadiu = typedArray.getInt(R.styleable.StepView_radius, DEFAULT_RADIU);
        mLineLength = typedArray.getInt(R.styleable.StepView_line_height, DEFAULT_LINE_HEIGHT);
        mDashPadding = typedArray.getInt(R.styleable.StepView_dash_padding, DEFAULT_DASH_PADDING);
        mDashLength = typedArray.getInt(R.styleable.StepView_dash_height, DEFAULT_DASH_HEIGHT);
        mOrientation = typedArray.getInt(R.styleable.StepView_orientation, ORIENTATION_HORIZONTAL);
        mCompletedDrawableResourceId = typedArray.getResourceId(R.styleable.StepView_icon_completed,DEFAULT_COMPLETED_DRAWABLE_ID);
        mUncompletedDrawableResourceId = typedArray.getResourceId(R.styleable.StepView_icon_uncompleted,DEFAULT_UNCOMPLETED_DRAWABLE_ID);
        mCompletingDrawableResourceId = typedArray.getResourceId(R.styleable.StepView_icon_completing,DEFAULT_COMPLETING_DRAWABLE_ID);
        typedArray.recycle();
        init();
    }

    private void init() {
        mIconCompleted = BitmapFactory.decodeResource(getResources(), mCompletedDrawableResourceId);
        mIconCompleting = BitmapFactory.decodeResource(getResources(), mCompletingDrawableResourceId);
        mIconUncompleted = BitmapFactory.decodeResource(getResources(), mUncompletedDrawableResourceId);
        mIconPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mIconPaint.setStyle(Paint.Style.FILL);
        mCompletePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCompletePaint.setColor(Color.WHITE);
        mCompletePaint.setStrokeWidth(8);
        mCompletePaint.setTextSize(15);
        mUnCompleted = new Paint(Paint.ANTI_ALIAS_FLAG);
        mUnCompleted.setColor(Color.WHITE);
        mUnCompleted.setStrokeWidth(4);

        mCheckRect = new Rect(0, 0, mIconCompleted.getWidth(), mIconCompleted.getHeight());
        mExclamationMarkRect = new Rect(0, 0, mIconCompleting.getWidth(), mIconCompleting.getHeight());
        mCircleRect = new Rect(0, 0, mIconUncompleted.getWidth(), mIconUncompleted.getHeight());
    }

    public void setData(List<MyStepInfoBean> data) {
        if (data == null || data.size() == 0) {
            return;
        }
        mData = data;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mData == null || mData.size() == 0) {
            return;
        }
        int centerIndex = mData.size() % 2 != 0 ? (int) Math.ceil(mData.size() / 2.0f) - 1 : mData.size() / 2 - 1;
        for (int i = 0; i < mData.size(); i++) {
            MyStepInfoBean item = mData.get(i);
            int centerX = (mOrientation == ORIENTATION_HORIZONTAL ? mWidth : mHeight) / 2;
            int centerY = (mOrientation == ORIENTATION_HORIZONTAL ? mHeight : mWidth) / 2;
            int bitmapCenter = mData.size() % 2 != 0 ? centerX - (centerIndex - i) * (mLineLength + mRadiu * 2) : (int) (centerX - (centerIndex - i + 0.5) * (mLineLength + mRadiu * 2));
            Rect srcBitmapRect = mOrientation == ORIENTATION_HORIZONTAL ? new Rect(bitmapCenter - mRadiu, centerY - mRadiu, bitmapCenter + mRadiu, centerY + mRadiu) :
                    new Rect(centerY - mRadiu, bitmapCenter - mRadiu, centerY + mRadiu, bitmapCenter + mRadiu);
            canvas.drawBitmap(item.getStatus() == MyStepInfoBean.StepStatus.COMPLETED ? mIconCompleted :
                    item.getStatus() == MyStepInfoBean.StepStatus.COMPLETING ? mIconCompleting :
                            mIconUncompleted, item.getStatus() == MyStepInfoBean.StepStatus.COMPLETED ? mCheckRect :
                    item.getStatus() == MyStepInfoBean.StepStatus.COMPLETING ? mExclamationMarkRect :
                            mCircleRect, srcBitmapRect, mIconPaint);
            float v = mCompletePaint.measureText(item.getName());
            if (mOrientation == ORIENTATION_HORIZONTAL) {
                canvas.drawText(item.getName(), bitmapCenter - v / 2, centerY + mRadiu * 2, mCompletePaint);
            } else {
                canvas.drawText(item.getName(), centerY + mRadiu * 2, bitmapCenter, mCompletePaint);
            }

            if (i < mData.size() - 1) {
                int lineLeft = mData.size() % 2 != 0 ? (int) (centerX - (centerIndex - i) * mLineLength - (centerIndex - i - 0.5) * mRadiu * 2) : (int) (centerX - (centerIndex - i + 0.5) * mLineLength - (centerIndex - i) * mRadiu * 2);
                if (mData.get(i + 1).getStatus() == MyStepInfoBean.StepStatus.UNCOMPLETED) {
                    for (int j = 0; j < 6; j++) {
                        if (mOrientation == ORIENTATION_HORIZONTAL) {
                            canvas.drawLine(lineLeft + (mDashLength + mDashPadding) * j, centerY - 2, lineLeft + mDashLength * (j + 1) + mDashPadding * j, centerY - 2, mUnCompleted);
                        } else {
                            canvas.drawLine(centerY - 2, lineLeft + (mDashLength + mDashPadding) * j, centerY - 2, lineLeft + mDashLength * (j + 1) + mDashPadding * j, mUnCompleted);
                        }
                    }
                } else {
                    if (mOrientation == ORIENTATION_HORIZONTAL) {
                        canvas.drawLine(lineLeft, centerY - 2, lineLeft + mLineLength, centerY - 2, mCompletePaint);
                    } else {
                        canvas.drawLine(centerY - 2, lineLeft, centerY - 2, lineLeft + mLineLength, mCompletePaint);
                    }
                }
            }
        }
    }
}
