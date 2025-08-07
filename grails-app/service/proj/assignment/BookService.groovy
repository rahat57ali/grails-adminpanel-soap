package proj.assignment

import grails.gorm.transactions.Transactional


@Transactional
class BookService {
    def createBook(String titleName, String authorName, Integer price){
        def book = new Book(titleName: titleName, authorName: authorName, price: price)
        if(book.validate()){
            book.save(flush: true)
            return book
        } else {
            return [errors : book.errors]
        }
    }
}
