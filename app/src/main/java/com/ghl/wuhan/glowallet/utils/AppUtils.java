package com.ghl.wuhan.glowallet.utils;

import android.util.Log;

/**
 * 项目名称：GLOWallet
 * 类描叙：本App相关的一些常量，比如：APP_NAME行
 * 创建人：chenmin
 * 创建时间： 2017/12/14 10:46
 * 修改人：chenmin
 * 修改时间： 2017/12/14 10:46
 * 修改备注：
 * 版本：
 */

public class AppUtils {

    public static final String APP_NAME = "GLOWallet";
    public static final String TAG = "GLOWallet";

    public static final int DIALOG_COLOR_RED = 0;
    public static final int DIALOG_COLOR_BLANK = 1;

    public static void showLog(String message){
        Log.i(TAG,message);
    }

}
