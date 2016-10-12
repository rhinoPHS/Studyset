package com.example.sh408.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by sh408 on 2016-10-12.
 */
public class MyView extends View {

    int x,y;

    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(30);
        canvas.drawText("("+ x + "," + y + ")에서 이벤트 발생",x,y,paint);
        super.onDraw(canvas);
    }
}
