package byaj;

/**
 * Created by student on 6/20/17.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
public class AccountATMx {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@NotNull
    //@Min(1)
    private int accID;
    @NotNull
    @Min(1)
    private double accBalance;
    @NotNull
    private CustomerATM customer;

    public int getAccID() {
        return accID;
    }

    /*public void setAccID(int accID) {
        this.accID = accID;
    }*/

    public double getAccBalance() {
        return accBalance;
    }

    public int getAccCus() {
        return customer.getCusID();
    }

    public CustomerATM getCustomer() {
        return customer;
    }

    public void setAccBalance(String accBalance) {
        this.accBalance = Double.parseDouble(accBalance);
    }
    public void setCustomer(CustomerATM customer) {
        this.customer = customer;
    }
}