package com.eguaks.data;

import com.eguaks.types.Message;

import java.util.List;

/**
 * Created by JohnSigvald on 09/05/2014.
 */
public interface MessageRepository {

    Message findOne(String id);

    List<Message> getAll(String userId);

    void sendMessage(Message message);

    void deleteMessage(String messageId);
}
