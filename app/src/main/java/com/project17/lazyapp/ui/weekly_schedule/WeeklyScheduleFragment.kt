package com.project17.lazyapp.ui.weekly_schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project17.lazyapp.databinding.FragmentWeeklyScheduleBinding

class WeeklyScheduleFragment : Fragment() {

    private var _binding: FragmentWeeklyScheduleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val weeklyScheduleViewModel =
            ViewModelProvider(this)[WeeklyScheduleViewModel::class.java]

        _binding = FragmentWeeklyScheduleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        weeklyScheduleViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}