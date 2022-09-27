package edu.javacourse.city.web;

import edu.javacourse.city.dao.PersonCheckDAO;
import edu.javacourse.city.dao.PoolConnectionBuilder;
import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(CheckPersonServlet.class);
    private PersonCheckDAO dao;

    @Override
    public void init() throws ServletException {
        logger.info("servlet is created");
        dao = new PersonCheckDAO();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String surname = req.getParameter("surname");

        PersonRequest personRequest = new PersonRequest();
        personRequest.setSurName(req.getParameter("surName"));
        personRequest.setGivenName(req.getParameter("givenName"));
        personRequest.setPatronymic(req.getParameter("patronymic"));
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        personRequest.setDateOfBirth(dateOfBirth);
        personRequest.setStreetCode(Integer.parseInt(req.getParameter("streetCode")));
        personRequest.setBuilding(req.getParameter("building"));
        personRequest.setExtension(req.getParameter("extension"));
        personRequest.setApartment(req.getParameter("apartment"));
        try {
            PersonResponse response = dao.checkPerson(personRequest);
            if (response.isRegistered()) {
                resp.getWriter().write("registered");
            } else {
                resp.getWriter().write("not_registered");
            }
        } catch (PersonCheckException e) {
            resp.getWriter().write(e.toString());
        }
    }
}
