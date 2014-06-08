package com.heroicrobotics.pixelpusher.application;

import android.os.SystemClock;

import com.heroicrobot.dropbit.devices.pixelpusher.Pixel;

/**
 * Created by mattstone on 6/7/14.
 */
public class RainbowWheelPattern extends Pattern {

    private static final long _FRAME_DELAY = 10;

    RainbowWheelPattern(Pixel[] pixelArray, int width, int height) {
        super(pixelArray, width, height);
    }

    @Override
    public void run() {
        int i, j = 0;
        for (j = 0; j < 384 * 5; j++) {     // 5 cycles of all 384 colors in the wheel
            for (i = 0; i < this._pixelArray.length; i++) {
                this._pixelArray[i] = Wheel(((i * 384 / this._pixelArray.length) + j) % 384);
            }

            SystemClock.sleep(_FRAME_DELAY);
        }
    }

    Pixel Wheel(int WheelPos) {
        byte r = 0;
        byte g = 0;
        byte b = 0;
        switch (WheelPos / 128) {
            case 0:
                r = (byte) (127 - WheelPos % 128); // red down
                g = (byte) (WheelPos % 128);       // green up
                b = 0;                    // blue off
                break;
            case 1:
                g = (byte) (127 - WheelPos % 128); // green down
                b = (byte) (WheelPos % 128);       // blue up
                r = 0;                    // red off
                break;
            case 2:
                b = (byte) (127 - WheelPos % 128); // blue down
                r = (byte) (WheelPos % 128);       // red up
                g = 0;                    // green off
                break;
        }
        return new Pixel(r, g, b);
    }
}
