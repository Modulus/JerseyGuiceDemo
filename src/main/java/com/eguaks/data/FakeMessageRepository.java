package com.eguaks.data;

import com.eguaks.types.Message;
import com.eguaks.types.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.*;

/**
 * Created by jsska on 05.05.2014.
 */

@Singleton
@Alternative
@Named("fakeMessageRepo")
public class FakeMessageRepository implements MessageRepository {

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
//        List<Message> messagesFound = messages.stream().
//                filter( message -> message.getFrom().getId().equals(userId) || message.getTo().getId().equals(userId))
//                .map(Message::new).collect(Collectors.toList());
//
//        return messagesFound;
        throw new NotImplementedException();
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

        messages.add(new Message(users.get(0), users.get(1), "Hi", "First message", new Date()));
        messages.add(new Message(users.get(1), users.get(0), "Re:Hi", "My reply to your first message. Hello there sir", new Date()));
        messages.add(new Message(users.get(3), users.get(2), "Blabab", "Muhahahasdfhjksahdsa, hasdkjlfhadsf, asdfhlasdf. JALHAL?", new Date()));
        messages.add(new Message(users.get(2), users.get(3), "Re. Blabab", "Iditio!", new Date()));
        messages.add(new Message(users.get(3), users.get(2), "Re. Blabab", "??", new Date()));

        return messages;

    }

}
