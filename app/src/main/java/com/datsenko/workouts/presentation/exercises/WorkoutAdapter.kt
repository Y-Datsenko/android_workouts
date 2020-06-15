package com.datsenko.workouts.presentation.exercises

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.datsenko.domain.Workout
import com.datsenko.workouts.R

class WorkoutAdapter(private val workouts: List<Workout> = listOf()) : RecyclerView.Adapter<WorkoutAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_workout, parent, false)
        return Holder(view)
    }

    override fun getItemCount() = workouts.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(workouts[position])
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.findViewById(R.id.workout_title)
        private val image: ImageView = view.findViewById(R.id.workout_image)

        fun bind(item: Workout) {
            title.text = item.title
            Glide.with(image).load(item.imageUrl).into(image)
        }
    }
}