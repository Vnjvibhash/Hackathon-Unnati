package com.found101.unnati.Models;

public class UserModel {
    String profession,userPassword,address,role,idProof,userMobile,proofType,name,otp,userEmail,userName;

    public UserModel() {
    }

    public UserModel(String profession, String userPassword, String address, String role, String idProof, String userMobile, String proofType, String name, String otp, String userEmail, String userName) {
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
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

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
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
