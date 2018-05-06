package com.galaxy.moon.pp.biz;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.model.bean.LoanBill;
import com.galaxy.moon.pp.service.LoanBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoanBillHandler {

    @Autowired
    LoanBillService loanBillService;

    public Result listLoanBill(int status) {
        List<LoanBill> loanBills = new ArrayList<>();
        return ResultGenerator.genSuccessResult(loanBills);
    }

    public Result addLoanBill(LoanBill loanBill) {
        int rtn = loanBillService.insert(loanBill);
        return ResultGenerator.genSuccessResult(rtn);
    }
}
