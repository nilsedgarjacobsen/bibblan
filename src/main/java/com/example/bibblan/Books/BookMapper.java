package com.example.bibblan.Books;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    /**
     * Konverterar en Book-entitet till en BookDTO
     */
    public BookDTO toDTO(Book book) {
        if (book == null) {
            return null;
        }

        BookDTO dto = new BookDTO();
        dto.setTitle(book.getTitle());
        dto.setPublicationYear(book.getPublicationYear());
        dto.setAvailableCopies(book.getAvailableCopies());
        dto.setTotalCopies(book.getTotalCopies());

        // Skapa författarens fullständiga namn
        if (book.getAuthor() != null) {
            String fullName = book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();
            dto.setAuthorFullName(fullName.trim());
        }

        return dto;
    }

    /**
     * Konverterar en lista av Book-entiteter till en lista av BookDTO-objekt
     */
    public List<BookDTO> toDTOList(List<Book> books) {
        return books.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
