package com.example.questfirebase.view.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.questfirebase.modeldata.Siswa
import com.example.questfirebase.repositori.RepositorySiswa
import com.example.questfirebase.view.route.DestinasiDetail
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface StatusUIDetail{
    data class Success(val satusiswa: Siswa?):StatusUIDetail
    object Error: StatusUIDetail
    object Loading: StatusUIDetail
}
class DetailViewModel (savedStateHandle: SavedStateHandle, private  val repositorySiswa: RepositorySiswa):
    ViewModel() {
    private val idSiswa: Long =
        savedStateHandle.get<String>(DestinasiDetail.itemIdArg)?.toLong()
            ?: error("id siswa tidak ditemukan di SavedStateHandle")

    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa(){
        viewModelScope.launch {
            statusUIDetail= StatusUIDetail.Loading
            statusUIDetail=try{
                StatusUIDetail.Success(satusiswa = repositorySiswa
                    .getSatuSiswa(idSiswa))
            }
            catch (e: IOException){
                StatusUIDetail.Error
            }
            catch (e: Exception){
                StatusUIDetail.Error
            }
        }
    }

}