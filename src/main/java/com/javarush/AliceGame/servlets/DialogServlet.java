package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name="DialogServlet", value = "/dialog")
public class DialogServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        String quest = request.getParameter("quest");
        if (quest != null) {

            getServletContext().getRequestDispatcher("/WEB-INF/dialog.jsp").forward(request, response);
        }

        Room room = (Room) request.getSession().getAttribute("actualRoom");
        Dialog dialog = room.getPersonage().getDialog();

        List<Dialog.Message> questions = dialog.getQuestions();  // лист вопросов

        String textQuestion;
        List<Dialog.Answer> answers;

        String nextQuestion = request.getParameter("nextQuestion");

            Integer nextQuestionId = Integer.parseInt(nextQuestion);
            if (nextQuestionId == questions.size()) {
                getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }

            answers = questions.get(nextQuestionId).getAnswers();
            textQuestion = questions.get(nextQuestionId).getText();

        request.setAttribute("room", room.getName());
        request.setAttribute("answers", answers);
        request.setAttribute("textQuestion", textQuestion);

        getServletContext().getRequestDispatcher("/WEB-INF/dialog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect(request.getContextPath() + "/dialog?nextQuestion=0");
    }
}
