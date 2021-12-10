package com.amalip.students.presentation.course.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.amalip.students.R
import com.amalip.students.core.extension.failure
import com.amalip.students.core.extension.observe
import com.amalip.students.core.presentation.BaseFragment
import com.amalip.students.core.presentation.BaseViewState
import com.amalip.students.databinding.CourseDetailFragmentBinding
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class CourseDetailFragment : BaseFragment(R.layout.course_detail_fragment) {

    private lateinit var binding: CourseDetailFragmentBinding

    private val courseDetailViewModel by viewModels<CourseDetailViewModel>()
    private val args: CourseDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        courseDetailViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {

        }
    }

    override fun setBinding(view: View) {
        binding = CourseDetailFragmentBinding.bind(view)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.apply {
            course = args.course
        }

        setScheduleList()
        setGrades()

        baseActivity.setBottomNavVisibility(View.GONE)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setScheduleList() = binding.apply {
        chgSchedules.removeAllViews()
        args.course.scheduleList.forEach {
            chgSchedules.addView(Chip(context).apply {
                text = it
                chipIcon = resources.getDrawable(R.drawable.ic_clock, null)
            })
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setGrades() = binding.apply {
        chgGrades.removeAllViews()
        args.course.grades.forEachIndexed { index, grade ->
            chgGrades.addView(Chip(context).apply {
                text = getString(
                    when (index) {
                        0 -> R.string.text_grade_1
                        1 -> R.string.text_grade_2
                        else -> R.string.text_grade_3
                    }, grade
                )
                chipIcon = resources.getDrawable(R.drawable.ic_grades, null)
            })
        }
    }


}