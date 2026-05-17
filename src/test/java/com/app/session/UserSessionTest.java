package com.app.session;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.app.user.UserRole;

public class UserSessionTest {
    
    @Test
    public void testUserSessionCreation() {

        LocalDateTime startTime = LocalDateTime.now();
        String userId = "testUser";
        UserRole userRole = UserRole.USER;

        UserSession session = new UserSession(startTime, userId, userRole);

        assertEquals(startTime, session.getStartTime());
        assertEquals(userId, session.getUserID());
        assertEquals(userRole, session.getRole());
    }
    
}