package com.example.bibblan.Loans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Autowired
    public LoanService(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }

    public void loan(LoanDTO loanDTO) {
        // Konvertera DTO till entitet
        Loan loan = loanMapper.toEntity(loanDTO);

        // Spara lånet
        loanRepository.save(loan);
    }

    public List<Loan> getLoansByUserId(Integer id){
        return loanRepository.getLoansByUserUserId(id);
    }
}
