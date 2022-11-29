package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.UsersRepository;
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
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class FinishServletTest {
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

    FinishServlet finishServlet;
    User user;

    @BeforeEach
    void setup() throws ServletException {
        when(servletConfig.getServletContext())
                .thenReturn(context);

        when(context.getAttribute(eq("usersRepository")))
                .thenReturn(usersRepository);

        when(request.getSession())
                .thenReturn(session);

        finishServlet = new FinishServlet();
        finishServlet.init(servletConfig);

        user = new User();
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        when(request.getSession().getAttribute("user"))
                .thenReturn(user);

        when(usersRepository.resetProgress(user))
                .thenReturn(user);

        when(request.getParameter(eq("win")))
                .thenReturn("true");

        when(context.getRequestDispatcher(eq("/WEB-INF/finish.jsp")))
                .thenReturn(requestDispatcher);

        finishServlet.doGet(request, response);

        verify(request.getSession(), times(1))
                .setAttribute(eq("user"), eq(user));
        verify(request, times(1))
                .setAttribute(eq("win"), eq("true"));

        verify(requestDispatcher, times(1))
                .forward(request, response);
    }
}