package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.*;
import com.javarush.AliceGame.service.QuestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DialogServlet", value = "/dialog")
public class DialogServlet extends HttpServlet {
    protected static final Logger LOGGER = LogManager.getLogger(DialogServlet.class);
    ArrayList<Dialog> dialogs;
    QuestService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        dialogs = (ArrayList<Dialog>) context.getAttribute("dialogs");
        service = (QuestService) context.getAttribute("questService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Personage personage = (Personage) request.getSession().getAttribute("personage");
        String nextMessage = request.getParameter("nextMessage");

        if (nextMessage.isEmpty()) {
            LOGGER.debug("next message i empty");
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }

        Dialog.Message nextMess = service.getMessage(personage, nextMessage);
        LOGGER.info("get next message: {}", nextMess.getId());

        request.setAttribute("answers", nextMess.getAnswers());
        request.setAttribute("textQuestion", nextMess.getText());

        getServletContext().getRequestDispatcher("/WEB-INF/dialog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String invent = request.getParameter("getInvent");

        service.checkQuestStatus(user, invent);

        request.getSession().setAttribute("user", user);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
