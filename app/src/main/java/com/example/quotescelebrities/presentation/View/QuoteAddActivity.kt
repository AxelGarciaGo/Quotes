package com.example.quotescelebrities.presentation.View

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.quotescelebrities.data.local.QuoteDB
import com.example.quotescelebrities.data.local.daos.QuoteDao
import com.example.quotescelebrities.data.local.entities.QuoteEntity
import com.example.quotescelebrities.databinding.ActivityQuoteAddBinding
import com.example.quotescelebrities.presentation.View_Model.QuoteAddViewModel
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton


@AndroidEntryPoint

class QuoteAddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteAddBinding
    private val quoteAddViewModel: QuoteAddViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quoteAddViewModel.toString()

        binding = ActivityQuoteAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {

            save()
        }

    }

    private suspend fun save(){

        var addAuthor = binding.txtAutor.text.toString()
        var addQuote = binding.txtCita.text.toString()

        val bd=QuoteDB.getDatabase(applicationContext,
        lifecycleScope).quoteDao()

        popula(bd)


    }

    private suspend fun popula(quoteDao: QuoteDao) {
        val quote = QuoteEntity(
            id = 19,
            quote =,
            author = "Sócrates"
        )
        quoteDao.insert(quote)
    }
}