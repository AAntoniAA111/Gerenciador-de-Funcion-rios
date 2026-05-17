import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/Geremciamentodefuncionarios";
    private static final String USER = "root";
    private static final String PASSWORD = "W444W43J03Q";

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}
