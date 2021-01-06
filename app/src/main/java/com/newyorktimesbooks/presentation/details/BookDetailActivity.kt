package com.newyorktimesbooks.presentation.details

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.newyorktimesbooks.R
import kotlinx.android.synthetic.main.activity_book_detail.*
import kotlinx.android.synthetic.main.layout_toolbar_padrao.*

class BookDetailActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        //configurando a toolbar
        tbPadrao.title = getString(R.string.books_detail)
        setSupportActionBar(tbPadrao)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        val titulo = intent.getStringExtra(EXTRA_TITULO)
        val autor = intent.getStringExtra(EXTRA_AUTOR)
        val descricao = intent.getStringExtra(EXTRA_DESCRICAO)

        bok_det_tvTitulo.text = titulo
        bok_det_tvAutor.text = autor
    }

    companion object {
        private const val EXTRA_TITULO = "EXTRA_TITULO"
        private const val EXTRA_AUTOR = "EXTRA_AUTOR"
        private const val EXTRA_DESCRICAO = "EXTRA_DESCRICAO"

        fun getStartIntent(context: Context, titulo: String, autor: String, descricao: String): Intent{
            return Intent(context, BookDetailActivity::class.java).apply {
                putExtra(EXTRA_TITULO, titulo)
                putExtra(EXTRA_AUTOR, autor)
                putExtra(EXTRA_DESCRICAO, descricao)
            }
        }
    }
}