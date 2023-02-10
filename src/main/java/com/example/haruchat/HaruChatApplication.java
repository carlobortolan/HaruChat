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
        try {
            System.out.println("STARTING INPUT 0");
            User a = new Moderator(0, "password", "admin", "carlo.bortolan@tum.de", null, null, null, null);
            a.promoteToAdmin();
            userService.save(a);

            System.out.println("STARTING INPUT 1");
            for (int i = 2; i < 100; i++) {
                userService.save(new BasicUser(i, "" + Math.random() * 1000000, "user" + i + "", "user" + i + "@email.com", null, null, null, null, ZonedDateTime.now()));
                System.out.println("ADDED " + i);
            }

            System.out.println("STARTING INPUT 2");
            for (int i = 1; i < 100; i++) {
                LinkedList<User> participants = new LinkedList<User>();
                participants.add(userService.findById(i));
                participants.add(userService.findById((i + 1) % 99 + 1));
                participants.add(userService.findById((i + 2) % 99 + 1));
                participants.add(userService.findById((i + 3) % 99 + 1));
                GroupChat groupChat = new GroupChat(participants, null, "Group Nr." + i, "Description " + i, 512, null);
                conversationService.save(groupChat);
                for (User u : participants) {
                    if (u != null) {
                        //u.getChats().add(groupChat);
                        messageService.save(new Message(u, "content", groupChat, 0));
                    }
                }
            }
            System.out.println("END");
        } catch (Exception e) {
            System.out.println("SOME EXCEPTION OCCURRED");
            e.printStackTrace();
        }
    }

}
