package com.bank.canarabank.controller;

import com.bank.canarabank.model.Loan;
import com.bank.canarabank.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/myLoans")
    @PostAuthorize("hasRole('ROOT')")
    public List<Loan> getLoansDetails(@RequestParam long id) {
        //List<Loan> loans = loanRepository.fi
        return Collections.emptyList();
    }
}
