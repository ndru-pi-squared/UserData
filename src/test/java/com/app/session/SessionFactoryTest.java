package com.app.session;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.app.user.UserRole;
public class SessionFactoryTest {
    
    @Test
    void shouldCreateUserSessionWithCorrectData(){
        LocalDateTime now = LocalDateTime.now();
        UserSession session = SessionFactory.createUserSession(now, "testUserID", UserRole.ADMIN);
        assertEquals(now, session.getStartTime());
        assertEquals("testUserID", session.getUserID());
        assertEquals(UserRole.ADMIN, session.getRole());
    }
}