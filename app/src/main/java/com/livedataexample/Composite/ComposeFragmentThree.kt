package com.livedataexample.Composite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.livedataexample.Animal
import com.livedataexample.AnimalRepo
import com.livedataexample.MainViewModel
import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale

class ComposeFragmentThree : Fragment() {

    var num: Int = -1
    lateinit var animals: ArrayList<Animal>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        num = MainViewModel().number.value!!
        animals = AnimalRepo().animals

        return ComposeView(requireContext()).apply {
            setContent {
                LazyColumn() {

                    item {
                        boxLayout()
                    }
                    item {
                        Spacer(modifier = Modifier.size(10.dp))
                    }
                    item {
                        flowRowLayout()
                    }
                    item {
                        Spacer(modifier = Modifier.size(10.dp))
                    }
                }
            }
        }
    }

    @Composable
    fun greeting(name: String) {
        Text("Hello $name")
    }


    @Composable
    fun flowRowLayout() {
        FlowRow(
            mainAxisAlignment = MainAxisAlignment.Center,
            crossAxisSpacing = 12.dp,
            mainAxisSpacing = 8.dp
        ) {
            animals.forEach { animal ->
                Column() {
                }
                Text(
                    text = animal.name,
                    modifier = Modifier
                        .padding(8.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.size(10.dp))
                Image(
                    painter = painterResource(animal.imageRef),
                    contentDescription = "my pic",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Red, CircleShape)
                )
            }
        }
    }


    @Composable
    fun boxLayout() {
        Box {
            Box(
                modifier = Modifier
                    .size(height = 200.dp, width = 200.dp)
                    .background(Color.Red)
            )
            {
                //Text(text = num.toString(), Modifier.align(alignment = Alignment.Center))
                Box(
                    modifier = Modifier
                        .size(height = 50.dp, width = 50.dp)
                        .background(Color.Cyan)
                        .align(alignment = Alignment.TopEnd)
                )
                Box(
                    modifier = Modifier
                        .size(height = 50.dp, width = 50.dp)
                        .background(Color.Blue)
                        .align(alignment = Alignment.TopStart)
                )
            }
        }

    }
}