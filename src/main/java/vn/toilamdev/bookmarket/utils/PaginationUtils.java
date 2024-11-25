package vn.toilamdev.bookmarket.utils;

import java.util.ArrayList;
import java.util.List;

public class PaginationUtils {
    public static List<Integer> getPageNumbers(int currentPage, int totalPages, int maxVisible) {
        List<Integer> pageNumbers = new ArrayList<>();

        if (totalPages <= maxVisible) {
            for (int i = 1; i <= totalPages; i++) {
                pageNumbers.add(i);
            }
        } else {
            int startPage = Math.max(1, currentPage - (maxVisible / 2));

            if (startPage + maxVisible - 1 > totalPages) {
                startPage = Math.max(1, totalPages - maxVisible + 1);
            }

            for (int i = 0; i < maxVisible && startPage <= totalPages; i++) {
                pageNumbers.add(startPage++);
            }
        }

        return pageNumbers;
    }
}
