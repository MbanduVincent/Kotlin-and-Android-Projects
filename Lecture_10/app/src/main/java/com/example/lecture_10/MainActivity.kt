package com.example.lecture_10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.lecture_10.data.AppDatabase
import com.example.lecture_10.data.User
import com.example.lecture_10.ui.theme.Lecture_10Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = AppDatabase.getDatabase(this)
        val userDao = database.userDao()

        setContent {
            Lecture_10Theme {
                val users by userDao.getUsers().collectAsState(initial = emptyList())
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserListScreen(
                        users = users,
                        onAddUser = {
                            lifecycleScope.launch {
                                // id is 0 to trigger auto-generation in Room
                                userDao.insertUser(User(name = "User ${users.size + 1}"))
                            }
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UserListScreen(
    users: List<User>,
    onAddUser: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "User List",
            style = MaterialTheme.typography.headlineMedium
        )
        Button(
            onClick = onAddUser,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text("Add User")
        }
        LazyColumn {
            items(users) { user ->
                Text(text = user.name, modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}
