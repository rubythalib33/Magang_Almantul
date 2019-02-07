//package com.biptek.posbiptek;
//
//import android.content.Context;
//import android.view.View;
//import android.widget.PopupMenu;
//import android.widget.Switch;
//import android.widget.Toast;
//import android.database.sqlite.SQLiteDatabase;
//import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.TextView;
//
//import com.biptek.posbiptek.model.*;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public abstract class more extends Context implements android.support.v7.widget.PopupMenu.OnMenuItemClickListener {
//    public void ShowSetting(View v) {
//        PopupMenu popup = new PopupMenu(this, v);
//        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
//        popup.inflate(R.menu.settingmenu);
//        popup.show();
//    }
//
//    @Override
//    public boolean onMenuItemClick(MenuItem menuItem) {
//        switch (menuItem.getItemId()) {
//            case R.id.ManajemenToko:
//                Toast.makeText(this, "Pengaturan Toko", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.ManajemenUser:
//                Toast.makeText(this, "Pengaturan User", Toast.LENGTH_SHORT).show();
//                return true;
//
//        }
//    }
//}