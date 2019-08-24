package com.commons.utils.object;

import com.commons.utils.dtos.EmailDto;
import com.commons.utils.dtos.PersonDto;
import com.commons.utils.dtos.Type;
import org.junit.Test;

import static com.commons.utils.object.ObjectUtils.applyChangesOnObject;
import static org.junit.Assert.*;

public class ObjectUtilsTest {

    @Test
    public void test() {

        EmailDto sourceEmail = new EmailDto();

        sourceEmail.setDesc("phablo@gmail.com");
        sourceEmail.setType(Type.COMMERCIAL);

        EmailDto targetEmail = new EmailDto();
        targetEmail.setMain(Boolean.TRUE);
        targetEmail.setDesc("robert@gmail.com");

        PersonDto source = new PersonDto("phablo", sourceEmail);
        PersonDto target = new PersonDto("roberta", targetEmail);

        applyChangesOnObject(source, target);

        assertNotNull(target.getEmailDto().getMain());
        assertEquals(Boolean.TRUE, target.getEmailDto().getMain());
        assertEquals(sourceEmail.getDesc(), target.getEmailDto().getDesc());
        assertEquals(source.getName(), target.getName());
        assertEquals(source.getEmailDto().getType(), target.getEmailDto().getType());
        assertNotEquals(source.getEmailDto().getMain(), target.getEmailDto().getMain());


    }

}