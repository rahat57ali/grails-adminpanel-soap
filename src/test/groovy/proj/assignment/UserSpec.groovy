package proj.assignment

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<AppUser> {

     void "test domain constraints"() {
        when:
        AppUser domain = new AppUser()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
