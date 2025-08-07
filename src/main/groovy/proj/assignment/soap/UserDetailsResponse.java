package proj.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "UserDetailsResponse", namespace = "http://soap.assignment.proj/")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDetailsResponse {
    @XmlElement
    private String error;
    @XmlElement
    private UserDetails userDetails;
    @XmlElement
    private List<BookDetails> purchasedBooks;

    public UserDetailsResponse() {}

    public UserDetailsResponse(String error, UserDetails userDetails, List<BookDetails> purchasedBooks) {
        this.error = error;
        this.userDetails = userDetails;
        this.purchasedBooks = purchasedBooks;
    }

    // Getters and setters
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public UserDetails getUserDetails() { return userDetails; }
    public void setUserDetails(UserDetails userDetails) { this.userDetails = userDetails; }

    public List<BookDetails> getPurchasedBooks() { return purchasedBooks; }
    public void setPurchasedBooks(List<BookDetails> purchasedBooks) { this.purchasedBooks = purchasedBooks; }
}
