package com.example.constrainset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

public class MainActivity extends AppCompatActivity {

    Boolean isShown = false;

    ConstraintLayout layout;
    ConstraintSet constraintSetShow = new ConstraintSet();
    ConstraintSet constraintSetHide = new ConstraintSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        constraintSetHide.clone(layout);
        constraintSetShow.clone(this, R.layout.activity_main_detail);
    }

    public void toggleDetail(View view) {

        /* Use this if you want to specify the type of animation interpolator*/
        Transition transition = new ChangeBounds();
        transition.setInterpolator(new AccelerateDecelerateInterpolator());
        TransitionManager.beginDelayedTransition(layout, transition);

       /* Use this below if you want the Linear default animation*/
//        TransitionManager.beginDelayedTransition(layout);

        if (isShown) {
            //hide detail
            constraintSetHide.applyTo(layout);
        } else {
            //Show Detail
            constraintSetShow.applyTo(layout);
        }
        isShown = !isShown;
    }
}
