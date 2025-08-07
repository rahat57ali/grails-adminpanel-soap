package proj.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class BookDetails {
    @XmlElement
    private String titleName;
    @XmlElement
    private String authorName;
    @XmlElement
    private int price;
    @XmlElement
    private Date purchaseDate;

    public BookDetails() {}

    public BookDetails(String titleName, String authorName, int price, Date purchaseDate) {
        this.titleName = titleName;
        this.authorName = authorName;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    // Getters and setters
    public String getTitleName() { return titleName; }
    public void setTitleName(String titleName) { this.titleName = titleName; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public Date getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(Date purchaseDate) { this.purchaseDate = purchaseDate; }
}