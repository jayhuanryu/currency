package com.jay.currency

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jay.currency.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.simpleName

    // View Attributes
    private lateinit var bindng : ActivityMainBinding
    private lateinit var recyclerViewAdapter : MainRecyclerViewAdapter
    private lateinit var arrayAdapter : ArrayAdapter<String>

    // View Model
    private val mainViewModel : MainViewModel by viewModels { MainViewModelFactory((application as CurrencyApplication).repository) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindng = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindng.root)

        initView()

    }

    override fun onResume() {
        super.onResume()

        addObservers()
        mainViewModel.refresh()
    }

    private fun initView() {

        // edittext attributes
        bindng.etCurrencyAmount.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {

                val amount = bindng.etCurrencyAmount.text.toString().toDouble()
                mainViewModel.updateAmountOfMoney(amount)

                return@OnKeyListener true
            }
            false
        })

        // SPinner attributes


        arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, emptyList())
        bindng.spinnerCurrency.apply {
            adapter = arrayAdapter
        }
        bindng.spinnerCurrency.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // item selected
                if (parent != null) {
                    mainViewModel.updateSelectedCurrency(parent.getItemAtPosition(position).toString())
                }
                else {
                    // behaves as nothing selected -> do nothing
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // do nothing
            }
        }

        // recyclerview attributes
        recyclerViewAdapter = MainRecyclerViewAdapter()
        bindng.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerViewAdapter
        }
    }

    private fun addObservers() {

        mainViewModel.supportAbbrCurList.observe(this, {
            if (it.isNotEmpty()) {
                arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, it)
            }

            //why is this 0?
        })

        mainViewModel.currencyRateList.observe(this, {
            if (it.isNotEmpty()) {
                mainViewModel.updateUIData()
            }
        })

        mainViewModel.calculatedRateList.observe(this, {
            recyclerViewAdapter.updateList(it)
            recyclerViewAdapter.notifyDataSetChanged()
        })

        mainViewModel.isUpdatingUI.observe(this, {
            if (it) {
                showProgress(true)
            }
            else {
                showProgress(false)
            }

        })


    }

    private fun showProgress(doShow : Boolean) {
        if (doShow) {
            bindng.llProgressContainer.visibility = View.VISIBLE
            bindng.progressCircular.visibility = View.VISIBLE
        }
        else {
            bindng.llProgressContainer.visibility = View.GONE
            bindng.progressCircular.visibility = View.GONE
        }
    }


}