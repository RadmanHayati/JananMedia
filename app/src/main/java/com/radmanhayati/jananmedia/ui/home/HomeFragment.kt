package com.radmanhayati.jananmedia.ui.home

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.jm.HomeAdapter
import com.vipulasri.multiplebackstacknavigation.R
import com.vipulasri.multiplebackstacknavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

  private val homeViewModel: HomeViewModel by viewModels()
  private val KEY_RECYCLER_STATE = "recycler_state"
  private var mRecyclerView: RecyclerView? = null
  private var mBundleRecyclerViewState: Bundle? = null
  private var binding: FragmentHomeBinding? = null
  private fun saveState() {
    mBundleRecyclerViewState = Bundle()
    val listState: Parcelable = mRecyclerView?.layoutManager!!.onSaveInstanceState()!!
    mBundleRecyclerViewState!!.putParcelable(KEY_RECYCLER_STATE, listState)
  }


  private fun restoreState() {
    if (mBundleRecyclerViewState != null) {
      val listState: Parcelable =
        mBundleRecyclerViewState!!.getParcelable(KEY_RECYCLER_STATE)!!
      mRecyclerView!!.layoutManager!!.onRestoreInstanceState(listState)
    }
  }
  override fun onPause() {
    super.onPause()

    // save RecyclerView state
    saveState()
  }
  override fun onResume() {
    super.onResume()

    // restore RecyclerView state
    restoreState()
  }
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentHomeBinding.inflate(inflater,container , false)

    binding!!.rv.also {
      val adapterHome =  HomeAdapter(homeViewModel.loadData())
      it.layoutManager = StaggeredGridLayoutManager(3, LinearLayout.VERTICAL)
      it.setHasFixedSize(true)
      it.adapter = adapterHome

    }

    return binding!!.root


  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding?.myButton?.setOnClickListener {
      findNavController().navigate(R.id.action_first_screen)
    }

      mRecyclerView = binding!!.rv


  }

}