package iridiumlabs.org.daggerapp.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Person {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("occupation")
    @Expose
    private String occupation;
    @SerializedName("quote")
    @Expose
    private String quote;
    @SerializedName("photo")
    @Expose
    private String photo;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     * The firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     * The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     * The lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     *
     * @return
     * The occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     *
     * @param occupation
     * The occupation
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     *
     * @return
     * The quote
     */
    public String getQuote() {
        return quote;
    }

    /**
     *
     * @param quote
     * The quote
     */
    public void setQuote(String quote) {
        this.quote = quote;
    }

    /**
     *
     * @return
     * The photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     * The photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
