package com.biptek.posbiptek;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.biptek.posbiptek.fragment.Fragment_SignUp;
import com.biptek.posbiptek.fragment.Fragment_SignUp_Toko;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;


    public PagerAdapter(FragmentManager fm, int mNoOfTabs) {
        super(fm);
        this.mNoOfTabs = mNoOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                Fragment_SignUp fragmentSignUpPerusahaan = new Fragment_SignUp();
                return fragmentSignUpPerusahaan;
            case 1:
                Fragment_SignUp_Toko fragment_signUp_toko = new Fragment_SignUp_Toko();
                return fragment_signUp_toko;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
