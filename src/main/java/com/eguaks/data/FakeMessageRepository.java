package com.eguaks.data;

import com.eguaks.types.Message;
import com.eguaks.types.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import javax.inject.Singleton;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by jsska on 05.05.2014.
 */

@Singleton
@Alternative
@Named("fakeMessageRepo")
public class FakeMessageRepository implements MessageRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(FakeMessageRepository.class);

    private List<Message> messages;

    public FakeMessageRepository(){
        messages = createMessages();
    }


    @Override
    public Message findOne(String id) {
       Optional<Message> possibleMessage = messages.stream().
                findFirst().
                filter( message -> message.getId().equals(id));
        if(possibleMessage.isPresent()){
            return possibleMessage.get();
        }
        else {
            throw new NoSuchElementException("This message does not exist");
        }
    }

    @Override
    public List<Message> getAll(String userId) {
        LOGGER.debug(String.format("Trying to find all messages for user %s", userId));
        List<Message> messagesFound = messages.stream().
                filter(message -> message.getFrom().getId().equals(userId) || message.getTo().getId().equals(userId))
                .collect(Collectors.toList());

        if(messagesFound == null){
            LOGGER.trace(String.format("Found no elements"));
        }
        else {
            LOGGER.trace(String.format("Found %s element(s)", messagesFound.size()));
        }

        return messagesFound;
    }

    @Override
    public void sendMessage(Message message) {
        messages.add(message);
    }

    @Override
    public void deleteMessage(String messageId) {

        Optional<Message> possibleMessage = messages.
                stream().
                filter(message -> message.getId().equals(messageId)).findFirst();

        if(possibleMessage.isPresent()){
            messages.remove(possibleMessage.get());
        }

    }



    private static List<Message> createMessages(){
        List<Message> messages = new ArrayList<>();
        List<User> users =  FakeUserRepository.createUsers();

        messages.add(new Message(users.get(0), users.get(1), "Hi", "First message", LocalDate.now()));
        messages.add(new Message(users.get(1), users.get(0), "Re:Hi", "My reply to your first message. Hello there sir", LocalDate.now()));
        messages.add(new Message(users.get(3), users.get(2), "Blabab", "Muhahahasdfhjksahdsa, hasdkjlfhadsf, asdfhlasdf. JALHAL?", LocalDate.now()));
        messages.add(new Message(users.get(2), users.get(3), "Re. Blabab", "Iditio!", LocalDate.now()));
        messages.add(new Message(users.get(3), users.get(2), "Re. Blabab", "??", LocalDate.now()));

        return messages;

    }

}
