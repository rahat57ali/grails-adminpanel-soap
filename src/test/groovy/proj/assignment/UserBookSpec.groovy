package proj.assignment

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserBookSpec extends Specification implements DomainUnitTest<UserBook> {

     void "test domain constraints"() {
        when:
        UserBook domain = new UserBook()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
