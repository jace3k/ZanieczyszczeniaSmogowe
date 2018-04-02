package zanieczyszczenia

class StationController {
    StationService service = new StationService()

    def index() {
        def stations = Station.findAll()
        if (stations) {
            [stationList:Station.findAll()]
        } else {
            flash.message = "Nie można pobrać stacji. Spróbuj ponownie za chwilę"
            [:]
        }

    }

    def show(int id) {
        def station = Station.findByStationId(id).stationName
        def resp = service.getStationSensors(id)
        if(resp) {
            [stationProperties:resp, stationName:station, stationId:id]
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
