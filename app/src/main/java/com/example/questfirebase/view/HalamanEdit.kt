package com.example.questfirebase.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.questfirebase.view.route.DestinasiUpdate
import com.example.questfirebase.view.viewmodel.EditViewModel
import com.example.questfirebase.view.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanEdit(
    navigationBack:()-> Unit,
    onNavigateUp:()->Unit,
    modifier:Modifier= Modifier,
    viewModel: EditViewModel= viewModel(factory = PenyediaViewModel.factory)

) {
    Scaffold (
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiUpdate.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ){
        innerPadding->
        val corountineScope= rememberCoroutineScope ()
        EntrySiswaBody(
            uiStateSiswa = viewModel.uiStateSiswa,
            onSiswaValueChange = viewModel::updateUiState,
            onSaveClick = {
                corountineScope.launch {
                    viewModel.editSatuSiswa()
                    navigationBack()
                }
            },
            modifier= Modifier.padding(innerPadding)
        )
    }

}