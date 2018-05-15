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
        def user = User.findById(session.user.id as long)
        if(user) {
            [stations:user.getStations()]
        } else {
            [:]
        }
    }

    def addFavorites() {
        print params.id
        if(session?.user) {
            Station station = Station.findByStationId(params.id as int)
            User user = User.findById(session.user.id as long)
            print 'user: '
            println user.firstName
            user.addToStations(station)
            if(user.save(flush: true)) {
                flash.message = "Pomyślnie dodano ${station.stationName} do ulubionych"
                redirect(uri: request.getHeader('referer') )
            } else {
                flash.message = "Nie udało się dodać"
                redirect(controller: 'station')
            }
        } else {
            flash.message = 'Nie jesteś zalogowany.'
            redirect(controller: 'station')
        }
    }

    def remFavorites() {
        print 'usuwanie o id: '
        println params.id
        if(session?.user) {
            User user = User.findById(session.user.id as long)
            Station station = user.stations.find {it.stationId == params.id as int}
            user.removeFromStations(station)

            if(user.save(flush: true)){
                flash.message = "Pomyślnie usunięto ${station.stationName} z ulubionych"
                //redirect(controller: 'station')
                redirect(uri: request.getHeader('referer') )
            } else {
                flash.message = "Nie udało się usunąć"
                redirect(controller: 'station')
            }
        } else {
            flash.message = 'Nie jesteś zalogowany.'
            redirect(controller: 'station')
        }
    }
}
