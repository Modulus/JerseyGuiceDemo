package com.eguaks.data;

import com.eguaks.types.Message;
import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by JohnSigvald on 09/05/2014.
 */

@RunWith(CdiRunner.class)
@ActivatedAlternatives(value = {FakeMessageRepository.class})
public class TestMessageRepository {

    @Inject
    @Named("fakeMessageRepo")
    private MessageRepository messageRepo;

    @Test
    public void verifyInstance(){
        assertTrue(messageRepo.getClass().isAssignableFrom(FakeMessageRepository.class));
    }

    @Test
    public void getAll_ForSpesificUser_HasCorrectAmount(){
        List<Message> messages = messageRepo.getAll("1");

        assertNotNull(messages);
        assertEquals(2, messages.size());

        messages = messageRepo.getAll("2");
        assertNotNull(messages);
        assertEquals(2, messages.size());

        messages = messageRepo.getAll("3");
        assertNotNull(messages);
        assertEquals(3, messages.size());

        messages = messageRepo.getAll("4");
        assertNotNull(messages);
        assertEquals(3, messages.size());
    }

}
