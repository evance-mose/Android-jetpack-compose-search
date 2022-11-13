package org.dtree.exercise.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.dtree.exercise.domain.model.UserModel

@Composable
fun UserItem(user: UserModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
            elevation = 10.dp) {
                Column(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = "Name : ${user.name} ${user.surname}")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Age : ${user.age}")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "City : ${user.city}")
                }
            }
}