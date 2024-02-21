package com.exyna.pos_api.users;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.exyna.pos_api.notification.NotificationDTO;
import com.exyna.pos_api.users.internal.Users;

@Service
public class UserService {

    // private final ApplicationEventPublisher events;

    // public UserService(ApplicationEventPublisher events) {
    // this.events = events;
    // }

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationEventPublisher events;

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users save(Users user) {
        events.publishEvent(new NotificationDTO(new Date(), "Judul",
                "Konten"));
        return userRepository.save(user);
    }

}
