package com.radmanhayati.jananmedia.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.kotlinx.mytask.UserModel

class HomeViewModel : ViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "This is home Fragment"
  }
  val data: LiveData<String> = _text

  fun loadData() : MutableList<UserModel>{

    var userModel : MutableList<UserModel> = mutableListOf(UserModel(1 , ""))
    for (i in 0..99)
    {
      userModel.add(UserModel(id = i , name = "User $i"))
    }
    return userModel
  }
}