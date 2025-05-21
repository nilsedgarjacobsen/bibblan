package com.example.bibblan.Loans;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }

    public void loan(Loan loan){
        loanRepository.save(loan);
    }

    public List<Loan> getLoansByUserId(Integer id){
        return loanRepository.getLoansByUserUserId(id);
    }
}
