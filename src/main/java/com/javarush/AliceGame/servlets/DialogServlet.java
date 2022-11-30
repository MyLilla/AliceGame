package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.*;
import com.javarush.AliceGame.service.DialogService;
import org.apache.commons.lang3.ObjectUtils;
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

@WebServlet(name = "DialogServlet", value = "/dialog")
public class DialogServlet extends HttpServlet {
    protected static final Logger LOGGER = LogManager.getLogger(DialogServlet.class);
    DialogService dialogService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        dialogService = (DialogService) context.getAttribute("dialogService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Personage personage = (Personage) request.getSession().getAttribute("personage");
        String nextMessage = request.getParameter("nextMessage");
        LOGGER.info("dialog with: {}, next message: {}", personage.getName(), nextMessage);

        if (ObjectUtils.isEmpty(nextMessage)) {
            LOGGER.debug("next message is empty");
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else {

            Dialog.Message nextMess = dialogService.getMessage(personage, nextMessage);
            LOGGER.info("get next message: {}", nextMess.getId());

            request.setAttribute("answers", nextMess.getAnswers());
            request.setAttribute("textQuestion", nextMess.getText());

            getServletContext().getRequestDispatcher("/WEB-INF/dialog.jsp").forward(request, response);
        }
    }
}
