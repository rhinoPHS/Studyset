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
public class MyView extends View implements View.OnTouchListener{

    private int x,y;
    private MyListener listener;

    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
        this.setOnTouchListener((View.OnTouchListener)this);
    }

    public interface MyListener{
        public void onChanged();
    }

    public void  setMyViewListener(MyListener lis){
        listener = lis;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(30);
        canvas.drawText("("+ x + "," + y + ")에서 이벤트 발생",x,y,paint);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = (int)event.getX();
        y = (int)event.getY();
        invalidate();
        return super.onTouchEvent(event);
    }
}
