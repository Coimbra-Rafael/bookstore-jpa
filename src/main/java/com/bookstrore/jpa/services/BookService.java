package com.bookstrore.jpa.services;

import com.bookstrore.jpa.dtos.BookRecordDto;
import com.bookstrore.jpa.models.BookModel;
import com.bookstrore.jpa.models.ReviewModel;
import com.bookstrore.jpa.repositories.AuthorModelRepository;
import com.bookstrore.jpa.repositories.BookModelRepository;
import com.bookstrore.jpa.repositories.PublisherModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookModelRepository bookModelRepository;
    private final AuthorModelRepository authorModelRepository;
    private final PublisherModelRepository publisherModelRepository;

    @Autowired
    public BookService(BookModelRepository bookModelRepository,
                       AuthorModelRepository authorModelRepository,
                       PublisherModelRepository publisherModelRepository) {

        this.bookModelRepository = bookModelRepository;
        this.authorModelRepository = authorModelRepository;
        this.publisherModelRepository = publisherModelRepository;
    }

    public List<BookModel> getAllBooks() {
        return this.bookModelRepository.findAll();
    }

    public BookModel getFindById(UUID id) {
        return this.bookModelRepository.findById(id).orElse(null);
    }

    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto){
        BookModel bookModel = new BookModel();
        bookModel.setTitle(bookRecordDto.title());
        bookModel.setPublisher(this.publisherModelRepository.findById(bookRecordDto.publisherId()).get());
        bookModel.setAuthors(this.authorModelRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet()));
        bookModel.setCreatedAt(Instant.now());
        bookModel.setUpdatedAt(Instant.now());


        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(bookModel);
        bookModel.setReview(reviewModel);

        return this.bookModelRepository.save(bookModel);
    }



    @Transactional
    public void deleteBook(UUID id) {
        this.bookModelRepository.deleteById(id);
    }
}
