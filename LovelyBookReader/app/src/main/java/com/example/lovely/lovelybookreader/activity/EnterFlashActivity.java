package com.example.lovely.lovelybookreader.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lovely.lovelybookreader.MainActivity;
import com.example.lovely.lovelybookreader.R;

/**
 * Created by lovely on 16/10/20.
 */

public class EnterFlashActivity extends Activity{

    public View flashImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.book_flash_view);
        setView();
    }

    private void setView() {
        flashImage = findViewById(R.id.book_flash_image);
        startAnimation(flashImage);
    }

    private void startAnimation(View view) {
        Animator animator = ObjectAnimator.ofFloat(view,View.ALPHA,0f,1f);
        animator.setDuration(4000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                enterHomeActivity();
            }
        });
        animator.start();
    }

    private void enterHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
