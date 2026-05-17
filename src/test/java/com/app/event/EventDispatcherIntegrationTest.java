package com.app.event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.app.logging.LogLevel;
import com.app.logging.LoggerService;
import com.app.session.UserSession;
import com.app.user.UserRole;

public class EventDispatcherIntegrationTest {
    
    @Test
    public void testDispatch() throws IOException{
        LocalDateTime startTime = LocalDateTime.now();
        String userId = "testUser";
        UserRole userRole = UserRole.USER;
        Path path = Path.of("data/log.txt");
        UserSession session = new UserSession(startTime, userId, userRole);
        EventSnapshotter snapshotter = new EventSnapshotter();
        SessionCreatedEvent event = snapshotter.takeSnapshot(session);
        LoggerService loggerService = new LoggerService();
        SessionCreatedEventListener listener = new SessionCreatedEventListener(loggerService);
        EventDispatcher dispatcher = new EventDispatcher(listener);
        dispatcher.dispatch(event); //calls SessionCreatedEventListener.onevent() 
                                    //which does this: loggerService.logEvent(new LogEvent(event.getSessionStartTime(), LogLevel.INFO, event.getRole().toString() +" session initiated")); 
                                    //and logevent does this: public void logEvent(LogEvent event){System.out.println(event.toString()); logToFile.append(event.toString() +"\n");
        //for now, just print the event to console with its level
        List<String> lines = Files.readAllLines(path);
        String lastLine = lines.get(lines.size() - 1);
        String formattedLogEntry = String.format("[%s] [%s] %s session initiated", startTime, LogLevel.INFO, userRole);
        assertEquals(formattedLogEntry, lastLine);
    }

}