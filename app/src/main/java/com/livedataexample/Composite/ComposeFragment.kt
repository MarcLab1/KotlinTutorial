package com.livedataexample.Composite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.livedataexample.Animal
import com.livedataexample.AnimalRepo

class ComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var repo = AnimalRepo()
        var animals = repo.animals

        return ComposeView(requireContext()).apply {
            setContent {
                Column {
                    greeting()
                    AnimalHello("Luke")
                    AnimalCard(list = animals)
                }
            }
        }
    }

    @Composable
    @Preview
    fun greeting() {
        Column {
            Text("Name", style = TextStyle(color = Color.Black))
            Text("Type", style = TextStyle(color = Color.Blue))
            Text("Age", style = TextStyle(color = Color.Red))
        }
    }

    @Composable
    fun AnimalHello(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview
    @Composable
    fun PreviewAnimalHello(name: String = "Mackey") {
        AnimalHello(name = name + " the animal")
    }

    @Composable
    fun AnimalCard(list: ArrayList<Animal>) {
        for (i in list) {
            Row {
                Image(
                    painter = painterResource(i.imageRef),
                    contentDescription = "Contact profile picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RectangleShape)
                        .padding(2.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "${i.name.toString()} is a ${i.type.toString()} and is ${i.age.toString()} years old.",
                    style = TextStyle(
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
            }
        }
    }
}