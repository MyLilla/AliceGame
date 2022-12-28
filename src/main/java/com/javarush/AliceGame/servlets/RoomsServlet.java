package com.javarush.AliceGame.servlets;

import com.javarush.AliceGame.dates.User;
import com.javarush.AliceGame.exceptions.InvalidStateException;
import com.javarush.AliceGame.service.RoomService;
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

@WebServlet(name = "RoomsServlet", value = "/rooms")
public class RoomsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(RoomsServlet.class);
    private RoomService roomService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        roomService = (RoomService) context.getAttribute("roomService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        String nextRoom = request.getParameter("nextRoom");
        LOGGER.info("nextRoom = {} for user: {}", nextRoom, user.getName());

        if (ObjectUtils.isEmpty(nextRoom)) {
            LOGGER.debug("Parameter: nextRoom is null");
            throw new InvalidStateException("Next room can't be null or empty");
        }

        int nextRoomId = roomService.parseNextRoom(nextRoom);

        if (roomService.checkWin(nextRoomId, user)) {
            LOGGER.info("user: {} is winner", user.getName());
            response.sendRedirect(request.getContextPath() + "/finish?win=true");

        } else {
            user.setLocationId(nextRoomId);
            LOGGER.debug("New locationId: {} for user: {}", nextRoom, user);

            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("actualRoom", roomService.getActualRoom(user));
            request.getSession().setAttribute("personage", roomService.getActualPersonage(user));

            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }
    }
}
