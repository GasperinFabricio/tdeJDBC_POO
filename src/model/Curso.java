package model;

import dao.ConexionEstabelecida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedHashSet;

public class Curso {
    private int codigo;
    private String nome;
    private int cargaHoraria;
    static private LinkedHashSet<Curso> linkedset = new LinkedHashSet<Curso>();


    public String getNome() {
        return nome;
    }

    public Curso(int codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }
    static public LinkedHashSet<Curso> getListaCurso() {
        return linkedset;
    }
    static public void inserirCurso(int c, String n, int ch) {
        Curso curso = new Curso(c,n,ch);
        linkedset.add(curso);
        String codigo = Integer.toString(c);
        String carga = Integer.toString(ch);
        Connection connection = ConexionEstabelecida.Conexao();

        try {
            String insertSql = "INSERT INTO curso (codigo, nome, carga_horaria) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, codigo);
            preparedStatement.setString(2, n);
            preparedStatement.setString(3, carga);
            preparedStatement.executeUpdate();
            System.out.println("Aluno inserido!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /*
     public void insertAluno(Aluno a) {
         linkedset.add(a);
     }


    public void retrieveAluno() {
        for(int i = 0; i < linkedset.size(); i++) {
            System.out.println(linkedset.iterator().next());
        }
    }
     */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
