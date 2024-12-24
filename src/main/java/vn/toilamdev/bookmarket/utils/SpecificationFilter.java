package vn.toilamdev.bookmarket.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.BookCategorization_;
import vn.toilamdev.bookmarket.domain.Book_;
import vn.toilamdev.bookmarket.domain.Category_;

public class SpecificationFilter {
    public static Specification<Book> byTitle(String title) {
        return (root, query, builder) -> {
            if (title == null || title.isEmpty()) {
                return builder.conjunction();
            }
            return builder.like(root.get(Book_.TITLE), "%" + title + "%");
        };
    }

    public static Specification<Book> byCategories(List<Long> categoryIds) {
        return (root, query, builder) -> {
            if (categoryIds == null || categoryIds.isEmpty()) {
                return builder.conjunction();
            }

            Join<Object, Object> bookCategorizationsJoin = root.join(Book_.BOOK_CATEGORIZATIONS);

            Join<Object, Object> categoriesJoin = bookCategorizationsJoin.join(BookCategorization_.CATEGORY);

            return categoriesJoin.get(Category_.ID).in(categoryIds);
        };
    }

    public static Specification<Book> byOrder(String sortBy) {
        return (root, query, builder) -> {
            if (sortBy == null || sortBy.isEmpty()) {
                return builder.conjunction();
            }

            switch (sortBy) {
                case "AZ":
                    query.orderBy(builder.asc(root.get(Book_.TITLE)));
                    break;

                case "ZA":
                    query.orderBy(builder.desc(root.get(Book_.TITLE)));
                    break;

                case "PRICE_ASC":
                    query.orderBy(builder.asc(root.get(Book_.PRICE)));
                    break;

                default:
                    query.orderBy(builder.desc(root.get(Book_.PRICE)));
                    break;
            }
            return builder.conjunction();
        };
    }

    public static Specification<Book> byStates(List<String> states) {
        return (root, query, builder) -> {
            if (states == null || states.isEmpty()) {
                return builder.conjunction();
            }

            return root.get(Book_.STATE).in(states);
        };
    }

    public static Specification<Book> byPrice(List<String> prices) {
        return (root, query, builder) -> {
            if (prices == null || prices.isEmpty()) {
                return builder.conjunction();
            }

            List<Predicate> predicates = new ArrayList<>();

            for (String price : prices) {
                switch (price) {
                    case "lt100000":
                        predicates.add(builder.lessThan(root.get(Book_.PRICE), 100000D));
                        break;
                    case "100000-500000":
                        predicates.add(builder.between(root.get(Book_.PRICE), 100000D, 500000D));
                        break;
                    case "500000-1000000":
                        predicates.add(builder.between(root.get(Book_.PRICE), 500000D, 1000000D));
                        break;
                    default:
                        predicates.add(builder.greaterThan(root.get(Book_.PRICE), 1000000D));
                        break;
                }
            }

            return builder.or(predicates.toArray(new Predicate[0]));
        };
    }

}
