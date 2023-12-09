package manager;

import domain.Program;
import repository.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAO {
    private static final String SELECT_ALL_PROGRAMS = "SELECT * FROM organaizer.public.events";
    private static final String INSERT_PROGRAM = "INSERT INTO organaizer.public.events (type, date, time, description) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_PROGRAM = "UPDATE organaizer.public.events SET type = ?, date = ?, time = ?, description = ? WHERE id = ?";
    private static final String DELETE_PROGRAM = "DELETE FROM organaizer.public.events WHERE id = ?";

    public List<Program> getAllPrograms() {
        List<Program> programs = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PROGRAMS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Program program = new Program();
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

    public void addProgram(Program program) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PROGRAM)) {

            statement.setString(1, program.getType());
            statement.setString(2, program.getDate());
            statement.setString(4, program.getTime());
            statement.setString(3, program.getDescription());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProgram(Program program) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PROGRAM)) {

            statement.setString(1, program.getType());
            statement.setString(2, program.getDate());
            statement.setString(4, program.getTime());
            statement.setString(3, program.getDescription());
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
