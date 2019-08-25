package com.commons.utils.object;

import dto.EmailDto;
import dto.PersonDto;
import dto.Type;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.commons.utils.object.ObjectUtils.applyChangesOnObject;
import static org.junit.Assert.*;

public class ObjectUtilsTest {

    @Test
    public void applyChangesOnObjectTest() {

        PersonDto source = new PersonDto();
        source.setName("new name");

        EmailDto _sourceEmail = new EmailDto();
        _sourceEmail.setDesc("new-list@gmail.com");
        List<EmailDto> sourceEmails = new ArrayList<>();
        sourceEmails.add(_sourceEmail);
        source.setEmails(sourceEmails);

        EmailDto sourceEmail = new EmailDto();
        sourceEmail.setDesc("source-single@gmail.com");
        sourceEmail.setType(Type.PESSOAL);
        source.setSingleEmail(sourceEmail);

        PersonDto target = new PersonDto();
        target.setAge(23);

        EmailDto _targetEmail = new EmailDto();
        _targetEmail.setDesc("newlist@gmail.com");
        _targetEmail.setMain(Boolean.FALSE);
        _targetEmail.setType(Type.COMMERCIAL);

        List<EmailDto> targetEmails = new ArrayList<>();
        targetEmails.add(_targetEmail);
        target.setEmails(targetEmails);

        EmailDto targetEmail = new EmailDto();
        targetEmail.setMain(Boolean.TRUE);
        targetEmail.setType(Type.COMMERCIAL);
        targetEmail.setDesc("phablo@gmail.com");

        target.setSingleEmail(targetEmail);

        applyChangesOnObject(source, target);

        assertEquals("new name", target.getName());
        assertEquals(Integer.valueOf(23), target.getAge());

        assertEquals(Boolean.FALSE, target.getEmails().get(0).getMain());
        assertEquals(Type.COMMERCIAL, target.getEmails().get(0).getType());
        assertEquals("new-list@gmail.com", target.getEmails().get(0).getDesc());

        assertEquals(Boolean.TRUE, target.getSingleEmail().getMain());
        assertEquals(Type.PESSOAL, target.getSingleEmail().getType());
        assertEquals("source-single@gmail.com", target.getSingleEmail().getDesc());

    }


}