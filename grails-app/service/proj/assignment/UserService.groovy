package proj.assignment

import grails.gorm.transactions.Transactional
import org.hibernate.FetchMode

@Transactional
class UserService {

    AppUser findByEmail(String email) {
        AppUser.findByEmail(email)
    }

    AppUser getUserByEmail(String email) {
        AppUser user = AppUser.findByEmail(email)
        if (user) {
            user.purchases?.size()
        }
        return user
    }

    Set<UserBook> getPurchases(AppUser user) {
        user?.purchases ?: Collections.emptySet()
    }
}
