package com.example.danny.xfermode.XferModeView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.danny.xfermode.R;

/**
 * Created by danny on 2016/3/26.
 */
public class XferModeView extends View {

    private Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private Paint paint = new Paint();
    private int progress = 0;
    private Bitmap backMap;


    public XferModeView(Context context) {
        super(context);
        init();
    }

    public XferModeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        backMap = BitmapFactory.decodeResource(getResources(), R.drawable.digital_3).copy(Bitmap.Config.ARGB_8888, true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       funcOne(canvas);
//        funcTwo(canvas);


    }

    /**
     * 第一种方法
     * */
    private void funcOne(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        Canvas canvas1 = new Canvas(backMap);
        paint.setFilterBitmap(false);
        paint.setColor(Color.GREEN);
        paint.setXfermode(xfermode);
        canvas1.drawRect(0, backMap.getHeight() * 1 / 3, backMap.getWidth(), backMap.getHeight(), paint);
        paint.setXfermode(null);
        canvas.drawBitmap(backMap, 0, 0, paint);
    }

    private void funcTwo(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(backMap,0,0,paint);
//        backMap.get
        paint.setFilterBitmap(false);
        paint.setColor(Color.GREEN);
        paint.setXfermode(xfermode);
        canvas.drawRect(0,200,backMap.getWidth(),backMap.getHeight(),paint);
        paint.setXfermode(null);
//        canvas.drawBitmap(backMap, 0, 0, paint);
    }
    public void setProgress(){

    }
}
