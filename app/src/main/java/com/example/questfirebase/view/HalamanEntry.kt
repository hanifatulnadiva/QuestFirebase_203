package com.example.questfirebase.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.questfirebase.view.viewmodel.EntryViewModel
import com.example.questfirebase.view.viewmodel.PenyediaViewModel
import com.example.questfirebase.R
import com.example.questfirebase.view.route.DestinasiEntry
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanEntry(
    navigateBack:()->Unit,
    modifier: Modifier= Modifier,
    viewModel: EntryViewModel= viewModel (factory = PenyediaViewModel.factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior= TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold (
        modifier=modifier.nestedScroll(
            scrollBehavior.nestedScrollConnection),
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiEntry.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        }
    ){
        isiRuang->
        EntrySiswaBody(
            uiStateSiswa=viewModel.uiStateSiswa,
            onSiswaValueChange = viewModel::updateUiState,
            onSaveClick={
                coroutineScope.launch {
                    viewModel.addSiswa()
                    navigateBack()
                }
            },
            modifier= Modifier
                .padding(isiRuang)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}