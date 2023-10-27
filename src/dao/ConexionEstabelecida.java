package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConexionEstabelecida {
    private static String url = "jdbc:postgresql://localhost:5432/Escola";
    private static String user;
    private static String pwd;

    private static Connection connection;
    public static void estabelecerConexao1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao SQL injector.\nDigite o seu usuário:");
        user = scanner.nextLine();
        System.out.println("Certo, insira a senha:");
        pwd = scanner.nextLine();

        try {
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("Conexão estabelecida!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection Conexao(){
        return connection;
    }

}