package com.eguaks.data;

import com.eguaks.types.Message;
import com.eguaks.types.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jsska on 05.05.2014.
 */
public class MessageRepository {

    private static List<Message> createMessages(){
        List<Message> messages = new ArrayList<>();
        List<User> users =  UserRepository.createUsers();

        messages.add(new Message(users.get(0), users.get(1), "Hi", "First message", new Date()));
        messages.add(new Message(users.get(1), users.get(0), "Re:Hi", "My reply to your first message. Hello there sir", new Date()));
        messages.add(new Message(users.get(3), users.get(2), "Blabab", "Muhahahasdfhjksahdsa, hasdkjlfhadsf, asdfhlasdf. JALHAL?", new Date()));
        messages.add(new Message(users.get(2), users.get(3), "Re. Blabab", "Iditio!", new Date()));
        messages.add(new Message(users.get(3), users.get(2), "Re. Blabab", "??", new Date()));

        return messages;

    }
}
