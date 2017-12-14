package com.example.fanxh.frameanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FrameAnimation extends AppCompatActivity implements View.OnClickListener {
    private ImageView frameAnimationImageView;
    private Button frameAnimationShow;
    private Button twwenAnimation;
    private Button animationSet;
    private Button rotateAnimation;
    private Button translateAnimation;
    private Button scaleAnimation;
    private Button objectAnimator;
    private Button propertyValuesHolder;
    private Button valueAnimator;
    private Button animatorSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        frameAnimationImageView = (ImageView) findViewById(R.id.frame_animation);
        frameAnimationImageView.setImageResource(R.drawable.frame_animation);

        //    AnimationDrawable animationDrawable = (AnimationDrawable) frameAnimation.getDrawable();
        //    animationDrawable.start();
        frameAnimationShow = (Button) findViewById(R.id.frame_animation_show);
        frameAnimationShow.setOnClickListener(this);
        twwenAnimation = (Button) findViewById(R.id.twwen_animation);
        twwenAnimation.setOnClickListener(this);
        animationSet = (Button) findViewById(R.id.animation_set);
        animationSet.setOnClickListener(this);
        rotateAnimation = (Button) findViewById(R.id.rotate_animation);
        rotateAnimation.setOnClickListener(this);
        translateAnimation = (Button) findViewById(R.id.translate_animation);
        translateAnimation.setOnClickListener(this);
        scaleAnimation = (Button) findViewById(R.id.scale_animation);
        scaleAnimation.setOnClickListener(this);
        objectAnimator = (Button) findViewById(R.id.object_animator);
        objectAnimator.setOnClickListener(this);
        propertyValuesHolder = (Button) findViewById(R.id.property_values_holder);
        propertyValuesHolder.setOnClickListener(this);
        valueAnimator = (Button) findViewById(R.id.value_animator);
        valueAnimator.setOnClickListener(this);
        animatorSet = (Button) findViewById(R.id.animator_set);
        animatorSet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frame_animation_show:
                AnimationDrawable animationDrawable = (AnimationDrawable) frameAnimationImageView.getDrawable();
                animationDrawable.start();
                break;
            case R.id.twwen_animation:
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                //动画持续时间
                alphaAnimation.setDuration(5000);
                //动画结束时保留状态
                alphaAnimation.setFillAfter(false);
                //设置插值器
                alphaAnimation.setInterpolator(new LinearInterpolator());
                //开启动画
                frameAnimationImageView.startAnimation(alphaAnimation);
                break;
            case R.id.animation_set:
                AlphaAnimation alphaAnimation1 = new AlphaAnimation(1, 1 / 2);
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360);
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 300);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 2f, 0f, 2f);

                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setDuration(5000);
                animationSet.addAnimation(alphaAnimation1);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);
                frameAnimationImageView.startAnimation(animationSet);
                break;
            case R.id.rotate_animation:
                RotateAnimation rotateAnimation1 = new RotateAnimation(0, 360);
                rotateAnimation1.setDuration(2000);
                frameAnimationImageView.startAnimation(rotateAnimation1);
                rotateAnimation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        frameAnimationImageView.setImageResource(R.drawable.frame_animation1);
                        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0f, 2f, 0f, 2f);
                        scaleAnimation2.setDuration(1000);
                        frameAnimationImageView.startAnimation(scaleAnimation2);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        frameAnimationImageView.setImageResource(R.drawable.frame_animation3);
                        TranslateAnimation translateAnimation1 = new TranslateAnimation(0, 200, 0, 300);
                        translateAnimation1.setDuration(1000);
                        frameAnimationImageView.startAnimation(translateAnimation1);
                        Toast.makeText(FrameAnimation.this, "动画结束", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            case R.id.translate_animation:
                TranslateAnimation translateAnimation1 = new TranslateAnimation(0, 200, 0, 300);
                translateAnimation1.setDuration(5000);
                translateAnimation1.setFillAfter(true);
                frameAnimationImageView.startAnimation(translateAnimation1);
                break;
            case R.id.scale_animation:
                ScaleAnimation scaleAnimation1 = new ScaleAnimation(0f, 2f, 0f, 2f);
                scaleAnimation1.setDuration(5000);
                frameAnimationImageView.startAnimation(scaleAnimation1);
                break;
            case R.id.object_animator:
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(frameAnimationImageView, "translationX", -300, 300);
                objectAnimator.setDuration(2000);
       //         objectAnimator.getTranslationX()
                // 设置播放次数。如果为ValueAnimator.INFINITE表示无限播放下去
                objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
                // 设置播放重复模式。RESTART表示重新开始动画，REVERSE表示动画反过来播放。
                objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
                objectAnimator.start();
                Toast.makeText(FrameAnimation.this, "完成动画", Toast.LENGTH_SHORT).show();
                break;
            case R.id.property_values_holder:
                PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX",200f);
                PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX",1f,0f,2f);
                PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY",1f,2f,1f);
                ObjectAnimator.ofPropertyValuesHolder(frameAnimationImageView,pvh1,pvh2,pvh3).setDuration(2000).start();
            case R.id.value_animator:
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,100);
                valueAnimator.setTarget(frameAnimationImageView);
                valueAnimator.setDuration(2000);
                valueAnimator.start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Float value = (Float) animation.getAnimatedValue();
                        Log.d("*****","The value of Float is"+value);
                        // TODO 使用获取来的值
                    }
                });
                break;
            case R.id.animator_set:
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(frameAnimationImageView,"translationX",200f);
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(frameAnimationImageView,"scaleX",1f,0f,1f);
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(frameAnimationImageView,"scaleY",1f,0f,1f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(2000);
                animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3);
                animatorSet.start();
                break;

            default:
                break;
        }

    }
}
