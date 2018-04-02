package zanieczyszczenia

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class UserControllerSpec extends Specification implements ControllerUnitTest<UserController> {

    def setup() {
    }

    def cleanup() {
    }

    def "test adding to favs"() {
        given:
        setup()
        //session.user = new User(firstName: 'adam', username: 'adam', password: '123', passwordHashed: 'asdasdasdsadsasasasadd').save(flush: true)
        session.user = Mock(User)

//        Station station = new Station(
//                id: 1,
//                stationId: 114,
//                stationName: 'Wroclaw bla blabla',
//                gegrLon: 1,
//                gegrLat: 1,
//                cityId: 1,
//                cityName: 'wroclaw',
//                cityDistrictName: 'wroclaw',
//                cityProvinceName: 'wroclaw',
//                cityCommuneName: 'wroclaw',
//                addressStreet: 'kuznicza 123'
//        ).save(flush: true)
        Station station = Mock(Station)

        params.id = station.stationId

        when:
        controller.addFavorites()

        then:
        User.get(1).stations.size() == 1
    }

    def "test sth"() {
        given:
        User a = Mock(User)
        Station s = Mock(Station)
        a.firstName >> 'aaaa'
        s.stationId >> 144

        params.id = 144
        session.user = a
        //controller.addFavorites()
        a.addToStations(s)
        a.save()

        expect:
        a.firstName == 'aaaa'
        a.stations.size() == 1
    }
}
