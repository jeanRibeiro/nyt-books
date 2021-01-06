package com.newyorktimesbooks.presentation.books

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.newyorktimesbooks.R
import com.newyorktimesbooks.data.model.Book
import com.newyorktimesbooks.presentation.details.BookDetailActivity
import kotlinx.android.synthetic.main.layout_recyclerview_padrao.*
import kotlinx.android.synthetic.main.layout_toolbar_padrao.*

class BooksActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        //configurando a toolbar
        tbPadrao.title = getString(R.string.books_title)
        setSupportActionBar(tbPadrao)

        //vinculando o viewmodel com a activity
        val viewModel: BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        viewModel.booksLiveData.observe(this, Observer {
            it?.let {books ->
                with(rvPadrao){
                    layoutManager = LinearLayoutManager(this@BooksActivity, LinearLayoutManager.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter =  BooksAdapter(books, {book ->
                        val intent = BookDetailActivity.getStartIntent(this@BooksActivity, book.titulo, book.autor, book.descricao)
                        this@BooksActivity.startActivity(intent)

                    })
                }
            }
        })

        viewModel.getBooks()
    }

}