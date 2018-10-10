package com.infotech.CustomSignUpLogin.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exceptions")
public class Exceptions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "exception_code")
    private Integer exceptionCode;

    @Column(name = "exception_name")
    private String exceptionName;

    @Column(name = "en_msg")
    private String englishMessage;

    @Column(name = "ar_msg")
    private String arabicMessage;

    public Exceptions() {
    }

    public Exceptions(Integer exceptionCode, String exceptionName, String englishMessage, String arabicMessage) {
        this.exceptionCode = exceptionCode;
        this.exceptionName = exceptionName;
        this.englishMessage = englishMessage;
        this.arabicMessage = arabicMessage;
    }

    public Long getId() {
        return id;
    }

    public Integer getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(Integer exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getEnglishMessage() {
        return englishMessage;
    }

    public void setEnglishMessage(String englishMessage) {
        this.englishMessage = englishMessage;
    }

    public String getArabicMessage() {
        return arabicMessage;
    }

    public void setArabicMessage(String arabicMessage) {
        this.arabicMessage = arabicMessage;
    }

    @Override
    public String toString() {
        return "Exceptions{" +
                "id=" + id +
                ", exceptionCode=" + exceptionCode +
                ", exceptionName='" + exceptionName + '\'' +
                ", englishMessage='" + englishMessage + '\'' +
                ", arabicMessage='" + arabicMessage + '\'' +
                '}';
    }

}
