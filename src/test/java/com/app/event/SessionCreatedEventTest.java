package com.app.event;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.app.user.UserRole;

public class SessionCreatedEventTest {
    
    private final LocalDateTime fixed = LocalDateTime.of(2024, 1, 1, 12, 0);

    @Test
    void shouldCreateSessionCreatedEvent() {
        SessionCreatedEvent event = new SessionCreatedEvent(fixed, "user123", UserRole.ADMIN);
        assertEquals(fixed, event.getSessionTimeInit());
        assertEquals("user123", event.getUserID());
        assertEquals(UserRole.ADMIN, event.getRole());
    }
}