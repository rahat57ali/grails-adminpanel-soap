package proj.assignment

class UserBook {

    AppUser user
    Book book
    Date purchaseDate = new Date()

    static constraints = {
        user nullable: false
        book nullable: false
    }
    static belongsTo = [user: AppUser, book: Book]

    static mapping = {
        book fetch: 'join'
    }
}