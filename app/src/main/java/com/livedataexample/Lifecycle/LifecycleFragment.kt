package com.livedataexample.Lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.livedataexample.MainViewModel
import com.livedataexample.R
import kotlinx.coroutines.*

class LifecycleFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var textViewTop: TextView
    private lateinit var textViewMiddle: TextView
    private lateinit var textViewBottom: TextView
    private lateinit var textViewLarge: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_lifecycle, container, false)

        var button1 = root.findViewById<Button>(R.id.button1)
        var button2 = root.findViewById<Button>(R.id.button2)
        var button3 = root.findViewById<Button>(R.id.button3)
        var button4 = root.findViewById<Button>(R.id.button4)
        var button5 = root.findViewById<Button>(R.id.button5)
        var button6 = root.findViewById<Button>(R.id.button6)
        textViewTop = root.findViewById<Button>(R.id.textViewTop)
        textViewMiddle = root.findViewById<Button>(R.id.textViewMiddle)
        textViewBottom = root.findViewById<Button>(R.id.textViewBottom)
        textViewLarge = root.findViewById<Button>(R.id.textViewLarge)

        button1.setOnClickListener(View.OnClickListener {

            //IO(input/output), Main(updating UI), Default(CPU intensive)
            CoroutineScope(Dispatchers.Default).launch {
                //textView3.text = "Default thread"
                //Crash error - Only the original thread that created a view hierarchy can touch its views.
            }
            CoroutineScope(Dispatchers.Main).launch {
                textViewTop.text = getThread()
                viewModel.number.value = 1
                viewModel.string.value = "button 1"
            }
            CoroutineScope(Dispatchers.IO).launch {
                //textView3.text = "IO thread"
                //Crash error - Only the original thread that created a view hierarchy can touch its views.
            }
        })

        button2.setOnClickListener(View.OnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                viewModel.number.value = 2
                viewModel.string.value = "button 2"
                lifecycleScope.launch(Dispatchers.Default) {
                    textViewTop.text = getThread()
                }
            }
        })

        button3.setOnClickListener(View.OnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                viewModel.number.value = 3
                viewModel.string.value = "button 3"
                withContext(Dispatchers.IO) {
                    textViewTop.text = getThread()
                }
                withContext(Dispatchers.Main) {

                    var str: String = textViewTop.text.toString()
                    textViewTop.text = str + " and " + getThread()
                }
            }
        })
        button4.setOnClickListener(View.OnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                longTask()
            }
        })

        button5.setOnClickListener(View.OnClickListener {

            viewModel.list.value = listOf("1", "2", "3")
            textViewBottom.text = viewModel.list.value.toString()

        })

        button6.setOnClickListener(View.OnClickListener {

        })



        viewModel = MainViewModel()
        val stringObserver = Observer<String> { newString ->
            textViewMiddle.text = newString
        }
        viewModel.string.observe(viewLifecycleOwner, stringObserver)

        val numberObserver = Observer<Int> { newNumber ->
            textViewBottom.text = newNumber.toString()
        }
        viewModel.number.observe(viewLifecycleOwner, numberObserver)

        val listObserver = Observer<List<String>> { newList ->
            textViewBottom.text = "List size = " + newList.size.toString()
        }
        viewModel.list.observe(viewLifecycleOwner, listObserver)

        return root
    }

    suspend fun longTask(): String {
        textViewTop.text = getThread()
        viewModel.number.value = -1
        viewModel.string.value = "Waiting for completion of LongTask()..."
        delay(3000)
        viewModel.number.value = 99
        viewModel.string.value = "LongTask() completed"
        return ""
    }

    fun getThread(): String = "Thread = " + Thread.currentThread().name.toString()
}