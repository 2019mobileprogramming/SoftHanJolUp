package o1.mobile.softhanjolup.Init;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import o1.mobile.softhanjolup.MainActivity;
import o1.mobile.softhanjolup.R;

public class info_first_j extends AppCompatActivity {
    ImageView imageView;
    ArrayList<Integer> images = new ArrayList<Integer>();
    RelativeLayout frame;
    int curImage = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_first_x);

        imageView = findViewById(R.id.init_image1);
        frame = findViewById(R.id.init_layout);


        images.add(R.drawable.start1);
        images.add(R.drawable.start2);
        images.add(R.drawable.start3);
        images.add(R.drawable.start4);
        images.add(R.drawable.start5);
        images.add(R.drawable.start6);

        imageView.setImageResource(images.get(curImage));

        frame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(curImage == 5){
                    Intent intent = new Intent(info_first_j.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    curImage += 1;
                    imageView.setImageResource(images.get(curImage));
                }
                return false;
            }
        });

    }
}
