/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class DBConnect {
    Panel panel;

    public DBConnect(Panel panel){
        this.panel = panel;
    }
    
    public ArrayList getQuestions() {
        ArrayList<String> questions = new ArrayList();
        String query, url, user, pass;
        Connection con = null;
        Statement statement = null;
        ResultSet result = null;
        url = "jdbc:MySQL://localhost:3333/herology";
        user = "root";
        pass = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            query = "SELECT * FROM `question`";
            statement = con.createStatement();
            result = statement.executeQuery(query);
            
            while(result.next()){
                questions.add(result.getString("question"));
            }
            
            
        } catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if(con != null){
                    con.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(result != null) {
                    result.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return questions;
    }
    
    public ArrayList getAnswers() {
        ArrayList<String> answers = new ArrayList();
        String query, url, user, pass;
        Connection con = null;
        Statement statement = null;
        ResultSet result = null;
        url = "jdbc:MySQL://localhost:3333/herology";
        user = "root";
        pass = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            query = "SELECT * FROM `question`";
            statement = con.createStatement();
            result = statement.executeQuery(query);
            
            while(result.next()){
                answers.add(result.getString("answer"));
            }
            
            
        } catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if(con != null){
                    con.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(result != null) {
                    result.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return answers;
    }
}
