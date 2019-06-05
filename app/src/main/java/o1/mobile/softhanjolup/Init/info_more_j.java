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

public class info_more_j extends AppCompatActivity {
    ImageView imageView;
    ArrayList<Integer> images = new ArrayList<Integer>();
    RelativeLayout frame;
    int curImage = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_first_x);

        imageView = findViewById(R.id.init_image1);
        frame = findViewById(R.id.init_layout);

        images.add(R.drawable.basic11);
        images.add(R.drawable.basic1);
        images.add(R.drawable.basic2);
        images.add(R.drawable.basic3);
        images.add(R.drawable.basic4);
        images.add(R.drawable.basic5);
        images.add(R.drawable.basic6);
        images.add(R.drawable.basic7);
        images.add(R.drawable.basic8);
        images.add(R.drawable.basic9);
        images.add(R.drawable.basic10);

        imageView.setImageResource(images.get(curImage));

        frame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(curImage == 10){
                    Intent intent = new Intent(info_more_j.this, MainActivity.class);
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
