package com.example.bibblan.Loans;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<Loan> getAllLoans(){
        return loanService.getAllLoans();
    }

    @PostMapping
    public void loan(@RequestBody Loan loan){
        loanService.loan(loan);
    }

    @GetMapping("/user/{id}")
    public List<Loan> getLoansByUserId(@PathVariable Integer id){
        return loanService.getLoansByUserId(id);
    }

}
