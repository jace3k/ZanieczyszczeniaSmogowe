package zanieczyszczenia

class StationController {
    StationService service = new StationService()

    def index() {
        def user = User.findById(session.user.id)
        def stations = Station.findAll()
        def favs = user.getStations()
        if (stations) {
            [stationList: stations, favoriteStations: favs]
        } else {
            flash.message = "Nie można pobrać stacji. Spróbuj ponownie za chwilę"
            [:]
        }

    }

    def show(int id) {
        def station = Station.findByStationId(id).stationName
        def resp = service.getStationSensors(id)
        if (resp) {
            [stationProperties: resp, stationName: station, stationId: id]
        } else {
            flash.message = "Błąd. Spróbuj ponownie za chwilę"
            [:]
        }


    }

    def refresh() {
        service.refreshStationList()
        redirect(controller: 'station')
    }
}
