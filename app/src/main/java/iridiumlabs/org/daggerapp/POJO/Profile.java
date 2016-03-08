package iridiumlabs.org.daggerapp.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by John on 3/8/16.
 */
public class Profile {

    @SerializedName("id")
    @Expose
    private Integer id;
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