package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.service.DialogService;
import com.javarush.AliceGame.service.RoomService;
import com.javarush.AliceGame.servlets.DialogServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DialogServletTest {

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
    DialogService dialogService;

    DialogServlet dialogServlet;
    Personage personage;
    Dialog.Message nextMess;

    @BeforeEach
    void setup() throws ServletException {
        when(servletConfig.getServletContext())
                .thenReturn(context);

        when(context.getAttribute(eq("dialogService")))
                .thenReturn(dialogService);

        when(request.getSession())
                .thenReturn(session);

        dialogServlet = new DialogServlet();
        dialogServlet.init(servletConfig);

        personage = Personage.builder()
                .id(0)
                .name("whiteRabbit")
                .imgPath("img/rabbit.png\" width=\"300\" height=\"500")
                .build();

        nextMess = Dialog.Message.builder()
                .id(0)
                .text("message text")
                .answers(List.of(Dialog.Answer.builder()
                        .text("answer one").
                        nextQuestion(1).build())).build();
    }

    @Test
    void doGetTest() throws ServletException, IOException {

        when(session.getAttribute(eq("personage")))
                .thenReturn(personage);
        when(request.getParameter("nextMessage"))
                .thenReturn("1");

        when(dialogService.getMessage(personage, "1"))
                .thenReturn(nextMess);

        when(context.getRequestDispatcher(eq("/WEB-INF/dialog.jsp")))
                .thenReturn(requestDispatcher);

        dialogServlet.doGet(request, response);

        verify(request, times(1))
                .setAttribute(eq("answers"), eq(nextMess.getAnswers()));
        verify(request, times(1))
                .setAttribute(eq("textQuestion"), eq(nextMess.getText()));

        verify(requestDispatcher, times(1))
                .forward(request, response);
    }

    @Test
    @Disabled
    void doGetTest_WhenNextMessageIsEmpty() throws ServletException, IOException {

        when(session.getAttribute(eq("personage")))
                .thenReturn(personage);
        when(request.getParameter("nextMessage"))
                .thenReturn("");

        when(context.getRequestDispatcher(eq("/WEB-INF/index.jsp")))
                .thenReturn(requestDispatcher);

        dialogServlet.doGet(request, response);

        verify(requestDispatcher, times(1))
                .forward(request, response);
    }
}
