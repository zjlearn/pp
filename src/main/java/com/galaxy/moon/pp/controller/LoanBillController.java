package com.galaxy.moon.pp.controller;


import com.galaxy.moon.common.Result;
import com.galaxy.moon.pp.biz.LoanBillHandler;
import com.galaxy.moon.pp.model.bean.LoanBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 查询借款申请, 后台工作人员进行处理
 */
@RestController
@RequestMapping("/xhr/loanBill")
public class LoanBillController {

    @Autowired
    LoanBillHandler loanBillHandler;

    @RequestMapping("/listByStatus")
    public Result listLoanBill(@RequestParam("status") Integer status){
        return loanBillHandler.listLoanBill(status);
    }

    @RequestMapping("/add")
    public Result addLoanBill(@RequestBody LoanBill loanBill){
        return loanBillHandler.addLoanBill(loanBill);
    }


}
