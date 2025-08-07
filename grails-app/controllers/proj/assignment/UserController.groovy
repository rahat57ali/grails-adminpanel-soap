package proj.assignment

import grails.gorm.transactions.Transactional


@Transactional
class UserController {

    def bookService
    def userService

    def login() {
        // Show login form or return error if needed
        render(view: "login") // assumes views/user/login.gsp exists
    }

    def authenticate() {
        String email = params.email
        String password = params.password

        def user = AppUser.findByEmail(email)

        if (!user) {
            flash.message = "User not found"
            redirect(action: 'login')
            return
        }

        if (password != user.password) {
            flash.message = "Incorrect password"
            redirect(action: 'login')
            return
        }

        session.user = user
        flash.message = "Login successful"
        redirect(controller: 'user', action: 'books') // Redirect to available books
    }

    def logout() {
        session.invalidate()
        redirect(action: 'login')
    }

    def changePassword() {
        String email = params.email
        String currentPassword = params.currentPassword
        String newPassword = params.newPassword

        def user = AppUser.findByEmail(email)

        if (!user) {
            render(status: 404, text: "User not found")
            return
        }

        if (currentPassword != user.password) {
            render(status: 401, text: "Current password is incorrect")
            return
        }

        user.password = newPassword
        user.save(flush: true)

        render(status: 200, text: "Password changed successfully")
    }

    def myBooks() {
        def user = session.user
        if (!user) {
            redirect(action: 'login')
            return
        }

        def books = UserBook.findAllByUser(user)*.book
        [books: books]
    }

    def books() {
        def allBooks = Book.list()
        [books: allBooks]
    }

    def buy(Long id) {
        def user = session.user
        if (!user) {
            flash.message = "Please login to purchase"
            redirect(action: 'login')
            return
        }

        def book = Book.get(id)
        if (!book) {
            flash.message = "Book not found"
            redirect(action: 'books')
            return
        }

        // Allow multiple purchases of the same book
        new UserBook(user: user, book: book).save(flush: true)
        flash.message = "Book purchased successfully"
        redirect(action: 'myBooks')
    }
}
