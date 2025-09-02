package domain;

import com.opencsv.bean.CsvBindByPosition;

public class HotelBookingRow {
    @CsvBindByPosition(position = 0)
    private String location;

    @CsvBindByPosition(position = 1)
    private String checkInDate;

    @CsvBindByPosition(position = 2)
    private String checkOutDate;
}

