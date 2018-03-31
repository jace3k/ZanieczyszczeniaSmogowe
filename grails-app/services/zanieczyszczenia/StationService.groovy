package zanieczyszczenia

import grails.gorm.transactions.Transactional
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse

@Transactional
class StationService {
    RestBuilder rest = new RestBuilder()

    def getData() {
        String url = 'http://api.gios.gov.pl/pjp-api/rest/station/findAll'

        RestResponse restResponse = rest.get(url)
        if(restResponse.statusCodeValue == 200 && restResponse.json) {
            print 'ok'
            return restResponse.json
        }
    }

    def getWithID(id) {
        String url = "http://api.gios.gov.pl/pjp-api/rest/station/sensors/{id}"
        Map params = [id: id]
        RestResponse restResponse = rest.get(url) {
            urlVariables params
        }
        if(restResponse.statusCodeValue == 200 && restResponse.json) {
            return restResponse.json
        }
    }
}
