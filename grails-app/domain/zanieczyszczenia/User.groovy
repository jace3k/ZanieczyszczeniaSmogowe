package zanieczyszczenia

class User {
    String firstName
    String username
    String password
    String passwordHashed

    static transients = ['password']

    static constraints = {
        firstName nullable: false
        username nullable: false, size: 3..20, blank: false, unique: true
        password nullable: false, size: 3..20, blank: false
    }

    static mapping = {
        table '`User`'
        password column: '`password`'
    }
}
