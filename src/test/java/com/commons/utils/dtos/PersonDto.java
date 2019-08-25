package com.commons.utils.dtos;

import java.util.Arrays;
import java.util.List;

public class PersonDto {

    private String name;
    //private EmailDto emailDto;
    private List<EmailDto> emails;

    public PersonDto(String name, EmailDto emailDto) {
        this.name = name;
        //this.emailDto = emailDto;
        this.emails = Arrays.asList(emailDto);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmailDto> getEmails() {
        return emails;
    }
}
