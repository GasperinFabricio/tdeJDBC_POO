package controller;
import dao.*;
import model.*;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            ConexionEstabelecida.estabelecerConexao1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(true) {
            System.out.println("Qual seria a opção desejada?");
            System.out.println("1 - Inserir Aluno\n2 - Listar Alunos\n");
            System.out.println("3 - Inserir Curso\n4 - Listar Cursos");
            Scanner sc = new Scanner(System.in);
            int op = Integer.parseInt(sc.nextLine());
            i
            switch (op){
                case 1:
                    String n;
                    String m;
                    String c;
                    System.out.println("Diga-me o nome.\n");
                    n = sc.nextLine();
                    System.out.println("Diga-me a matricula\n");
                    m = sc.nextLine();
                    System.out.println("Diga me o curso\n");
                    int auxMatricula = Integer.parseInt(m);
                    LinkedHashSet<Curso> a = Curso.getListaCurso();
                    if(a.isEmpty()) {
                        System.out.println("Não há cursos cadastrados!");
                        break;
                    }
                    for(int i = 0; i < a.size(); i++) {
                        System.out.println(i + "-" + a.iterator().next().getNome() + " ");
                        if(i % 2 == 0) {
                            System.out.println("\n");
                        }
                    }
                    System.out.println("\n--------------------------\nEscolha o curso pelo seu número:");
                    Curso escolhido = null;
                    int choice = Integer.parseInt(sc.nextLine());
                    for(int i = 0; i < a.size(); i++) {
                        a.iterator().next();
                        if(i == choice)
                            escolhido = a.iterator().next();
                    }
                    Aluno.insertAluno(n,auxMatricula,escolhido);
                case 2:

                case 3:
                    String codigo;
                    String nomeCurso;
                    String cargaHorariaCurso;
                    System.out.println("Diga-me o codigo.\n");
                    codigo = sc.nextLine();
                    System.out.println("Diga-me a nome\n");
                    nomeCurso = sc.nextLine();
                    System.out.println("Diga me o carga horaria\n");
                    cargaHorariaCurso = sc.nextLine();
                    int auxCodigo = Integer.parseInt(codigo);
                    int auxCargaHoraria = Integer.parseInt(cargaHorariaCurso);
                    Curso.inserirCurso(auxCodigo, nomeCurso, auxCargaHoraria);
                case 4:
                default:
                    break;
            }

            break;
        }
        try {
            ConexionEstabelecida.Conexao().close();
        } catch( Exception e) {
            e.printStackTrace();
        }
    }
}
