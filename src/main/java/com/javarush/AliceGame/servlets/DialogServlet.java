package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.*;
import com.javarush.AliceGame.service.DialogService;

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

@WebServlet (name="DialogServlet", value = "/dialog")
public class DialogServlet extends HttpServlet {
    ArrayList <Dialog> dialogs;
    DialogService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        dialogs = (ArrayList<Dialog>) context.getAttribute("dialogs");
        service = new DialogService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        Personage personage = (Personage) request.getSession().getAttribute("personage");


        String nextMassage = request.getParameter("nextMassage");

        if (nextMassage.isEmpty()) {
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }

        Dialog dialog = dialogs.get(personage.getId());

        List<Dialog.Message> messages = dialog.getMessages();


            Integer nextQuestionId = Integer.parseInt(nextMassage);


        List<Dialog.Answer> answers = messages.get(nextQuestionId).getAnswers();
        String textQuestion = messages.get(nextQuestionId).getText();


        request.setAttribute("answers", answers);
        request.setAttribute("textQuestion", textQuestion);

        getServletContext().getRequestDispatcher("/WEB-INF/dialog.jsp").forward(request, response);
    }

}
