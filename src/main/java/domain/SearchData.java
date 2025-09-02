package domain;

public class SearchData {
    private String location;
    private String checkInDate;
    private String checkOutDate;


    public void setLocation(String location) {
        this.location = location;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getLocation() {
        return location;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return "SearchData{" +
                "checkOutDate='" + checkOutDate + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
