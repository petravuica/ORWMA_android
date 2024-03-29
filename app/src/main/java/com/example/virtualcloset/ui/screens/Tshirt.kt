package com.example.virtualcloset.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.virtualcloset.R

@Composable
fun Tshirt(
    navController: NavController,
    clothingViewModel: ClothingViewModel
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.purple)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Title(textValue = "T-shirt")
            Spacer(modifier = Modifier.size(10.dp))
            TopBar(navController)

            DisposableEffect(Unit) {
                clothingViewModel.getClothesFromFirestore(type = "T-shirt")
                onDispose { }
            }

            // Prikaz liste odjeće
           ClothingListScreen(clothingViewModel)

        }

    }

}

