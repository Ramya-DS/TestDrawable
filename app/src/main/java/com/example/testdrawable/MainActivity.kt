package com.example.testdrawable

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.graphics.Color
import android.graphics.drawable.Animatable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gym = findViewById<ImageView>(R.id.gym)
        val arrows=findViewById<ImageView>(R.id.arrows3)
        val button=findViewById<Button>(R.id.button)
        val forward=findViewById<ImageView>(R.id.forward)

       //ViewPropertyAnimator
        gym.animate().let {
                it.duration = 2000
                it.alpha(1f)
                it.rotation(45f)
            it.translationXBy(300f)
        }
        gym.setOnClickListener {
            Toast.makeText(this, "CLICKED WORKED",Toast.LENGTH_SHORT).show()
        }

        //Object Animator
        val objectAnimator=ObjectAnimator.ofFloat(button as View, "x",400f)
        objectAnimator.duration = 5000
        objectAnimator.start()


        //animated-vector
        ( arrows.drawable as Animatable)?.run { this.start() }

        //Animation-set
        var animationSet= AnimationSet(true)
        animationSet.addAnimation(AlphaAnimation(0f,1f) as Animation)
        animationSet.addAnimation(TranslateAnimation(200f,400f,200f,400f))
        animationSet.duration=2000
        animationSet.start()
        forward.animation=animationSet


    }
}