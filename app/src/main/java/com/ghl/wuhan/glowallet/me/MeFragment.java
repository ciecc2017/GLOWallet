package com.ghl.wuhan.glowallet.me;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghl.wuhan.glowallet.R;

/**
 * 项目名称：GLOWallet
 * 类描叙：MeFragment
 * 创建人：chenmin
 * 创建时间： 2017-12-12 15:30：20
 * 修改人：chenmin
 * 修改时间： 2017-12-12 15:30：20
 * 修改备注：
 * 版本：
 */
public class MeFragment extends Fragment {


    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_me, container, false);
    }

}
