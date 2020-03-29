package com.datsenko.workouts.presentation

import android.os.Bundle
import com.datsenko.workouts.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val workouts = buildList {
//            add(Workout(title = "PUSH-UP", imageUrl = ""))
//            add(Workout(title = "BODYWEIGHT SQUAT", imageUrl = ""))
//            add(Workout(title = "PLANK", imageUrl = ""))
//            add(Workout(title = "Side PLANK", imageUrl = ""))
//            add(Workout(title = "WALKING JACKS (if you can’t do jumping jacks) : ", imageUrl = "https://www.nerdfitness.com/wp-content/uploads/2019/06/walking-jacks-bodyweight-exercise.gif"))
//            add(Workout(title = "HIP BRIDGE", imageUrl = "https://www.nerdfitness.com/wp-content/uploads/2019/08/hip-bridge.gif"))
//            add(Workout(title = "BURPEES Стоїш, присів, упор лежачи, присів, встав", imageUrl = ""))
//            add(Workout(title = "REVERSE CRUNCH", imageUrl = "https://www.nerdfitness.com/wp-content/uploads/2019/08/reverse-crunch.gif"))
//            add(Workout(title = "SIDE-TO-SIDE PUSH-UP", imageUrl = "https://www.nerdfitness.com/wp-content/uploads/2019/08/side-to-side-push-up.gif"))
//            add(Workout(title = "", imageUrl = ""))
//        }
//        val workoutsRv = findViewById<RecyclerView>(R.id.workouts_rv)
//        val adapter = WorkoutAdapter(workouts)
//        workoutsRv.adapter = adapter
    }
}