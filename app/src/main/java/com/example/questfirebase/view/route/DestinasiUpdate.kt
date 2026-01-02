package com.example.questfirebase.view.route

import com.example.questfirebase.R
object DestinasiUpdate : DestinasiNavigasi {
    override val route ="update_siswa"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg="idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}