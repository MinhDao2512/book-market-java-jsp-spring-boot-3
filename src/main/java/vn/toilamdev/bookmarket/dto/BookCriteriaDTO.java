package vn.toilamdev.bookmarket.dto;

import java.util.List;
import java.util.Optional;

public class BookCriteriaDTO {
    Optional<String> keyword;
    Optional<String> page;
    Optional<String> sortBy;
    Optional<List<String>> categories;
    Optional<List<String>> states;
    Optional<List<String>> prices;

    public Optional<String> getKeyword() {
        return keyword != null ? keyword : Optional.empty();
    }

    public void setKeyword(Optional<String> keyword) {
        this.keyword = keyword;
    }

    public Optional<String> getPage() {
        return page != null ? page : Optional.empty();
    }

    public void setPage(Optional<String> page) {
        this.page = page;
    }

    public Optional<String> getSortBy() {
        return sortBy != null ? sortBy : Optional.empty();
    }

    public void setSortBy(Optional<String> sortBy) {
        this.sortBy = sortBy;
    }

    public Optional<List<String>> getCategories() {
        return categories != null ? categories : Optional.empty();
    }

    public void setCategories(Optional<List<String>> categories) {
        this.categories = categories;
    }

    public Optional<List<String>> getStates() {
        return states != null ? states : Optional.empty();
    }

    public void setStates(Optional<List<String>> states) {
        this.states = states;
    }

    public Optional<List<String>> getPrices() {
        return prices != null ? prices : Optional.empty();
    }

    public void setPrices(Optional<List<String>> prices) {
        this.prices = prices;
    }

}
