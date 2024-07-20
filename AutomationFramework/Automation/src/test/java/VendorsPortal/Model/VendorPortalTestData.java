package VendorsPortal.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendorPortalTestData {
    private String username;
    private String password;
    private String monthlyEarning;
    private String annualEarning;
    @JsonProperty("profitMargin")
    private String profitMargin;
    private String availableInventory;
    private String searchKeyword;
    private String searchResultsCount;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMonthlyEarning(String monthlyEarning) {
        this.monthlyEarning = monthlyEarning;
    }

    public void setAnnualEarning(String annualEarning) {
        this.annualEarning = annualEarning;
    }

    public void setProfitMargin(String profitMargin) {
        this.profitMargin = profitMargin;
    }

    public void setAvailableInventory(String availableInventory) {
        this.availableInventory = availableInventory;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public void setSearchResultsCount(String searchResultsCount) {
        this.searchResultsCount = searchResultsCount;
    }

    public String getAvailableInventory() {
        return availableInventory;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String getMonthlyEarning() {
        return monthlyEarning;
    }

    public String getAnnualEarning() {
        return annualEarning;
    }

    public String getProfitMargin() {
        return profitMargin;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public String getSearchResultsCount() {
        return searchResultsCount;
    }
}
