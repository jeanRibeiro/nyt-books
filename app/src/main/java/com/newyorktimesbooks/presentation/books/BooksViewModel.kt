package com.newyorktimesbooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.newyorktimesbooks.data.ApiService
import com.newyorktimesbooks.data.model.Book
import com.newyorktimesbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(){
        //booksLiveData.value = createFakeBooks()
        ApiService.service.getBooks().enqueue(object: Callback<BookBodyResponse>{
            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                if(response.isSuccessful){
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let {bookBodyResponse ->
                        for (result in bookBodyResponse.bookResults){
                            val book: Book = Book(
                                titulo = result.bookDetailResponse[0].titulo,
                                autor = result.bookDetailResponse[0].autor,
                                descricao = result.bookDetailResponse[0].descricao
                            )

                            books.add(book)
                        }
                    }

                    booksLiveData.value = books
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }

        })
    }

//    fun createFakeBooks(): List<Book>{
//        return listOf(
//            Book("Título livro 1", "autor 1"),
//            Book("Título livro 2", "autor 2"),
//            Book("Título livro 3", "autor 3"),
//            Book("Título livro 4", "autor 4"),
//            Book("Título livro 5", "autor 5")
//        )
//    }

}