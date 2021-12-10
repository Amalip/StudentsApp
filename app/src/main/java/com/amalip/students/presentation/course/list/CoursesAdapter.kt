package com.amalip.students.presentation.course.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amalip.students.databinding.CourseRowBinding
import com.amalip.students.domain.model.Course

/**
 * Created by Amalip on 9/28/2021.
 */

@SuppressLint("NotifyDataSetChanged")
class CoursesAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Course> = mutableListOf()
    private lateinit var listener: (course: Course) -> Unit

    fun addData(list: List<Course>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    fun setListener(listener: (Course) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItem(
        CourseRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as ViewHolderItem).bind(list[position], listener)

    override fun getItemCount() = list.size

    class ViewHolderItem(private val binding: CourseRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Course, listener: (course: Course) -> Unit) {
            binding.apply {
                course = data
                row.setOnClickListener { listener(data) }
            }
        }
    }

}