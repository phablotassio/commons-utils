package com.commons.utils.dtos;

public class PersonDto {

    private String name;
    private EmailDto emailDto;

    public PersonDto(String name, EmailDto emailDto) {
        this.name = name;
        this.emailDto = emailDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmailDto getEmailDto() {
        return emailDto;
    }

    public void setEmailDto(EmailDto emailDto) {
        this.emailDto = emailDto;
    }
}
