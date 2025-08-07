package proj.assignment.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grails.gorm.transactions.Transactional;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import proj.assignment.AppUser;
import proj.assignment.UserBook;
import proj.assignment.UserService;

@Service("userDetailsServiceImpl")
@WebService(
        endpointInterface = "proj.assignment.soap.UserDetailsService",
        targetNamespace = "http://soap.assignment.proj/",
        serviceName = "UserDetailsService",
        portName = "UserDetailsServicePort"
)
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Transactional(readOnly = true)
    public UserDetailsResponse getUserDetails(String email) {
        try {
            AppUser user = userService.getUserByEmail(email);
            if (user == null) {
                return new UserDetailsResponse("User not found", null, null);
            }

            UserDetails userDetails = new UserDetails(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getEnabled(),
                    user.getTitle()
            );

            List<BookDetails> books = new ArrayList<>();
            Set<UserBook> purchases = userService.getPurchases(user);
            if (purchases != null) {
                for (UserBook ub : purchases) {
                    books.add(new BookDetails(
                            ub.getBook().getTitleName(),
                            ub.getBook().getAuthorName(),
                            ub.getBook().getPrice(),
                            ub.getPurchaseDate()
                    ));
                }
            }

            return new UserDetailsResponse(null, userDetails, books);
        } catch (Exception e) {
            return new UserDetailsResponse("Error: " + e.getMessage(), null, null);
        }
    }
}