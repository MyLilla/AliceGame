package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.service.DialogService;
import com.javarush.AliceGame.service.QuestService;
import com.javarush.AliceGame.servlets.QuestServlet;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestServletTest {

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
    QuestService questService;

    QuestServlet questServlet;
    User user;

    @BeforeEach
    void setup() throws ServletException {
        when(servletConfig.getServletContext())
                .thenReturn(context);

        when(context.getAttribute(eq("questService")))
                .thenReturn(questService);

        when(request.getSession())
                .thenReturn(session);

        questServlet = new QuestServlet();
        questServlet.init(servletConfig);

        user = new User();

        when(session.getAttribute("user"))
                .thenReturn(user);

        when(request.getParameter("getInvent"))
                .thenReturn("inventExample");

    }

    @Test
    void doGetTest_RedirectWhenCheckFailTrue() throws IOException, ServletException {

        when(questService.checkFail("inventExample"))
                .thenReturn(true);
        when(request.getContextPath())
                .thenReturn("path");

        questServlet.doGet(request, response);

        verify(response, times(1))
                .sendRedirect(eq("path/finish?win=false"));
    }

    @Test
    void doGetTest_RedirectWhenCheckFailFalse() throws IOException, ServletException {

        when(questService.checkFail("inventExample"))
                .thenReturn(false);

        when(context.getRequestDispatcher(eq("/WEB-INF/index.jsp")))
                .thenReturn(requestDispatcher);

        questServlet.doGet(request, response);

        verify(session, times(1))
                .setAttribute(eq("user"), eq(user));

        verify(requestDispatcher, times(1))
                .forward(request, response);
    }

    @Test
    void doPostTest() throws ServletException, IOException {
        when(context.getRequestDispatcher(eq("/WEB-INF/index.jsp")))
                .thenReturn(requestDispatcher);

        questServlet.doPost(request, response);

        verify(session, times(1))
                .setAttribute(eq("user"), eq(user));
        verify(requestDispatcher, times(1))
                .forward(request, response);
    }
}