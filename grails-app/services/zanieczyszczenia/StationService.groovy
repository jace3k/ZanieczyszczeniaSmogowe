package zanieczyszczenia

import grails.gorm.transactions.Transactional
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import org.grails.web.json.JSONElement

@Transactional
class StationService {
    RestBuilder rest

    final String ALL_STATIONS = 'http://api.gios.gov.pl/pjp-api/rest/station/findAll'
    final String STATION_SENSORS = 'http://api.gios.gov.pl/pjp-api/rest/station/sensors/{id}'
    final String SENSOR_DATA = 'http://api.gios.gov.pl/pjp-api/rest/data/getData/{id}'

    StationService() {
        super()
        rest = new RestBuilder()
        refreshStationList()
    }

    def refreshStationList() {
        Station.deleteAll(Station.findAll())
        try {
            RestResponse restResponse = rest.get(ALL_STATIONS)
            if(restResponse.statusCodeValue == 200 && restResponse.json) {
                for (JSONElement element : restResponse.json) {
                    new Station(
                            stationId: (int) element["id"],
                            stationName: element["stationName"],
                            gegrLat: Double.parseDouble(element["gegrLat"].toString()),
                            gegrLon: Double.parseDouble(element["gegrLon"].toString()),
                            cityId: (int) element["city"]["id"],
                            cityName: element["city"]["name"],
                            cityCommuneName: element["city"]["commune"]["communeName"],
                            cityDistrictName: element["city"]["commune"]["districtName"],
                            cityProvinceName: element["city"]["commune"]["provinceName"],
                            addressStreet: element["addressStreet"]
                    ).save()
                }
            } else {
                return null
            }
        } catch (Exception ignored) {
            println 'błąd sieci.'
            return null
        }
    }

    def getStationSensors(int id) {
        getJSONResponse(id, STATION_SENSORS)
    }

    def getSensorData(int id) {
        getJSONResponse(id, SENSOR_DATA)
    }

    private def getJSONResponse(int id, String url) {
        try {
            Map params = [id: id]
            def restResponse = rest.get(url) {
                urlVariables params
            }
            if(restResponse.json && restResponse.statusCode.value() == 200) {
                restResponse.json
            }
        } catch (Exception ignored) {
            print 'błąd sieci.'
            return null
        }
    }
}
