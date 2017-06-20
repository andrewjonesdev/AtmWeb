package byaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by student on 6/20/17.
 */
@Controller
public class HomeController {
    @Autowired
    private CustomerATMRepository customerATMRepository;
    @Autowired
    private AccountATMRepository accountATMRepository;
    @Autowired
    private TransactionATMRepository transactionATMRepository;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/")
    public String newTransactionATM(Model model){
        model.addAttribute("customerATM", new CustomerATM());
        model.addAttribute("accountATM", new AccountATMx());
        model.addAttribute("transactionATM", new TransactionATMx());
        return "form";
    }
    @PostMapping("/add")
    public String processTransaction(BindingResult bindingResult, @ModelAttribute @Valid TransactionATMx transactionATM, @ModelAttribute @Valid AccountATMx accountATM, @ModelAttribute @Valid CustomerATM customerATM){
        if (bindingResult.hasErrors()) {
            return "form";
        }
        accountATM.setCustomer(customerATM);
        transactionATM.setAccount(accountATM);
        if(transactionATM.getTranReason().toLowerCase().equals("withdrawal")||transactionATM.getTranReason().toLowerCase().equals("withdraw")){
            if(transactionATM.getTranAmount()<0){
                return "form";
            }
            transactionATM.getAccount().setAccBalance(Double.toString(transactionATM.getAccount().getAccBalance()-transactionATM.getTranAmount()));
            if(transactionATM.getAccount().getAccBalance()<0){
                return "form";
            }
        }
        else if(transactionATM.getTranReason().toLowerCase().equals("deposit")){
            if(transactionATM.getTranAmount()<0){
                return "form";
            }
            transactionATM.getAccount().setAccBalance(Double.toString(transactionATM.getAccount().getAccBalance()+transactionATM.getTranAmount()));

        }
        else{
            return "form";
        }
        customerATMRepository.save(customerATM);
        AccountATM saveAcc = new AccountATM();
        saveAcc.setAccBalance(accountATM.getAccBalance());
        saveAcc.setAccCus(accountATM.getAccCus());
        accountATMRepository.save(saveAcc);
        TransactionATM saveTran = new TransactionATM();
        saveTran.setTranAcc(transactionATM.getTranAcc());
        saveTran.setTranAmount(transactionATM.getTranAmount());
        saveTran.setTranReason(transactionATM.getTranReason());
        transactionATMRepository.save(saveTran);
        return "result";
    }
}
