package zanieczyszczenia

class UserController {

    def index() { }

    def login() {
        if (request.method == 'POST') {
            String passwordHashed = params.password.encodeAsMD5()
            String username = params.username
            def user = User.findByUsernameAndPasswordHashed(username, passwordHashed)
            if(user) {
                session.user = user
                flash.message = 'Zalogowano pomyślnie'
                forward(controller: 'main', action: 'index')

            } else {
                flash.message = 'Złe dane!'
                println 'Login Failed.'
                [user: user]
            }
        } else if(session.user) {
            redirect(controller: 'main')
        }
    }

    def register() {
        if (request.method == 'POST') {

            def user = new User(params)
            user.passwordHashed = user.password.encodeAsMD5()
            if(user.save(flush: true)) {
                session.user = user
                flash.message = 'Konto założone pomyślnie'
                forward(controller: 'main')
            } else {
                flash.message = 'Złe dane'
                [user:user]
            }
        } else if (session.user) {
            redirect(controller: 'main')
        }
    }

    def logout() {
        session.invalidate()
        redirect(controller: 'main')
    }

    def  profile() {
        print 'profil'
        [user: session.user]
    }
}
