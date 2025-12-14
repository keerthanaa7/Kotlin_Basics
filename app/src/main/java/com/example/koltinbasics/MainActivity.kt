package com.example.koltinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.koltinbasics.ui.theme.KoltinBasicsTheme

class MainActivity : ComponentActivity() {
    companion object{
        val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoltinBasicsTheme {
                val userlist = listOf<User>(User(11, "user1", 30),
                    User(2, "user2", 40),
                    User(1, "user3", 30))
                val agecomparator = Comparator<User>{ user, user1 ->
                    user.age.compareTo(user1.age)
                }
                val sortedlist = userlist.sortedWith(agecomparator)
                for(user in sortedlist){
                    Log.d(TAG, "user ${user}")
                }
                val studentscorelist = listOf<StudentScore>(StudentScore("student1" , 1),
                    StudentScore("student2", 2),
                    StudentScore("student3", 3),
                    StudentScore("student4", 4),
                    StudentScore("student5", 5),
                    StudentScore("student6", 6)
                    )

                val (validlist, invalidlist) = sortedlist.partition { user -> user.id > 2 }
                validlist.forEach { user -> Log.d(TAG, " valid USER ${user}") }
                invalidlist.forEach { user -> Log.d(TAG, "invalid USER ${user}") }
                val mainViewModel: MainViewModel = MainViewModel()
              //  mainViewModel.refreshDashboard()
                mainViewModel.timeoutexample()
                mainViewModel.loaddata()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoltinBasicsTheme {
        Greeting("Android")
    }
}