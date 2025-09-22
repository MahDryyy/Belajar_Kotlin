package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack // Changed to auto-mirrored
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


data class Makanan(val id: Int, val name: String, val description: String)


val dummyMakananList = listOf(
    Makanan(1, "Nasi Goreng", "Nasi goreng spesial dengan telur dan ayam"),
    Makanan(2, "Mie Ayam", "Mie ayam dengan pangsit dan bakso"),
    Makanan(3, "Sate Ayam", "Sate ayam 10 tusuk dengan bumbu kacang"),
    Makanan(4, "Gado-gado", "Sayuran segar dengan bumbu kacang"),
    Makanan(5, "Soto Ayam", "Soto ayam kuah kuning dengan soun dan telur"),
    Makanan(6, "Bakso", "Bakso sapi dengan mie dan tahu"),
    Makanan(7, "Rendang", "Daging sapi bumbu rendang khas Padang")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListMakananPage(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Daftar Makanan") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Used auto-mirrored icon
                            contentDescription = "Kembali"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Apply padding from Scaffold
                .padding(16.dp), // Additional padding for content
            verticalArrangement = Arrangement.spacedBy(8.dp) // Spacing between items
        ) {
            items(dummyMakananList) { makanan ->
                MakananItem(makanan = makanan)
            }
        }
    }
}


@Composable
fun MakananItem(makanan: Makanan) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = makanan.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = makanan.description, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}
