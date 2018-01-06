package com.ghl.wuhan.glowallet.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.ghl.wuhan.glowallet.utils.AppUtils;

/**
 * 项目名称：GLOWallet
 * 类描叙：
 * 创建人：chenmin
 * 创建时间： 2017/11/9 14:13
 * 修改人：chenmin
 * 修改时间： 2017/11/9 14:13
 * 修改备注：
 * 版本：
 */
public class DialogUIUtils {


    /**
     * Show loading dialog dialog.
     *
     * @param context the context
     * @param showMes the show mes
     * @return the dialog
     */
    public static Dialog showLoadingDialog(Context context, String showMes){
        Dialog progressDialog;
        progressDialog = CustomProgressTransDialog.createLoadingDialog(context, showMes);
        return progressDialog;
    }

    /**
     * Dismiss.
     *
     * @param dialog the dialog
     */
    public static void dismiss(Dialog dialog){

        if(dialog!=null){
            dialog.dismiss();
            dialog = null;
        }
    }

    /*
      显示的信息,相当于alert
     */

    /**
     * Show mes dialog.
     *
     * @param context the context
     * @param message the message
     */
    public static void showMesDialog(Context context, String message,int MSG_COLOR){

        CustomDialog customDialog;
        CustomDialog.Builder customBuilder = new
                CustomDialog.Builder(context);
        customBuilder.setTitle(AppUtils.APP_NAME)
                .setMessage(message)

                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
        customDialog = customBuilder.create(MSG_COLOR);
        customDialog.show();

    }

    /*
      显示出错的信息，并跳转到其它页面，比如MainActivity 。
      调用时VoidScanBarJsonActivity页中，如： DialogUIUtils.showMesDialogAndToAnotherActivity(VoidScanBarJsonActivity.this,errMsg,MainActivity.class);
     */
    public static void showMesDialogAndToAnotherActivity(final Context context, String message,int MSG_COLOR,final Class clazz){

        CustomDialog customDialog;
        CustomDialog.Builder customBuilder = new
                CustomDialog.Builder(context);
        customBuilder.setTitle(AppUtils.APP_NAME)
                .setMessage(message)

                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(context,clazz);
                                context.startActivity(intent);
                            }
                        });
        customDialog = customBuilder.create(MSG_COLOR);
        customDialog.show();

    }


    public static void alertInputDialog(final Context context, String message,int MSG_COLOR) {

        final CustomInputDialog customInputDialog;
        final CustomInputDialog.Builder customBuilder = new CustomInputDialog.Builder(context);

        customBuilder.setTitle(AppUtils.APP_NAME)
                .setMessage(message)

                .setPositiveButton("Submit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                if(customBuilder.getUserID()!=null&&customBuilder.getUserPassword()!=null&&!customBuilder.getUserPassword().trim().equals("")&&!customBuilder.getUserPassword().trim().equals("")) {

                                    // 用户输入的用户名和密码。
                                    String inputUserId = customBuilder.getUserID();
                                    String password = customBuilder.getUserPassword();

                                    dialog.dismiss();

                                }else{  //没有输入超级用户，或者输入的不完整
                                    Toast.makeText(context,"Please enter the complete information.",Toast.LENGTH_SHORT).show();
                                }
                            }
                        })

                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

        customInputDialog = customBuilder.create(MSG_COLOR);
        customInputDialog.show();

    }


}
