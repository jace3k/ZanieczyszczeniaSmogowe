package zanieczyszczenia

class User {
    String firstName
    String username
    String password
    String passwordHashed
    String localization

    static hasMany = [stations: Station]

    static transients = ['password']

    static constraints = {
        firstName nullable: false
        username nullable: false, size: 3..20, blank: false, unique: true
        password size: 3..20, blank: false
        localization size: 2..50
    }

    static mapping = {
        table '`User`'
        password column: '`password`'
    }
}
