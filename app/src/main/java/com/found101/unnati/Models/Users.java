package com.found101.unnati.Models;

public class Users {
    String profession;
    long userPassword;
    String address;
    int role;
    long idProof;
    long userMobile;
    String proofType, name;
    int otp;
    String userEmail, userName;

    public Users() {
    }

    public Users(String profession, long userPassword, String address, int role, long idProof, long userMobile, String proofType, String name, int otp, String userEmail, String userName) {
        this.profession = profession;
        this.userPassword = userPassword;
        this.address = address;
        this.role = role;
        this.idProof = idProof;
        this.userMobile = userMobile;
        this.proofType = proofType;
        this.name = name;
        this.otp = otp;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public long getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(long userPassword) {
        this.userPassword = userPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public long getIdProof() {
        return idProof;
    }

    public void setIdProof(long idProof) {
        this.idProof = idProof;
    }

    public long getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(long userMobile) {
        this.userMobile = userMobile;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
