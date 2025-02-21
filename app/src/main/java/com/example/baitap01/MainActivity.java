package com.example.baitap01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtSoN;
    private Button btnRnd;
    private RelativeLayout mainLayout;
    private Switch switchBackground;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtSoN = (TextView) findViewById(R.id.textViewSo);
        btnRnd = (Button) findViewById(R.id.buttonRnd);

        mainLayout = findViewById(R.id.mainLayout);
        switchBackground = findViewById(R.id.switchBackground);

        RandomNumber();
        RandomBackground();
        UseControlSwitch();
    }

    void RandomNumber() {
        btnRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int number = random.nextInt(10);
                txtSoN.setText(number + "");
            }
        });
    }

    void RandomBackground() {
        int[] backgrounds = {
                R.drawable.bg1,
                R.drawable.bg2,
                R.drawable.bg3
        };

        Random random = new Random();
        int randomBackground = backgrounds[random.nextInt(backgrounds.length)];

        mainLayout.setBackgroundResource(randomBackground);
    }

    void UseControlSwitch() {
        // Lắng nghe sự kiện của Switch
        switchBackground.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Nếu bật switch, đổi hình nền
                mainLayout.setBackgroundResource(R.drawable.bg1);
            } else {
                // Nếu tắt switch, đổi hình nền khác
                mainLayout.setBackgroundResource(R.drawable.bg2);
            }
        });
    }
}