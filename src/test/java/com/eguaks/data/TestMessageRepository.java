package com.eguaks.data;

import com.google.inject.Inject;
import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Named;

import static org.junit.Assert.assertTrue;

/**
 * Created by JohnSigvald on 09/05/2014.
 */

@RunWith(CdiRunner.class)
@ActivatedAlternatives(value = {FakeUserRepository.class})
public class TestMessageRepository {

    @Inject
    @Named("fakeMessageRepo")
    private MessageRepository messageRepo;

    @Test
    public void verifyInstance(){
        assertTrue(messageRepo.getClass().isAssignableFrom(FakeMessageRepository.class));
    }

}
