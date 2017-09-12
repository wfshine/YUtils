package com.yechaoa.yutils;

import android.os.Handler;
import android.os.HandlerThread;

/**
 * Created by yechao on 2017/3/21.
 * Describe : ExitUtils
 * <p>
 * GitHub : https://github.com/yechaoa
 * CSDN : http://blog.csdn.net/yechaoa
 */

public class ExitUtils {
    private boolean isExit = false;

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            isExit = false;
        }
    };

    public void doExitAction() {
        isExit = true;
        HandlerThread thread = new HandlerThread("dotask");
        thread.start();
        //将一个线程绑定到Handler对象上，则该Handler对象就可以处理线程的消息队列
        new Handler(thread.getLooper()).postDelayed(task, 1500);
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean isExit) {
        this.isExit = isExit;
    }
}