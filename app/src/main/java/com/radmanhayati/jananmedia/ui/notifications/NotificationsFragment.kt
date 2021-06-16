package com.radmanhayati.jananmedia.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.vipulasri.multiplebackstacknavigation.R

class NotificationsFragment : Fragment() {

  private val notificationsViewModel: NotificationsViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_notifications, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val textView: TextView = view.findViewById(R.id.text_notifications)
    val button: Button = view.findViewById(R.id.button)

    button.setOnClickListener {
      findNavController().navigate(R.id.action_first_screen)
    }

    notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })

  }
}