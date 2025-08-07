package proj.assignment

import org.quartz.Job
import org.quartz.JobExecutionContext
import grails.plugins.mail.MailService
import grails.core.GrailsApplication
import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import groovy.json.JsonOutput
import grails.gorm.transactions.Transactional

import java.net.http.HttpClient

class DisabledUserReminderJob implements Job {

    GrailsApplication grailsApplication
    MailService mailService

    static triggers = {
//        cron name: 'disabledUserDailyReminder', cronExpression: "0 */1 * * * ?" // every 2 minutes
        simple repeatInterval: 10000L
    }

    @Override
    void execute(JobExecutionContext context) {
//        log.info("Running DisabledUserReminderJob...")
//        def disabledUsers = AppUser.findAllByEnabled(false)
//        disabledUsers.each { user ->
//            sendReminderEmail(user)
//        }
//        log.info("Reminder emails sent to all disabled users.")

        println("Sending Request from Job")
        sendPostReq()
        println("Request sent from Job")

    }

    @Transactional
    void sendPostReq() {
        def client = HttpClient.newHttpClient()

        def users = [
                [
                        firstName: "Faris",
                        lastName : "Rehman",
                        email    : "faris@example.com",
                        phone    : "1234567890",
                        enabled  : false,
                        title    : "Node Developer",
                        password : "abc123"
                ],
                [
                        firstName: "Sadaqat",
                        lastName : "Ali",
                        email    : "sadaqat@example.com",  // Already exists
                        phone    : "9998887777",
                        enabled  : true,
                        title    : "Grails Dev",
                        password : "pass123"
                ]
        ]

        users.eachWithIndex { user, index ->
            def jsonBody = JsonOutput.toJson(user)

            try {
                def request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/admin/createUser"))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                        .build()

                def response = client.send(request, HttpResponse.BodyHandlers.ofString())

                println "User: ${user.email} -> Status: ${response.statusCode()}, Body: ${response.body()}"

            } catch (Exception e) {
                println "Could not create user '${user.email}': ${e.message}"
            }


            if (index == users.size() - 1) {
                println "All users processed. Last user: ${user.email}"
            }
        }
    }




    @Transactional
    void sendReminderEmail(AppUser user) {
        mailService.sendMail {
            to user.email
            subject "Reminder: Your Account is Disabled"
            body """\
            Hello ${user.firstName},

            This is a reminder that your account is currently **disabled**.

            If this is a mistake or you need help, please contact support.

            Regards,
            Admin Team
            """
        }
    }


}
