package br.edu.ifpb.padroes.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO<T>{

	protected String arquivoBanco;
	
	public DAO(String arquivoBanco) {
        this.arquivoBanco = arquivoBanco;
        
    }
	 protected Connection connect() {
		 try (Connection connection = DriverManager.getConnection("jdbc:sqlite:"+this.arquivoBanco)) {
			 Statement statement = connection.createStatement();

	            //Criando tabela de usuários
	            statement.execute("CREATE TABLE IF NOT EXISTS USUARIO( ID INTEGER, NOME VARCHAR, LOGIN VARCHAR, SENHA VARCHAR )");
	            statement.execute("INSERT INTO USUARIO( ID, NOME, LOGIN, SENHA) VALUES (1, 'admin', 'admin', '123')");

	            //Criando tabela de produtos
	            statement.execute("CREATE TABLE IF NOT EXISTS USUARIO( ID INTEGER, NOME VARCHAR, LOGIN VARCHAR, SENHA VARCHAR )");
	            statement.execute("INSERT INTO USUARIO( ID, NOME, LOGIN, SENHA) VALUES (1, 'admin', 'admin', '123')");

	            PreparedStatement stmt = connection.prepareStatement("select * from USUARIO");
	            ResultSet resultSet = stmt.executeQuery();

	            while (resultSet.next()) {
	                Integer id = resultSet.getInt("ID");
	                String nome = resultSet.getString("NOME");

	                System.out.println( id + " - " + nome);
	            }

	            return connection;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	 }
}
