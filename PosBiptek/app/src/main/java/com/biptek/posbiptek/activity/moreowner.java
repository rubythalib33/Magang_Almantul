package com.biptek.posbiptek.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.biptek.posbiptek.R;

public class moreowner extends AppCompatActivity {
    ImageButton logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_kasirowner);

        logout = (ImageButton)findViewById(R.id.LogoutButtonowner);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(new Intent(moreowner.this, homeowner.class));
            }
        });
    }
}
