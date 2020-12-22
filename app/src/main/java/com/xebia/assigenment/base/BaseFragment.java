/*
 *  Created by Surajit Deka on 25/6/19 12:38 PM
 *  Copyright (c) Letstrack 2019 . All rights reserved.
 *  Last modified 7/5/19 5:46 PM
 *
 */

package com.xebia.assigenment.base;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public abstract class BaseFragment extends Fragment {


    protected Activity activity;


    @Override
    public void onViewCreated(@androidx.annotation.NonNull android.view.View view,
                              @androidx.annotation.Nullable android.os.Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onActivityCreated(@androidx.annotation.Nullable android.os.Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
