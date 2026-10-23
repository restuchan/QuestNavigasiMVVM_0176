package com.chan.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chan.myapplication.view.FormIsian
import com.chan.myapplication.view.TampilData


enum class Navigasi {
    FormulirSaya,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = Navigasi.FormulirSaya.name,

            modifier = Modifier.padding(isiRuang)){
            composable (route = Navigasi.FormulirSaya.name){
                FormIsian(
                    //PilihanJK = JenisK.map {id -> konteks.resource.getString(id) },
                    OnSubmitBtnClick = {
                        navController.navigate( Navigasi.Detail.name)
                    }
                )
            }
            composable (route = Navigasi.Detail.name){
                TampilData (
                    onBackBtnClick = {cancelAndBackToFormulirSaya(navController)}
                )
            }
        }
    }
}

private fun cancelAndBackToFormulirSaya(
    navController: NavController
) {
    navController.popBackStack(Navigasi.FormulirSaya.name, inclusive = false)
}