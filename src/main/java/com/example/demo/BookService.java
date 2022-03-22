package com.example.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private static BookDto mapToBookDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();

        bookDto.setAuthor(bookEntity.getAuthor());
        bookDto.setTitle(bookEntity.getTitle());

        return bookDto;
    }

    @Transactional
    public List<BookDto> getBooks(String bookAuthor) {
        List<BookDto> ret = new LinkedList<>();
        for (BookEntity b1 : bookRepository.findAll()) {
            BookDto b2 = mapToBookDto(b1);
            ret.add(b2);
        }
        return ret;
    }

    @Transactional
    public BookDto getBook(Long bookId) {
        Optional<BookEntity> byId = bookRepository.findById(bookId);
        if (byId.isPresent()) {
            return mapToBookDto(byId.get());
        }
        return null;
    }

    @Transactional
    public Long createBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setTitle(bookDto.getTitle());

        this.bookRepository.save(bookEntity);

        return bookEntity.getId();
    }

    @Transactional
    public void updateBook(int bookId, BookDto bookDto) {
        Optional<BookEntity> byId = bookRepository.findById((long)bookId);
        if (byId.isPresent()) {
            byId.get().setAuthor(bookDto.getAuthor());
            byId.get().setTitle(bookDto.getTitle());
        }
    }

    @Transactional
    public void deleteBook(int bookId) {
        Optional<BookEntity> byId = bookRepository.findById((long)bookId);
        if (byId.isPresent()) {
            bookRepository.delete(byId.get());
        }
    }

}
