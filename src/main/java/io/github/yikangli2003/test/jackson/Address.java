package io.github.yikangli2003.test.jackson;

public class Address {
    private String city;
    private String zipcode;

    public Address() {}

    public Address(String city, String zipcode) {
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("city=").append(city).append(", ");
        sb.append("zipcode=").append(zipcode);

        return sb.toString();
    }
}
