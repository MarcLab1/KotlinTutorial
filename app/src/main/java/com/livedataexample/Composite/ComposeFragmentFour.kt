package com.livedataexample.Composite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.livedataexample.Animal
import com.livedataexample.AnimalRepo
import com.livedataexample.MainViewModel


class ComposeFragmentFour : Fragment() {

    lateinit var animals: ArrayList<Animal>
    lateinit var viewModel: MainViewModel
    var number : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        animals = AnimalRepo().animals
        return ComposeView(requireContext()).apply {
            setContent {

                printAnimals(animals)

                viewModel = MainViewModel()
                val numberObserver = Observer<Int> { newInt ->
                    doSomething()
                }
                viewModel.number.observe(viewLifecycleOwner, numberObserver)

            }
        }
    }

    fun doSomething()
    {
        Toast.makeText(context, viewModel.number.value.toString(), Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun printAnimals(animals: ArrayList<Animal>) {

        LazyColumn() {
            item(animals.size) {  //LazyColumn does not provide composable content, so we wrap it inside an Item
                for (animal in animals) {
                    animalRow(animal = animal)
                }
            }
        }
    }

    @Composable
    fun animalRow(animal: Animal) {
        Divider(color = Color.Gray, thickness = 0.5.dp)
        Card(
            shape = RectangleShape,
            modifier = Modifier.clickable(onClick = { clicked(animal = animal) })
            //modifier = Modifier.clickable(onClick = { Toast.makeText(context, animal.name.toString(), Toast.LENGTH_SHORT).show()} )
            //onClick = { Toast.makeText(context, animal.name.toString(), Toast.LENGTH_SHORT).show()}  Experimental
        )
        {

            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(animal.imageRef),
                    contentDescription = "my pic",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Red, CircleShape)
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Text(
                        text = animal.name,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(5.dp)

                    )
                    Row()
                    {
                        Text(
                            text = "Type: " + animal.type,
                            style = TextStyle(fontWeight = FontWeight.Black),
                            fontSize = 14.sp,
                            modifier = Modifier.padding(end = 10.dp) //could have used a spacer but whatever
                        )
                        Text(
                            text = "Age: " + animal.age.toString(),
                            style = TextStyle(fontWeight = FontWeight.Black),
                            fontSize = 14.sp
                        )
                    }
                    Row()
                    {
                        Text(
                            text = "Color: " + animal.color,
                            style = TextStyle(fontWeight = FontWeight.Black),
                            fontSize = 14.sp,
                            modifier = Modifier.padding(end = 10.dp) //could have used a spacer but whatever
                        )
                        Text(
                            text = "Pattern: " + animal.pattern,
                            style = TextStyle(fontWeight = FontWeight.Black),
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }

    fun clicked(animal: Animal) {
        //Toast.makeText(context, animal.name, Toast.LENGTH_SHORT).show()
        viewModel.number.value = animal.age
    }
}


