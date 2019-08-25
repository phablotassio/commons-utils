package dto;

import java.util.List;

public class PersonDto {

    private String name;
    private Integer age;
    private EmailDto singleEmail;
    private List<EmailDto> emails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmailDto> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDto> emails) {
        this.emails = emails;
    }

    public EmailDto getSingleEmail() {
        return singleEmail;
    }

    public void setSingleEmail(EmailDto singleEmail) {
        this.singleEmail = singleEmail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
