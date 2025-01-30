package com.example.tugas2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas2.ui.theme.Tugas2Theme


data class Student(
    val name: String,
    val fromClass: String,
    val favProgramminglan: String,
)

val students = listOf(
    Student("Balbino", "IF-47-INT", "Kotlin"),
    Student("Budi", "IF-47-03", "Java"),
    Student("Caca", "IF-47-11", "Python"),
    Student("Dedi", "IF-47-12", "C++"),
    Student("Eko", "IF-47-06", "C#"),
    Student("Fajar", "IF-47-10", "Ruby"),
    Student("Gina", "IF-47-09", "Javascript"),
    Student("Hadi", "IF-47-08", "PHP"),
    Student("Ika", "IF-47-07", "Swift"),
    Student("Joko", "IF-47-05", "Rust"),
    Student("Kiki", "IF-47-04", "Go"),
    Student("Lala", "IF-47-02", "Dart"),
    Student("Maman", "IF-47-01", "Kotlin"),
    Student("Nana", "IF-47-INT", "Swift"),
    Student("Oscar", "IF-47-03", "Assembly"),
    Student("Pipin", "IF-47-11", "Haskell"),
    Student("Qiqi", "IF-47-12", "Python"),
    Student("Rara", "IF-47-06", "Matlab"),
    Student("Susi", "IF-47-10", "Prolog"),
    Student("Tuti", "IF-47-09", "Go"),
    Student("Udin", "IF-47-08", "Swift"),
    Student("Vivi", "IF-47-07", "Dart"),
    Student("Wawan", "IF-47-05", "Kotlin"),
    Student("Xena", "IF-47-04", "PHP"),
    Student("Yoga", "IF-47-02", "Pascal"),
    Student("Zara", "IF-47-01", "Assembly"),

)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize() ,
                    topBar = {
                        TopAppBar(
                            modifier = Modifier.padding(top = 16.dp),
                            title = {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center,
                                ){
                                    Text(
                                        text = "Students List"
                                    )
                                }
                            },
                            colors= TopAppBarDefaults.mediumTopAppBarColors(
                                containerColor = Color(0xFFADD8E6),
                                titleContentColor = Color.Black,
                            )
                        )
                    }
                )
                { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        StudentList(students)
                    }
                }
            }
        }
    }

}

@Composable
fun StudentCard(students: Student, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFADD8E6))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
        ) {
            Text(text = "Name: ${students.name}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Class: ${students.fromClass}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Language: ${students.favProgramminglan}", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun StudentList(students: List<Student>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(students) { student ->
            StudentCard(
                student,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }

}