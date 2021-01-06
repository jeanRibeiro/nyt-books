package com.newyorktimesbooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newyorktimesbooks.R
import com.newyorktimesbooks.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(private val lista : List<Book>, val onItemClickListener: ((book : Book) -> Unit)) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = lista.count()

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(lista[position])
    }

    class BooksViewHolder(itemView : View, val onItemClickListener: ((book : Book) -> Unit)) : RecyclerView.ViewHolder(itemView) {

        private val titulo = itemView.item_bok_tvTitulo
        private val autor = itemView.item_bok_tvAutor

        fun bindView(book: Book){
            titulo.text = book.titulo;
            autor.text = book.autor;

            itemView.setOnClickListener{
                onItemClickListener.invoke(book)
            }
        }


    }


}