package com.example.bibblan.Loans;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> loan(@RequestBody LoanDTO loanDTO) {
        try {
            loanService.loan(loanDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Lån skapat framgångsrikt");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Fel: " + e.getMessage());
        }
    }

    @GetMapping("/user/{id}")
    public List<Loan> getLoansByUserId(@PathVariable Integer id){
        return loanService.getLoansByUserId(id);
    }

}
