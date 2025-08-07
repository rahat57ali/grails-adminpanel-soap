package proj.assignment

class AppUser {

    static mapping = {
        id generator: 'identity'
    }

    String firstName
    String lastName
    String email
    String phone
    Boolean enabled
    String title
    String password

    static hasMany = [purchases: UserBook]

    static constraints = {
        firstName nullable: false, blank: false
        lastName nullable: false, blank: false
        email email: true, blank: false, unique: true
        phone nullable: false, blank: false
        enabled nullable: false
        title nullable: false, blank: false
        password nullable: false, blank: false
    }
}

