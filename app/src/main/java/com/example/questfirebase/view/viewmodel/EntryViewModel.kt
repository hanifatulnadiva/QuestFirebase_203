package com.example.questfirebase.view.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.questfirebase.modeldata.UIStateSiswa
import com.example.questfirebase.repositori.RepositorySiswa

class EntryViewModel(private  val repositorySiswa: RepositorySiswa): ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set


}