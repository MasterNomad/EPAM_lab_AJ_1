package dto;

import java.time.LocalDate;

public class BookingRequest {

    private int id;
    private String hotel;
    private LocalDate entryDate;
    private int personsNumber;

    public void setId(int id) {
        this.id = id;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public void setPersonsNumber(int personsNumber) {
        this.personsNumber = personsNumber;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "id=" + id +
                ", hotel='" + hotel + '\'' +
                ", entryDate=" + entryDate +
                ", personsNumber=" + personsNumber +
                '}';
    }
}
