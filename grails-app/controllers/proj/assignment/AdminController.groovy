package proj.assignment


class AdminController {

    BookService bookService
    AdminService adminService

    static responseFormats = ['json','xml']
    static allowedMethods = [
            greet: "GET",
            createBook: "GET",
            createUser: "POST",
    ]


    def greet() {
        render text: "Hello from admin panel"
    }

    def createBook() {
        def titleName = params.titleName
        def authorName = params.authorName
        def price = params.int('price')

        def result = bookService.createBook(titleName, authorName, price)

        if (result instanceof Book) {
            render status: 201, text: "Book created with ID: ${result.id}"
        } else {
            render status: 400, text: "Error: ${result.errors.allErrors*.defaultMessage.join(', ')}"
        }
    }

    def createUser() {

        def json = request.JSON

        def firstName = json.firstName
        String lastName = json.lastName
        String email = json.email
        String phone = json.phone
        def enabled = json.enabled?.toBoolean()
        String title = json.title
        String password = json.password

        println("${firstName}, ${lastName}, ${email}, ${phone}, ${enabled}, ${title}, ${password}")

        if(firstName.equals() || email.equals()){
            render status: 400, text: "Null value not allowed"
            return
        }

        if (!password) {
            render status: 400, text: "Password is required"
            return
        }



        def result = adminService.createUser(firstName, lastName, email, phone, enabled, title, password)

        if (result instanceof AppUser) {
            render status: 201, text: "User created with ID: ${result.id}"
        } else {
            render status: 400, text: "Error: ${result.errors.allErrors*.defaultMessage.join(', ')}"
        }
    }
}
