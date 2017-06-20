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
public class TransactionATMx {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@NotNull
    //@Min(1)
    private int tranID;
    @NotNull
    @Min(1)
    private double tranAmount;
    @NotNull
    @Size(min=2, max=30)
    private String tranReason;
    @NotNull
    private AccountATMx account;

    public int getTranID() {
        return tranID;
    }

    /*public void setTranID(int tranID) {
        this.tranID = tranID;
    }*/

    public double getTranAmount() {
        return tranAmount;
    }

    public String getTranReason() {
        return tranReason;
    }

    public int getTranAcc() {
        return account.getAccID();
    }

    public AccountATMx getAccount() {
        return account;
    }

    public void setTranAmount(String tranAmount) {
        this.tranAmount = Double.parseDouble(tranAmount);
    }
    public void setTranReason (String tranReason) {
        this.tranReason = tranReason;
    }
    public void setAccount(AccountATMx account) {
        this.account = account;
    }
}