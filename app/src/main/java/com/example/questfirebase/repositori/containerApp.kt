package com.example.questfirebase.repositori

import android.app.Application

interface ContainerApp {
    val repositorySiswa: RepositorySiswa
}

class DefaultContainerApp : ContainerApp{
    override val repositorySiswa: RepositorySiswa by lazy {
        FirebaseRepositorySiswa()
    }
}

class AplikasiDataSiswa: Application(){
    lateinit var contaiiner: ContainerApp
    override fun onCreate() {
        super.onCreate()
        this.contaiiner= DefaultContainerApp()
    }
}