package com.example.haruchat;

import com.example.haruchat.entity.*;
import com.example.haruchat.service.ConversationService;
import com.example.haruchat.service.MessageService;
import com.example.haruchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.ZonedDateTime;
import java.util.LinkedList;

@SpringBootApplication
public class HaruChatApplication {

    @Autowired
    private ConversationService conversationService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    //    @PrintLog
    public static void main(String[] args) {
        SpringApplication.run(HaruChatApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void execCodeAfterStartup() {
        System.out.println("STARTING INPUT");
        for (int i = 0; i < 1000; i++) {
            userService.save(new BasicUser(i, "" + Math.random() * 1000000, "user" + i + "", "user" + i + "@email.com", null, null, null, null, ZonedDateTime.now()));
        }

        for (int i = 0; i < 1000; i++) {
            LinkedList<User> participants = new LinkedList<User>();
            participants.add(userService.findById(i));
            participants.add(userService.findById((i + 1) % 1000));
            participants.add(userService.findById((i + 2) % 1000));
            participants.add(userService.findById((i + 3) % 1000));
            GroupChat groupChat = new GroupChat(participants, null, "Group Nr." + i, "Description " + i, 512, null);
            conversationService.save(groupChat);
            for (User u : participants) {
                if (u != null) {
                    //u.getChats().add(groupChat);
                    messageService.save(new Message(u, "content", groupChat, 0));
                }
            }
        }
        userService.save(new Moderator(0, "pwpwpwpw", "cb", "carlo.bortolan@tum.de", null, null, null, null));
        System.out.println("END");
    }

}
