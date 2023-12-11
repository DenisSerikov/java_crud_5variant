package programDatabase;

import models.Organizer;
import repository.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizerDatabase {
    private static final String SELECT_ALL_PROGRAMS = "SELECT * FROM organizer.public.events";
    private static final String INSERT_PROGRAM = "INSERT INTO organizer.public.events (type, date, time, description) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_PROGRAM = "UPDATE organizer.public.events SET type = ?, date = ?, time = ?, description = ? WHERE id = ?";
    private static final String DELETE_PROGRAM = "DELETE FROM organizer.public.events WHERE id = ?";

    public List<Organizer> getAllPrograms() {
        List<Organizer> programs = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PROGRAMS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Organizer program = new Organizer();
                program.setId(resultSet.getInt("id"));
                program.setType(resultSet.getString("type"));
                program.setDate(resultSet.getString("date"));
                program.setTime(resultSet.getString("time"));
                program.setDescription(resultSet.getString("description"));

                programs.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return programs;
    }

    public void addProgram(Organizer program) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PROGRAM)) {

            statement.setString(1, program.getType());
            statement.setString(2, program.getDate());
            statement.setString(3, program.getDescription());
            statement.setString(4, program.getTime());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProgram(Organizer program) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PROGRAM)) {

            statement.setString(1, program.getType());
            statement.setString(2, program.getDate());
            statement.setString(3, program.getDescription());
            statement.setString(4, program.getTime());
            statement.setInt(5, program.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProgram(int id) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PROGRAM)) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
