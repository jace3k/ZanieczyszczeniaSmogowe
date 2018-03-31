package zanieczyszczenia

class MainController {
    MainService service = new MainService()

    def index() {
        // pobieram plik z wszystkimi danymi, potem jak ktoś kliknie w daną stacje
        // to tworze nowy obiekt tej stacji w bazie, dodaje tam nazwę i szczegóły
        // z kolejnego requesta z tym id i dopiero wyświetlam.
        // a przed tym sprawdzam czy nie ma już w bazie - jak jest to wywalam
    }

    def station(int id) {
        id ? [station_properties:service.getWithID(id)] : [data:service.getData()]
    }

    def about() {

    }
}
