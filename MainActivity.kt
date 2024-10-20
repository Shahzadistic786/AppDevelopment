package com.example.grocerapp_new

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.grocerapp_new.ui.theme.GrocerApp_newTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GrocerApp_newTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        HeaderWithSearch()
                        ImageCarousel()
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderWithSearch(modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Hamburger menu icon
        IconButton(onClick = { /* Handle hamburger menu click */ }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu"
            )
        }

        // Search field
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text("Search") },
            modifier = Modifier
                .weight(1f) // Take up remaining space
                .padding(horizontal = 8.dp)
        )

        // Add to cart icon
        IconButton(onClick = { /* Handle add to cart click */ }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart"
            )
        }
    }
}

@Composable
fun ImageCarousel() {
    // Sample online image URLs
    val imageList = listOf(
        "https://via.placeholder.com/200/FF0000/FFFFFF?text=Image+1", // Example red image
        "https://via.placeholder.com/200/00FF00/FFFFFF?text=Image+2", // Example green image
        "https://via.placeholder.com/200/0000FF/FFFFFF?text=Image+3", // Example blue image
        "https://via.placeholder.com/200/FFFF00/FFFFFF?text=Image+4"  // Example yellow image
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imageList.size) { index ->
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .width(200.dp)
                    .height(150.dp)
            ) {
                Image(
                    painter = rememberImagePainter(imageList[index]),
                    contentDescription = "Carousel Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    GrocerApp_newTheme {
        Column {
            HeaderWithSearch()
            ImageCarousel()
        }
    }
}
