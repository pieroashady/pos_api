package com.exyna.pos_api.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);

    public void createNotification(NotificationDTO notification) {
        LOG.info("Received notification by module dependency for title {} in date {} content {}.",
                notification.getTitle(),
                notification.getDate(),
                notification.getContent());
    }

    @EventListener
    public void notificationEvent(NotificationDTO event) {
        System.out.println("KESINI");
        // Notification notification = toEntity (event);
        LOG.info("Received notification by module dependency for title {} in date {} content {}..",
                event.getTitle(),
                event.getDate(),
                event.getContent());
    }
}
