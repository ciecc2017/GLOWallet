package com.ghl.wuhan.glowallet.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ghl.wuhan.glowallet.R;
import com.ghl.wuhan.glowallet.utils.AppUtils;


/**
 * Create custom Dialog windows for your application
 * Custom dialogs rely on custom layouts wich allow you to
 * create and use your own look & feel.
 */
public class CustomInputDialog extends Dialog {

    public CustomInputDialog(Context context, int theme) {
        super(context, theme);
    }

    public CustomInputDialog(Context context) {
        super(context);
    }

    /**
     * Helper class for creating a custom dialog
     */
    public static class Builder {

        private Context context;
        private String title;
        private String message;
        private String positiveButtonText;
        private String negativeButtonText;
        private View contentView;

        //用户名、密码
        private String userID;
        private String userPassword;

        private EditText et_superuser_input_edittext;
        private EditText et_password_input_edittext;


        private OnClickListener
                positiveButtonClickListener,
                negativeButtonClickListener;

        public Builder(Context context) {
            this.context = context;
        }



        public String getUserID() {
            return et_superuser_input_edittext.getText().toString();
        }


        public String getUserPassword() {
            return et_password_input_edittext.getText().toString();
        }



        /**
         * Set the Dialog message from String
         * @return
         */
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * Set the Dialog message from resource
         * @return
         */
        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        /**
         * Set the Dialog title from resource
         * @param title
         * @return
         */
        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        /**
         * Set the Dialog title from String
         * @param title
         * @return
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Set the Dialog title from resource
         * @param userID
         * @return
         */
        public Builder setUserID(int userID) {
            this.userID = (String) context.getText(userID);
            return this;
        }

        /**
         * Set the Dialog title from resource
         * @param userID
         * @return
         */
        public void setUserID(String userID) {
            this.userID = userID;
        }



        /**
         * Set the Dialog title from resource
         * @param userPassword
         * @return
         */
        public Builder setUserPassword(int userPassword) {
            this.userPassword = (String) context.getText(userPassword);
            return this;
        }

        /**
         * Set the Dialog title from String
         * @param userPassword
         * @return
         */
        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        /**
         * Set a custom content view for the Dialog.
         * If a message is set, the contentView is not
         * added to the Dialog...
         * @param v
         * @return
         */
        public Builder setContentView(View v) {
            this.contentView = v;
            return this;
        }

        /**
         * Set the positive button resource and it's listener
         * @param positiveButtonText
         * @param listener
         * @return
         */
        public Builder setPositiveButton(int positiveButtonText,
                                         OnClickListener listener) {
            this.positiveButtonText = (String) context
                    .getText(positiveButtonText);
            this.positiveButtonClickListener = listener;
            return this;
        }

        /**
         * Set the positive button text and it's listener
         * @param positiveButtonText
         * @param listener
         * @return
         */
        public Builder setPositiveButton(String positiveButtonText,
                                         OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        /**
         * Set the negative button resource and it's listener
         * @param negativeButtonText
         * @param listener
         * @return
         */
        public Builder setNegativeButton(int negativeButtonText,
                                         OnClickListener listener) {
            this.negativeButtonText = (String) context
                    .getText(negativeButtonText);
            this.negativeButtonClickListener = listener;
            return this;
        }

        /**
         * Set the negative button text and it's listener
         * @param negativeButtonText
         * @param listener
         * @return
         */
        public Builder setNegativeButton(String negativeButtonText,
                                         OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        /**
         * Create the custom dialog
         */
        public CustomInputDialog create(int MSG_COLOR) {
            LayoutInflater inflater = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final CustomInputDialog dialog = new CustomInputDialog(context, R.style.Dialog);
            dialog.setCanceledOnTouchOutside(false);
            View layout = null;
            if(MSG_COLOR== AppUtils.DIALOG_COLOR_RED) {
                layout = inflater.inflate(R.layout.custom_dialog_input_layout, null);
            }else{
                layout = inflater.inflate(R.layout.custom_dialog_input_black_layout, null);
            }
            dialog.addContentView(layout, new LayoutParams(
                    LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            // set the dialog title
            ((TextView) layout.findViewById(R.id.title)).setText(title);


            // 对edittext进行初始化，关键代码
            et_superuser_input_edittext = (EditText) layout.findViewById(R.id.et_superuser_input_edittext);
            et_password_input_edittext = (EditText) layout.findViewById(R.id.et_password_input_edittext);

            // set the confirm button
            if (positiveButtonText != null) {
                ((Button) layout.findViewById(R.id.positiveButton))
                        .setText(positiveButtonText);
                if (positiveButtonClickListener != null) {
                    ((Button) layout.findViewById(R.id.positiveButton))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    positiveButtonClickListener.onClick(
                                            dialog,
                                            DialogInterface.BUTTON_POSITIVE);
                                }
                            });
                }
            } else {
                // if no confirm button just set the visibility to GONE
                layout.findViewById(R.id.positiveButton).setVisibility(
                        View.GONE);
            }
            // set the cancel button
            if (negativeButtonText != null) {
                ((Button) layout.findViewById(R.id.negativeButton))
                        .setText(negativeButtonText);
                if (negativeButtonClickListener != null) {
                    ((Button) layout.findViewById(R.id.negativeButton))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    negativeButtonClickListener.onClick(
                                            dialog,
                                            DialogInterface.BUTTON_NEGATIVE);
                                    dialog.dismiss();
                                }
                            });
                }
            } else {
                // if no confirm button just set the visibility to GONE
                layout.findViewById(R.id.negativeButton).setVisibility(
                        View.GONE);
            }
            // set the content message
            if (message != null) {
                ((TextView) layout.findViewById(
                        R.id.message)).setText(message);
            } else if (contentView != null) {
                // if no message set
                // add the contentView to the dialog body
                ((LinearLayout) layout.findViewById(R.id.content))
                        .removeAllViews();
                ((LinearLayout) layout.findViewById(R.id.content))
                        .addView(contentView,
                                new LayoutParams(
                                        LayoutParams.WRAP_CONTENT,
                                        LayoutParams.WRAP_CONTENT));
            }
            dialog.setContentView(layout);
            return dialog;
        }

    }

}