package vn.toilamdev.bookmarket.mapper;

import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.dto.BookDTO;

public class BookMapper {
    public static Book mappingBookDTO(BookDTO bookDTO) {
        Book book = new Book();
        book.setISBN(bookDTO.getISBN());
        book.setPublicationDate(bookDTO.getPublicationDate());
        book.setTitle(bookDTO.getTitle());
        book.setQuantity(Integer.parseInt(bookDTO.getQuantity()));
        book.setPrice(Double.parseDouble(bookDTO.getPrice()));
        book.setState(bookDTO.getState());
        book.setDescription(bookDTO.getDescription());
        book.setPublishingCompany(bookDTO.getPublishingCompany());
        book.setSize(bookDTO.getSize());
        book.setTranslator(bookDTO.getTranslator());
        book.setCoverType(bookDTO.getCoverType());
        book.setNumberOfPages(Integer.parseInt(bookDTO.getNumberOfPages()));
        return book;
    }
}
