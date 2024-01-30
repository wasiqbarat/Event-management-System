package Classes;

public class Event {
    private String name;
    private String address;
    private String dateAndTime;
    private int maxParticipants;
    private int minParticipants;
    private double price;

    @Override
    public String toString() {
        return "Name ='" + name + "\nAddress= " + address +
                "\nDateAndTime = " + dateAndTime +
                "\nMaxParticipants = " + maxParticipants +
                "\nminParticipants=" + minParticipants +
                "\nprice =" + price + "\n";
    }

    public Event(String name, String address, String dateAndTime, int maxParticipants, int minParticipants, double price) {
        this.name = name;
        this.address = address;
        this.dateAndTime = dateAndTime;
        this.maxParticipants = maxParticipants;
        this.minParticipants = minParticipants;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(int minParticipants) {
        this.minParticipants = minParticipants;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
