package com.example.showusers.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter

@Composable
fun UsersListScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "All Users",
            modifier = Modifier
                .padding(16.dp),
            style = TextStyle(fontSize = 30.sp)


        )

        UserList()
    }
}

@Composable
fun UserList(){
    val viewModel:UserListViewModel = hiltViewModel()
    val userList by viewModel.allUsers.collectAsState()


    val testList = listOf("cat", "dog", "tiger", "lion")

 LazyColumn {
     items(userList?: emptyList()){ element->
         Card (
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(16.dp)
         ) {

             Column(
                 modifier = Modifier
                     .fillMaxWidth(),
                 horizontalAlignment = Alignment.CenterHorizontally

             ) {
                 Text(
                     modifier = Modifier.padding(16.dp),
                     text = "Name: ${element?.firstName} ${element?.lastName}"
                 )

                 Text(
                     modifier = Modifier.padding(16.dp),
                     text = "Email: ${element?.email}"
                 )

                 Image(
                     painter = rememberImagePainter(data = "${element?.avatar}"),
                     contentDescription = "Image from URL",
                     modifier = Modifier
                         .size(128.dp)
                         .padding(bottom = 8.dp)
                 )



             }
         }
     }
 }

}


@Composable
@Preview(showBackground = true)
fun PreviewUsersListScreen(){
    UsersListScreen()
}