package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.dates.UsersRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/init")
public class InitServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(RoomsServlet.class);
    private UsersRepository usersRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        usersRepository = (UsersRepository) context.getAttribute("usersRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(true);
        LOGGER.debug("create new session. id: {}", session.getId());

        User user = usersRepository.fetchUserByUsername(request.getParameter("name"));

        if (user == null) {
            LOGGER.debug("User is null after create");
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else {

            LOGGER.info("got user: {}", user);
            session.setAttribute("user", user);
            LOGGER.info("user {} saved in session {} ", user, request.getSession());

            response.sendRedirect(request.getContextPath() + "/rooms?nextRoom=0");
        }
    }
}
