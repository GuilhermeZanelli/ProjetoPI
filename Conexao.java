package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//classe responsavel por conectar o banco de dados com o sistema
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/poliedro_sdm";
    private static final String USUARIO = "root";
    private static final String SENHA = "imtdb";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}