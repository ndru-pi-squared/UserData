package com.app.event;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EventDispatcherTest {

    @Test
    public void testDispatch() {

        SessionCreatedEventListener listener =
                mock(SessionCreatedEventListener.class);

        EventDispatcher dispatcher =
                new EventDispatcher(listener);

        SessionCreatedEvent event =
                mock(SessionCreatedEvent.class);

        dispatcher.dispatch(event);

        verify(listener).onEvent(event);
    }
}