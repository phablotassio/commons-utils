package com.commons.utils.object;

import com.commons.utils.dtos.EmailDto;
import com.commons.utils.dtos.PersonDto;
import com.commons.utils.dtos.Type;
import org.junit.Test;

import static com.commons.utils.object.ObjectUtils.applyChangesOnObject;
import static org.junit.Assert.*;

public class ObjectUtilsTest {

    @Test
    public void applyChangesOnObjectTest() {

        EmailDto sourceEmail = new EmailDto();
        sourceEmail.setDesc("robert@gmail.com");
        PersonDto source = new PersonDto("phablo", sourceEmail);

        EmailDto targetEmail = new EmailDto();
        targetEmail.setMain(Boolean.TRUE);
        targetEmail.setType(Type.COMMERCIAL);
        targetEmail.setDesc("phablo@gmail.com");
        PersonDto target = new PersonDto("roberta", targetEmail);

        applyChangesOnObject(source, target);

       /* assertNotNull(target.getEmailDto().getMain());
        assertEquals(Boolean.TRUE, target.getEmailDto().getMain());
        assertEquals(Type.COMMERCIAL, target.getEmailDto().getType());
        assertEquals("robert@gmail.com", target.getEmailDto().getDesc());
*/
        assertEquals(Boolean.TRUE, target.getEmails().get(0).getMain());
        assertEquals(Type.COMMERCIAL, target.getEmails().get(0).getType());
        assertEquals("robert@gmail.com", target.getEmails().get(0).getDesc());

        assertEquals("phablo", target.getName());
    }

}