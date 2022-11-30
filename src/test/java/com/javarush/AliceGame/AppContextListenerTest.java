package com.javarush.AliceGame;

import com.javarush.AliceGame.dates.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppContextListenerTest {

    @Mock
    ServletContextEvent sce;
    @Mock
    ServletContext context;
    @Mock
    UsersRepository usersRepository;

    AppContextListener contextListener;


    @BeforeEach
    void setup() {
        when(sce.getServletContext()).thenReturn(context);
        contextListener = new AppContextListener();
    }

    @Test
    @Disabled
    void contextInitialized() {

        contextListener.contextInitialized(sce);

        verify(context, times(1))
                .setAttribute("usersRepository", usersRepository);
    }
}
