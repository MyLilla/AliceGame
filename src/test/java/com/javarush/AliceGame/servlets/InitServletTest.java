package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.dates.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
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
class InitServletTest {

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
    UsersRepository usersRepository;

    InitServlet initServlet;
    User user;

    @BeforeEach
    void setup() throws ServletException {
        when(servletConfig.getServletContext())
                .thenReturn(context);

        when(context.getAttribute(eq("usersRepository")))
                .thenReturn(usersRepository);

        when(request.getSession(true))
                .thenReturn(session);

        initServlet = new InitServlet();
        initServlet.init(servletConfig);

        user = new User();
    }

    @Test
    void doGetTest() throws ServletException, IOException {

        when(request.getParameter("name"))
                .thenReturn("name");
        when(usersRepository.getUserObj("name"))
                .thenReturn(user);
        when(request.getContextPath())
                .thenReturn("path");

        initServlet.doGet(request, response);

        verify(session, times(1))
                .setAttribute(eq("user"), eq(user));

        verify(response, times(1))
                .sendRedirect(eq("path/rooms?nextRoom=0"));

    }

    @Test
    void doGetTest_WhenUserIsNull() throws ServletException, IOException {

        when(request.getParameter("name"))
                .thenReturn("name");
        when(usersRepository.getUserObj("name"))
                .thenReturn(null);

        when(context.getRequestDispatcher(eq("/WEB-INF/index.jsp")))
                .thenReturn(requestDispatcher);

        initServlet.doGet(request, response);

        verify(requestDispatcher, times(1))
                .forward(request, response);
    }
}
