package com.ghl.wuhan.glowallet.home;

import android.app.Dialog;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ghl.wuhan.glowallet.R;
import com.ghl.wuhan.glowallet.customdialog.DialogUIUtils;
import com.ghl.wuhan.glowallet.utils.AppUtils;

/**
 * 项目名称：GLOWallet
 * 类描叙：HomeFragment
 * 创建人：chenmin
 * 创建时间： 2017-12-12 15:30：20
 * 修改人：chenmin
 * 修改时间： 2017-12-12 15:30：20
 * 修改备注：
 * 版本：
 */
    public class HomeFragment extends Fragment {

        private Button btn_input,btn_alert,btn_progress;

        public HomeFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_home, container, false);
        }


        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onActivityCreated(savedInstanceState);

            btn_alert = (Button) getActivity().findViewById(R.id.btn_alert);
            btn_alert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //这是红框
                //    DialogUIUtils.showMesDialog(getActivity(),"这是弹出式对话框测试！", AppUtils.DIALOG_COLOR_RED);
                    //这是黑框
                    DialogUIUtils.showMesDialog(getActivity(),"这是弹出式对话框测试！", AppUtils.DIALOG_COLOR_BLANK);

                }
            });

            btn_input = (Button) getActivity().findViewById(R.id.btn_input);
            btn_input.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogUIUtils.alertInputDialog(getActivity(),"这是带输入框对话框", AppUtils.DIALOG_COLOR_BLANK);
                }
            });



            btn_progress = (Button) getActivity().findViewById(R.id.btn_progress);
            btn_progress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 别忘记退出时将对话框置空。
                    Dialog progressDialog = DialogUIUtils.showLoadingDialog(getActivity(),"这是转圈的对话框");
                    progressDialog.show();
                }
            });


        }

    }