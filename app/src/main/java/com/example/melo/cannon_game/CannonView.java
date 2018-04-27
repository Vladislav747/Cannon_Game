package com.example.melo.cannon_game;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Melo on 26.04.2018.
 */

public class CannonView extends SurfaceView implements SurfaceHolder.Callback {

    //Для регистрации ошибок
    private static final String TAG = "CannonView";
private Activity activity; //для вывода окна завершения игры в потоке gui
    public boolean dialogDisplayed = false;

    //Константы используемые в игре
    public static final int TARGET_PIECES = 2;
    public static final int MISS_PENALTY= 7;


    private CannonThread cannonThread; //Управление циклом игры

    public CannonView(Context context) {
        super(context);
    }

    public CannonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CannonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CannonView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
