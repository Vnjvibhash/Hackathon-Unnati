package com.found101.unnati.Models;

public class UserModel {
    String userEmail,userPassword,userName,name,userMobile,email,role,profession,address,proofType,idProof,imgIdProof;
    int otp;

    public UserModel(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    public UserModel(String userEmail, String userPassword, String userName, String name, String userMobile,int otp){
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.name = name;
        this.userMobile = userMobile;
        this.otp=otp;
    }

//    public UserModel(String role, String profession, String address, String proofType, String idProof, String imgIdProof) {
//        this.role = role;
//        this.profession = profession;
//        this.address = address;
//        this.proofType = proofType;
//        this.idProof = idProof;
//        this.imgIdProof = imgIdProof;
//    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    public String getImgIdProof() {
        return imgIdProof;
    }

    public void setImgIdProof(String imgIdProof) {
        this.imgIdProof = imgIdProof;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
