package proj.assignment

import grails.gorm.transactions.Transactional

@Transactional
class UserBookController {

    def bookService
    def userService

    def index() {
        def allBooks = Book.list()
        def currentUser = getCurrentUser()
        [books: allBooks, user: currentUser]
    }

    def buy(Long id) {
        def book = Book.get(id)
        def user = session.user

        if (!book || !user) {
            flash.message = "Login required to purchase books."
            redirect(controller: 'user', action: 'login')
            return
        }

        def userBook = new UserBook(user: user, book: book)
        if (userBook.save(flush: true)) {
            flash.message = "Book purchased successfully."
        } else {
            flash.message = "Could not purchase book."
        }

        redirect(controller: 'userBook', action: 'index')
    }



    private AppUser getLoggedInUser() {
        // For testing you can hardcode this temporarily
        return AppUser.get(65)
        // return springSecurityService.currentUser
    }

    def myBooks() {
        def currentUser = getCurrentUser()
        [myBooks: currentUser?.purchasedBooks]
    }

    private getCurrentUser() {
        // Simulated logic for now
        // Replace this with actual session-based or token-based user fetching
        return AppUser.findByEmail(session.userEmail)
    }
}