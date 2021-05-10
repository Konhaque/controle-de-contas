package com.controledecontas.functionalities;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class SetFragment {

    public SetFragment(@NonNull FragmentManager manager, @NonNull Fragment fragment, int id){
        manager.beginTransaction().setCustomAnimations(android.R.anim.accelerate_interpolator, android.R.anim.anticipate_interpolator)
                .replace(id,fragment).commit();

    }
}
