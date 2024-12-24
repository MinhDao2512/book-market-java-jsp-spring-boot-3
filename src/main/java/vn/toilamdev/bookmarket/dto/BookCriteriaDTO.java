package vn.toilamdev.bookmarket.dto;

import java.util.Optional;

public class BookCriteriaDTO {
    Optional<String> keyword;
    Optional<String> page;
    Optional<String> sortBy;
    Optional<String> category;
    Optional<String> state;

    public Optional<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(Optional<String> keyword) {
        this.keyword = keyword;
    }

    public Optional<String> getPage() {
        return page;
    }

    public void setPage(Optional<String> page) {
        this.page = page;
    }

    public Optional<String> getSortBy() {
        return sortBy;
    }

    public void setSortBy(Optional<String> sortBy) {
        this.sortBy = sortBy;
    }

    public Optional<String> getCategory() {
        return category;
    }

    public void setCategory(Optional<String> category) {
        this.category = category;
    }

    public Optional<String> getState() {
        return state;
    }

    public void setState(Optional<String> state) {
        this.state = state;
    }

}
