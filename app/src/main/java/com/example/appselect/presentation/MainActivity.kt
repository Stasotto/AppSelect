package com.example.appselect.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.appselect.R
import com.example.appselect.databinding.ActivityMainBinding
import com.example.appselect.presentation.recycler.MoviesAdapter
import com.example.appselect.presentation.viewmodels.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()
    private val adapter by lazy { MoviesAdapter() }

    private val viewModel: MainViewModel by viewModels {
        factory
    }

    @Inject
    lateinit var factory: MainViewModel.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        setUpRecycler()
    }

    private fun setUpRecycler() = with(binding) {
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this@MainActivity)
        lifecycleScope.launch {
            viewModel.moviesFlow?.collectLatest { pagingData ->
                Log.d("DebugResult",pagingData.toString() )
                adapter.submitData(pagingData)
            }
        }
    }
}