package com.example.hungertreats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungertreats.Adapter.NotificationAdapter
import com.example.hungertreats.databinding.FragmentNotificationBottomFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class notification_bottom_fragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentNotificationBottomFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomFragmentBinding.inflate(layoutInflater,container,false)
        val notifications = listOf("Your order has been cancelled successfully" , "Order has been taken by the driver" , "Congrats your order placed")
        val notificationImages = listOf(R.drawable.sademoji,R.drawable.truck,R.drawable.congratulations)
        val adapter = NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationImages)
        )
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            notification_bottom_fragment().apply {

            }
    }
}