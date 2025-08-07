package proj.assignment

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class MailServiceServiceSpec extends Specification implements ServiceUnitTest<MailServiceService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
