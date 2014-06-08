package com.heroicrobotics.pixelpusher.application;

import com.heroicrobot.dropbit.devices.pixelpusher.Pixel;

public abstract class Pattern implements Runnable {

    final Pixel[] _pixelArray;
    final int _width;
    final int _height;

    Pattern(Pixel[] pixelArray, int width, int height) {
        this._pixelArray = pixelArray;
        this._width = width;
        this._height = height;

    }


    @Override
    abstract public void run();

}
