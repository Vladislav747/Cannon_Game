package com.example.melo.cannon_game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.AttributeSet;
import android.util.SparseIntArray;
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
private int cannonBaseRadius;//Радиус основания пушки
    private int cannonLength; //Длина ствола пушки
    private Point barrelEnd; //Конец ствола пушки
    private int screenWidth; // Ширина экрана
    private int screenHeight; // Высота экрана

    //константы и переменные для управления звуком
    private static final int TARGET_SOUND_ID = 0;
    private static final int CANNON_SOUND_ID = 1;
    private static final int BLOCKER_SOUND_ID = 2;
private SoundPool soundPool; //Для воспроизведения звуковых эффектов
    private SparseIntArray soundMap; //Связывание идентификаторов с SoundPool

    //Переменные Paint для рисования на экране
    private Paint textPaint; //Для вывода текста
    private Paint cannonballPaint; //Для рисования ядра
    private Paint cannonPaint; //Для рисования пушки
    private Paint blockerPaint; //Для рисования блока
    private Paint targetPaint; //Для рисования мишени
    private Paint backgroundPaint; //Для рисования фона


    private CannonThread cannonThread; //Управление циклом игры


    public CannonView(Context context, AttributeSet attrs) {

        super(context, attrs); //Вызов конструктора суперкласса
        activity = (Activity) context; //Сохранение ссылки на MainActivity

        //Регистрация слушателя SurfaceHolder.Callback на этот объект
        getHolder().addCallback(this);

        //Инициализация игровых объектов  Line и Point;
        blocker = new Line();
        target = new Line();
        cannonball = new Point();


        //Иницилизация массива логических знаний hitStates
        hitStates = new boolean[TARGET_PIECES];

        //Инициализация SoundPool для звуковых эффектов приложения
        //???? DEPREACATED!!
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);


        //Создание контейнера
soundMap = new SparseIntArray(3); //Создание массива с 3 возможными ячейками
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
