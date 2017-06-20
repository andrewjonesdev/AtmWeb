package byaj;

/**
 * Created by student on 6/20/17.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class CustomerATM {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@NotNull
    //@Min(1)
    private int cusID;

    @NotNull
    @Size(min=2, max=30)
    private String cusFirstName;
    @NotNull
    @Size(min=2, max=30)
    private String cusLastName;

    public int getCusID() {
        return cusID;
    }

    /*public void setCusID(int cusID) {
        this.cusID = cusID;
    }*/

    public String getCusFirstName() {
        return cusFirstName;
    }

    public String getCusLastName() {
        return cusLastName;
    }

    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName = cusFirstName;
    }
    
    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }
}