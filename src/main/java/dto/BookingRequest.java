package dto;

import java.time.LocalDate;

public class BookingRequest {

    private String hotel;
    private LocalDate entryDate;
    private int personsNumber;

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public int getPersonsNumber() {
        return personsNumber;
    }

    public void setPersonsNumber(int personsNumber) {
        this.personsNumber = personsNumber;
    }

    @Override
    public String toString() {
        return "BookingRequest {" +
                "Hotel='" + hotel + '\'' +
                ", entryDate=" + entryDate +
                ", personsNumber=" + personsNumber +
                '}';
    }
}
