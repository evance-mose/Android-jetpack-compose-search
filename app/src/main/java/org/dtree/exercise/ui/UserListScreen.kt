package org.dtree.exercise.ui
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UserListScreen(
    viewModel: UserListViewModel = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()
    val users = viewModel.state.collectAsState(initial = UserState())
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                    TextField(
                        value = searchQuery,
                        onValueChange = {
                            searchQuery = it
                            viewModel.searchQuery.value = searchQuery
                        },
                        modifier = Modifier.fillMaxWidth().padding(2.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = Color.White,
                            textColor = Color.White
                        ),
                        placeholder = {
                            Text(text = "Filter by City", color = Color.Gray)
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                tint = Color.White,
                                contentDescription = "Search",
                            )
                        }
                    )

                }

            }
        }
    ){
        LazyColumn {
            items(users.value.data) { user ->
                UserItem(user)
                Log.e("TAG", "UserListScreen:"+user )
            }
        }
    }
    }