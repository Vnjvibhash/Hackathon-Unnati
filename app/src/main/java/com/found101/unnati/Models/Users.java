package com.found101.unnati.Models;;

import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class Users {

    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    @SerializedName("username")
    String username;

    @SerializedName("email")
    String email;

    @SerializedName("address")
    Address address;

    @SerializedName("phone")
    String phone;

    @SerializedName("website")
    String website;

    @SerializedName("company")
    Company company;


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    public String getWebsite() {
        return website;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    public Company getCompany() {
        return company;
    }

    public class Geo {

        @SerializedName("lat")
        String lat;

        @SerializedName("lng")
        String lng;


        public void setLat(String lat) {
            this.lat = lat;
        }
        public String getLat() {
            return lat;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
        public String getLng() {
            return lng;
        }

    }
    public class Address {

        @SerializedName("street")
        String street;

        @SerializedName("suite")
        Date suite;

        @SerializedName("city")
        String city;

        @SerializedName("zipcode")
        String zipcode;

        @SerializedName("geo")
        Geo geo;


        public void setStreet(String street) {
            this.street = street;
        }
        public String getStreet() {
            return street;
        }

        public void setSuite(Date suite) {
            this.suite = suite;
        }
        public Date getSuite() {
            return suite;
        }

        public void setCity(String city) {
            this.city = city;
        }
        public String getCity() {
            return city;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }
        public String getZipcode() {
            return zipcode;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }
        public Geo getGeo() {
            return geo;
        }

    }
    public class Company {

        @SerializedName("name")
        String name;

        @SerializedName("catchPhrase")
        String catchPhrase;

        @SerializedName("bs")
        String bs;


        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }
        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }
        public String getBs() {
            return bs;
        }

    }

}