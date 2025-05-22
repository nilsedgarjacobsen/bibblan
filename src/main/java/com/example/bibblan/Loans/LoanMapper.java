package com.example.bibblan.Loans;


import com.example.bibblan.Books.Book;
import com.example.bibblan.Books.BookRepository;
import com.example.bibblan.Users.User;
import com.example.bibblan.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class LoanMapper {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LoanMapper(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    /**
     * Konverterar en LoanDTO till en Loan-entitet
     */
    public Loan toEntity(LoanDTO loanDTO) {
        if (loanDTO == null) {
            return null;
        }

        Loan loan = new Loan();

        // Hämta User baserat på userId
        if (loanDTO.getUserId() != null) {
            Optional<User> userOpt = userRepository.findById(loanDTO.getUserId());
            if (userOpt.isPresent()) {
                loan.setUser(userOpt.get());
            } else {
                throw new RuntimeException("Användare med ID " + loanDTO.getUserId() + " hittades inte");
            }
        }

        // Hämta Book baserat på bookId eller bookTitle
        Book book = null;
        if (loanDTO.getBookId() != null) {
            Optional<Book> bookOpt = bookRepository.findById(loanDTO.getBookId());
            if (bookOpt.isPresent()) {
                book = bookOpt.get();
            } else {
                throw new RuntimeException("Bok med ID " + loanDTO.getBookId() + " hittades inte");
            }
        } else if (loanDTO.getBookTitle() != null) {
            // Om bookId inte finns, sök på titel
            List<Book> books = bookRepository.findByTitleContainingIgnoreCase(loanDTO.getBookTitle());
            if (books.size() > 0) {
                book = books.get(0); // Ta första träffen
            } else {
                throw new RuntimeException("Bok med titel '" + loanDTO.getBookTitle() + "' hittades inte");
            }
        }

        if (book == null) {
            throw new RuntimeException("Ingen bok specificerad (bookId eller bookTitle krävs)");
        }

        loan.setBook(book);

        // Sätt lånetidpunkt till nu
        loan.setBorrowedDate(LocalDateTime.now());

        // Sätt förfallodatum till 14 dagar fram
        loan.setDueDate(LocalDateTime.now().plusDays(14));

        return loan;
    }

    /**
     * Konverterar en Loan-entitet till en LoanDTO
     */
    public LoanDTO toDTO(Loan loan) {
        if (loan == null) {
            return null;
        }

        LoanDTO dto = new LoanDTO();

        if (loan.getUser() != null) {
            dto.setUserId(loan.getUser().getUserId());
        }

        if (loan.getBook() != null) {
            dto.setBookId(loan.getBook().getBookId());
            dto.setBookTitle(loan.getBook().getTitle());
        }

        return dto;
    }
}

