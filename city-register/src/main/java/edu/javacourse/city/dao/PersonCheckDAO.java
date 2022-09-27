package edu.javacourse.city.dao;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDAO {

    private static final String SQL_REQUEST = """
            SELECT temporal FROM cr_address_person ap
            INNER JOIN cr_person p ON p.person_id = ap.person_id
            INNER JOIN cr_address a ON a.address_id = ap.address_id
            WHERE\s
            upper(p.sur_name) = upper(?)\s
            and upper(p.given_name) = upper(?)
            and upper(p.patronymic) = upper(?)
            and p.date_of_birth = ?
            and a.street_code = ?\s
            and upper(a.building) = upper(?)
            """;

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();
        String sql = SQL_REQUEST;
        if (request.getExtension() != null) {
            sql += "and upper(a.extension) = upper(?) ";
        } else {
            sql += "and a.extension is null ";
        }
        if (request.getApartment() != null) {
            sql += "and upper(a.apartment) = upper(?) ";
        } else {
            sql += "and a.apartment is null ";
        }
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            int count = 1;
            statement.setString(count++, request.getSurName());
            statement.setString(count++, request.getGivenName());
            statement.setString(count++, request.getPatronymic());
            statement.setDate(count++, Date.valueOf(request.getDateOfBirth()));
            statement.setInt(count++, request.getStreetCode());
            statement.setString(count++, request.getBuilding());
            if (request.getExtension() != null) {
                statement.setString(count++, request.getExtension());
            }
            if (request.getApartment() != null) {
                statement.setString(count++, request.getApartment());
            }
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                response.setRegistered(true);
                response.setTemporal(resultSet.getBoolean("temporal"));
            }

        } catch (SQLException e) {
            throw new PersonCheckException(e);
        }
        return response;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }
}