package vn.toilamdev.bookmarket.utils;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Book_;

public class SpecificationFilter {
    public static Specification<Book> byTitle(String title) {
        return (root, query, builder) -> {
            if (title == null || title.isEmpty()) {
                return builder.conjunction();
            }
            return builder.like(root.get(Book_.TITLE), "%" + title + "%");
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

                case "PRICE_DESC":
                    query.orderBy(builder.desc(root.get(Book_.PRICE)));
                    break;

                default:
                    break;
            }
            return builder.conjunction();
        };
    }

    public static Specification<Book> byStates(List<String> states) {
        return (root, query, builder) -> {
            if (states == null) {
                return builder.conjunction();
            }

            return root.get(Book_.STATE).in(states);
        };
    }

    public static Specification<Book> byPrice(List<String> prices) {
        return (root, query, builder) -> {
            if (prices == null) {
                return builder.conjunction();
            }

            Predicate predicate = builder.conjunction();

            for (String price : prices) {
                switch (price) {
                    case "lt100000":
                        predicate = builder.or(predicate, builder.lessThan(root.get(Book_.PRICE), 100000));
                        break;
                    case "100000-500000":
                        predicate = builder.or(predicate, builder.between(root.get(Book_.PRICE), 100000, 500000));
                        break;
                    case "500000-1000000":
                        predicate = builder.or(predicate, builder.between(root.get(Book_.PRICE), 500000, 1000000));
                        break;
                    default:
                        predicate = builder.or(predicate, builder.greaterThan(root.get(Book_.PRICE), 1000000));
                        break;
                }
            }

            return predicate;
        };
    }

}
