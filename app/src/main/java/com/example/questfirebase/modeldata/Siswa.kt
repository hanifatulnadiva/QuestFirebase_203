package com.example.questfirebase.modeldata

data class Siswa (
    val id:Long = 0,
    val nama:String="",
    val alamat:String="",
    val telpon: String=""
)

data class DetailSiswa(
    val id: Long=0,
    val nama: String="",
    val alamat: String="",
    val telpon: String=""
)

data class UIStateSiswa(
    val detailSiswa: DetailSiswa= DetailSiswa(),
    val isEntryValid: Boolean= false
)

fun DetailSiswa.toDataSiswa(): Siswa= Siswa(id, nama, alamat, telpon)
fun Siswa.toDetailSiswa(): DetailSiswa= DetailSiswa(id,  nama, alamat, telpon)
fun Siswa.toUIStateSiswa(isEntryValid: Boolean=false): UIStateSiswa= UIStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid= isEntryValid
)