package com.example.tam.kukube;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Tam on 2/28/2018.
 */

public class textView extends TextView{


    public textView(Context context) {
        super(context);
    }

    public textView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public textView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //chia chiều dài và chiều rộng tự động cho các cột và hàng của gridview
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int dairong = getMeasuredWidth();
        setMeasuredDimension(dairong, dairong);

    }
}
