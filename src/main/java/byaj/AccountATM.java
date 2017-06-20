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
import javax.validation.constraints.Size;


@Entity
public class AccountATM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@NotNull
    //@Min(1)
    private int accID;
    @NotNull
    @Min(1)
    private int accCus;
    @NotNull
    @Min(1)
    private double accBalance;

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
        return accCus;
    }


    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public void setAccCus(int accCus) {
        this.accCus = accCus;
    }
}