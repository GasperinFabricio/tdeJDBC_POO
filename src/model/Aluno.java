package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedHashSet;

import dao.ConexionEstabelecida;

public class Aluno {
    private String nome;
    private int matricula;

    private Curso curso;
    static public LinkedHashSet<Aluno> linkedset = new LinkedHashSet<Aluno>();
    public Aluno(String n, int m, Curso c){
        this.nome = n;
        this.matricula = m;
        this.curso = c;
    }

    static public void insertAluno(String n, int m, Curso c) {
        Aluno a = new Aluno(n,m,c);
        String matri = Integer.toString(m);
        String curso = c.getNome();
        linkedset.add(a);
        Connection connection = ConexionEstabelecida.Conexao();

        try {
            String insertSql = "INSERT INTO aluno (matricula, nome, curso) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, matri);
            preparedStatement.setString(2, n);
            preparedStatement.setString(3, curso);
            preparedStatement.executeUpdate();
            System.out.println("Aluno inserido!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
