package zanieczyszczenia

class StationController {
    StationService service = new StationService()

    def index() {
        [data:service.getData()]
    }

    def show(int id) {
        [station_properties:service.getWithID(id)]
    }
}
