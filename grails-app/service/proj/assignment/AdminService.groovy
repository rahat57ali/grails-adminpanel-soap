package proj.assignment

import grails.gorm.transactions.Transactional
import grails.plugins.mail.MailService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Transactional
class AdminService {

    MailService mailService;

    def createUser(String firstName, String lastName, String email, String phone, boolean enabled, String title, String password){



        def user = new AppUser(firstName: firstName, lastName: lastName, email: email, phone: phone, enabled: enabled, title: title, password: password)
        if(user.validate()){
            user.save(flush: true)

            mailService.sendMail {
                to email
                from "rahat@gmail.com"
                subject "Welcome to the Book Store!"
                body "Hi ${firstName},\n\nWelcome to our platform. We're excited to have you on board!\n\nRegards,\nAdmin"
            }

            return user
        } else {
            return [errors : user.errors]
        }
    }


}
