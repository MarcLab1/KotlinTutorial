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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.livedataexample.R

class ComposeFragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return ComposeView(requireContext()).apply {
            setContent {
                LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight())
                {
                    item {
                        rowsAndCols()
                    }

                    item {
                        images()
                    }
                    item {

                        buttons()
                    }
                }
            }
        }


    }

    @Composable
    @Preview
    fun rowsAndCols() {
        Column(
            modifier = Modifier.fillMaxSize(),
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text("Column1", style = TextStyle(color = Color.Magenta, background = Color.Yellow))
            Text("Column2", style = TextStyle(color = Color.Magenta, background = Color.LightGray))
            Text("Column3", style = TextStyle(color = Color.Magenta, background = Color.Yellow))
            Row(
                modifier = Modifier.border(
                    border = BorderStroke(2.dp, Color.Black)
                )
            )
            {
                Text(
                    "Alo?",
                    style = TextStyle(color = Color.Black, background = Color.Green),
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    "Hello",
                    style = TextStyle(color = Color.Red),
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    "Bonjour?",
                    style = TextStyle(color = Color.Blue, background = Color.Green),
                    modifier = Modifier.padding(5.dp)
                )
            }
            Text("ColumnBelow", style = TextStyle(color = Color.Magenta))
        }
    }

    @Composable
    fun images() {

        val context = LocalContext.current
        val image: Painter = painterResource(id = R.drawable.animal3)
        val image2: Painter = painterResource(id = R.drawable.animal4)
        val image3: Painter = painterResource(id = R.drawable.animal5)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = image, contentDescription = "",
                modifier = Modifier
                    .size(width = 140.dp, height = 160.dp)
                    .clip(RectangleShape)
                    .padding(2.dp)
            )
            Image(
                painter = image2, contentDescription = "",
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .clip(CircleShape)
                    .padding(0.dp)
            )
        }
    }

    @Composable
    fun buttons() {
        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = { Toast.makeText(context, "alo", Toast.LENGTH_SHORT).show() },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
                ) {
                Text("click me?", style = TextStyle(color = Color.Blue))
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(
                onClick = { Toast.makeText(context, "also clicked", Toast.LENGTH_SHORT).show() },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
            )
            {
                Text("dont click")
            }
        }
    }
}
