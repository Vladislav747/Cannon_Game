package com.example.melo.cannon_game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
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
    public static final int TARGET_PIECES = 7; // Количество секций мишени
    public static final int MISS_PENALTY = 2; // Убавление времени на 7 (с) времени если не попал
    public static final int HIT_REWARD = 3;//Прибавка 3 (с) времени при попадании



    //переменные для цикла игры и сбора статистики
    private boolean gameOver; //Игра закончена
    private double timeLeft; //Времени осталось
    private int shotsFired; //Количество выстрелов
    private double totalElapsedTime; //Количество прошедшего времени

//переменные для определения блока и мишени
    //Переменные для блока
    private Line blocker; //Начальная и конечная точки блока
    private int blockerDistance; //Растояние от блоки слева
    private int blockerBeginning;// Вертикальное смещение верхнего края блока
    private int blockerEnd; //Вертикальное смещение нижнего края блока
    private int initialBlockerVelocity; //Исходная скорость блока
    private float blockerVelocity; //Множитель скорости блока во время игры


    //Переменные мишени
    private Line target; //Начальная и конечная точки мишени
    private int targetDistance; //Растояние от мишени слева
    private int targetBeginning;// Вертикальное смещение верхнего края мишени
    private int pieceLength; //Длина секции мишени
    private int targetEnd; //Вертикальное смещение нижнего края мишени
    private int initialtargetVelocity; //Исходная скорость мишени
    private float targetVelocity; //Множитель скорости мишени во время игры




    private int lineWidth; //Ширина цели и блока
    private boolean[] hitStates; //Поражены ли все цели секции мишени
    private int targetPiecesHit; //Количество пораженных секций (из 7)


//Переменные для пушки и ядра
    private Point cannonball; //Левый Верхний угол изображения ядра
    private int cannonballVelocityX; //Горизонтальная скорость ядра
    private int cannonballVelocityY; //Вертикальная скорость ядра
    private boolean cannonballOnScreen; //Ядро находится на экране
    private int cannonballRadius; //Радиус ядра
    private int cannonballSpeed; //Скорость ядра






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
