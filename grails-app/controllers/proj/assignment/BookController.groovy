package proj.assignment

import grails.converters.JSON


class BookController {

    BookService bookService




    def list() {
        def books = Book.list()
        render books as JSON
    }

    def update(Long id) {
        def book = Book.get(id)
        if (!book) {
            render status: 404, text: "Book not found"
            return
        }

        book.properties = params

        if (book.save(flush: true)) {
            render status: 200, text: "Book updated successfully"
        } else {
            render status: 400, text: "Failed to update book"
        }
    }

    def delete(Long id) {
        def book = Book.get(id)
        if (!book) {
            render status: 404, text: "Book not found"
            return
        }

        book.delete(flush: true)
        render status: 200, text: "Book deleted successfully"
    }



}
