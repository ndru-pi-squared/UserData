package com.app.event;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.app.session.UserSession;
import com.app.user.UserRole;

public class EventSnapshotterTest {
    
    @Test
    public void testTakeSnapshot() {
        LocalDateTime startTime = LocalDateTime.now();
        String userId = "testUser";
        UserRole userRole = UserRole.USER;

        UserSession session = new UserSession(startTime, userId, userRole);
        EventSnapshotter snapshotter = new EventSnapshotter();
        SessionCreatedEvent event = snapshotter.takeSnapshot(session);

        assertEquals(startTime, event.getSessionStartTime());
        assertEquals(userId, event.getUserID());
        assertEquals(userRole, event.getRole());
    }
}