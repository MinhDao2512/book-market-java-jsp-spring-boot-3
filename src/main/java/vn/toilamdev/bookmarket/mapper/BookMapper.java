package vn.toilamdev.bookmarket.mapper;

import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.dto.BookDTO;

public class BookMapper {
    public static Book mappingBookDTO(Book currentBook, BookDTO bookDTO) {
        currentBook.setISBN(bookDTO.getISBN());
        currentBook.setPublicationDate(bookDTO.getPublicationDate());
        currentBook.setTitle(bookDTO.getTitle());
        currentBook.setQuantity(Integer.parseInt(bookDTO.getQuantity()));
        currentBook.setPrice(Double.parseDouble(bookDTO.getPrice()));
        currentBook.setState(bookDTO.getState());
        currentBook.setDescription(bookDTO.getDescription());
        currentBook.setPublishingCompany(bookDTO.getPublishingCompany());
        currentBook.setSize(bookDTO.getSize());
        currentBook.setTranslator(bookDTO.getTranslator());
        currentBook.setCoverType(bookDTO.getCoverType());
        currentBook.setNumberOfPages(Integer.parseInt(bookDTO.getNumberOfPages()));
        return currentBook;
    }
}
