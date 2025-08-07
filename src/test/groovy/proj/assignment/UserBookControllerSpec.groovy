package proj.assignment

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class UserBookControllerSpec extends Specification implements ControllerUnitTest<UserBookController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
