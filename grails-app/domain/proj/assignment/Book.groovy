package proj.assignment

class Book {

    static mapping = {
        id generator: 'identity'
    }

    String titleName;
    String authorName;
    Integer price;

    static hasMany = [buyers: UserBook]
    static belongsTo = AppUser

    static constraints = {
        titleName nullable: false, blank: false
        authorName nullable: false, blank: false
        price nullable: false, min: 0
    }

}