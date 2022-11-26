package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.User;
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


@WebServlet (name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {

    protected static final Logger LOGGER = LogManager.getLogger(QuestServlet.class);

    QuestService questService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        questService = (QuestService) context.getAttribute("questService");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String invent = request.getParameter("getInvent");
        LOGGER.debug("used invent: {}", invent);

            if (questService.checkFail(invent)){
                response.sendRedirect(request.getContextPath() + "/finish?win=false");
            } else {

                questService.usedInvent(user, invent);

                request.getSession().setAttribute("user", user);
                getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String invent = request.getParameter("getInvent");
        LOGGER.debug("get invent: {}", invent);

        questService.addInventToUser(user, invent);

        request.getSession().setAttribute("user", user);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
