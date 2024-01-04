import java.sql.*;

public class MiPrimerPrograma {

    public static void main(String[] args) {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "mydbuser", "mydbuser");

            // mydb is databas
            // mydebuser is name of database
            // mydbuser is password of database

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from designation");
            int code;
            String title;
            while (resultSet.next()) {
                code = resultSet.getInt("code");
                title = resultSet.getString("title").trim();
                System.out.println("Code: " + code + " Title: " + title);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}