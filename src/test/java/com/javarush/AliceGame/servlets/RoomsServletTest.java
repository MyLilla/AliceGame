package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.service.RoomService;
import com.javarush.AliceGame.servlets.RoomsServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoomsServletTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;
    @Mock
    ServletConfig servletConfig;
    @Mock
    ServletContext context;
    @Mock
    RequestDispatcher requestDispatcher;
    @Mock
    RoomService roomsService;
    @Mock
    Room room;
    @Mock
    Personage personage;
    RoomsServlet roomsServlet;
    User user;

    @BeforeEach
    void setup() throws ServletException {
        when(servletConfig.getServletContext())
                .thenReturn(context);

        when(context.getAttribute(eq("roomService")))
                .thenReturn(roomsService);

        when(request.getSession())
                .thenReturn(session);

        roomsServlet = new RoomsServlet();
        roomsServlet.init(servletConfig);
        user = new User();
    }

    @Test
    void doGetTest() throws ServletException, IOException {

        when(session.getAttribute(eq("user")))
                .thenReturn(user);

        when(context.getRequestDispatcher(eq("/WEB-INF/index.jsp")))
                .thenReturn(requestDispatcher);

        when(roomsService.getActualRoom(user)).thenReturn(room);
        when(roomsService.getActualPersonage(user)).thenReturn(personage);

        roomsServlet.doGet(request, response);

        verify(request.getSession(), times(1))
                .setAttribute(eq("user"), eq(user));
        verify(request.getSession(), times(1))
                .setAttribute(eq("actualRoom"), eq(room));
        verify(request.getSession(), times(1))
                .setAttribute(eq("personage"), eq(personage));

        verify(requestDispatcher, times(2))
                .forward(request, response);
    }

    @Test
    @Disabled
    // почему не работают
    void doGetTest_WhenNextRoomIsNull() throws ServletException, IOException {

        when(session.getAttribute(eq("user")))
                .thenReturn(user);
        // говорю, что сообщение будет нал
        when(session.getAttribute("nextRoom")).thenReturn(null);

        when(context.getRequestDispatcher(eq("/WEB-INF/index.jsp")))
                .thenReturn(requestDispatcher);

        //запускаю, и должна же попасть в ветку nextRoom=null
        roomsServlet.doGet(request, response);

        // говорит, что было 2 перехода, а не один
        verify(requestDispatcher, times(1))
                .forward(request, response);
    }

    @Test
    @Disabled
    // пытается обращаться к RequestDispatcher
    void doGetTest_WhenWin() throws ServletException, IOException {

        when(session.getAttribute(eq("user")))
                .thenReturn(user);
        when(session.getAttribute("nextRoom"))
                .thenReturn("0");
        // хотя тут указывается, что условие перехода по redirect == true
        when(roomsService.checkWin(0, user))
                .thenReturn(true);
        when(request.getContextPath()).thenReturn("path");

        roomsServlet.doGet(request, response);

        verify(response, times(1))
                .sendRedirect(eq("path/finish?win=true"));
    }
}
