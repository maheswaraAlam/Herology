/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Control;

import Home.Login;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Question extends javax.swing.JFrame {

    /**
     * Creates new form Question
     */
    public Question() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 175, 15));

        jLabel1.setText("ID");

        jTable1.setBackground(new java.awt.Color(135, 206, 235));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Question", "Answer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setBounds(new java.awt.Rectangle(0, 0, 1100, 600));
        jTable1.setPreferredSize(new java.awt.Dimension(1100, 600));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(461);
        }

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("Short Question Only, Limit 225 Word");
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(jTextArea1);

        jTextField1.setToolTipText("");

        jLabel2.setText("Question");

        jTextField2.setToolTipText("Integer Only, Limit 999");

        jLabel3.setText("Correct Answer");

        jLabel4.setText("Filter");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Insert");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Export");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Exit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Student");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField3)
                                .addComponent(jTextField2)
                                .addComponent(jTextField1)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model;
       
       String query, url, user, pass;
            url = "jdbc:MySQL://localhost:3333/herology";
            user = "root";
            pass = "";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                query = "SELECT * FROM `question`";
                Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery(query);
                
                String[] columnNames = {"ID","Question","Answer"};
                model = new DefaultTableModel(columnNames, 0);
                
                while(result.next()){
                    Object[] object = {
                        result.getString("ID"),
                        result.getString("question"),
                        result.getString("answer")
                    };
                    model.addRow(object);
                }
                jTable1.setModel(model);
                
                for(int i = 0; i < jTable1.getColumnCount(); i++) {
                    Class<?> column = jTable1.getColumnClass(i);
                    jTable1.setDefaultEditor(column, null);
                }
                
            } catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model;
        
        String ID, question, answer, query, duplicate, IDB = null, 
                   url, user, pass;
            url = "jdbc:MySQL://localhost:3333/herology";
            user = "root";
            pass = "";
            int found = 0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                duplicate = "SELECT * FROM `question`";
                PreparedStatement prestatement = con.prepareStatement(duplicate);
                Statement statement;
                ResultSet preresult = prestatement.executeQuery();
                
                //Error Requirement
                if("".equals(jTextField2.getText()) || 
                   "".equals(jTextArea1.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Please Fill The Question and the Answer", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    //Checking Verification
                    question = jTextArea1.getText();
                    answer = jTextField2.getText();
                    ID = (LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmssddMMyy")));
                    
                    // SQL Query
                    query = "INSERT INTO `question` (`ID`, `question`, `answer`) VALUES ('"+ID+"','"+question+"','"+answer+"')";
                    statement = con.createStatement();
                    
                    while(preresult.next()){
                            IDB = preresult.getString("ID");
                            found = 1;
                        }
                    
                    if(found == 1 && ID.equals(IDB)) {
                        JOptionPane.showMessageDialog(new JFrame(), "", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        statement.execute(query);
                        JOptionPane.showMessageDialog(new JFrame(), "New Quiz Inserted", "Information",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (ClassNotFoundException | SQLException e){
                 System.out.println(e.getMessage());
            }
            jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel model;
        
        String IDcheck, ID, question, answer, query, duplicate, questionDB = null,
                   url, user, pass;
            url = "jdbc:MySQL://localhost:3333/herology";
            user = "root";
            pass = "";
            int found = 0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                duplicate = "SELECT * FROM `question`";
                PreparedStatement prestatement = con.prepareStatement(duplicate);
                Statement statement;
                ResultSet preresult = prestatement.executeQuery();
                
                //Error Requirement
                if("".equals(jTextField2.getText()) || 
                   "".equals(jTextArea1.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Please Fill The Question and The Answer", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    //Checking Verification
                    ID = (LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmssddMMyy")));
                    IDcheck = jTextField1.getText();
                    answer = jTextField2.getText();
                    question = jTextArea1.getText();
                    
                    // SQL Query
                    query = "UPDATE `question` SET `ID` = '"+ID+"', "
                            + "`question` = '"+question+"', "
                            + "`answer` = '"+answer+"' "
                            + "WHERE `ID` = '"+IDcheck+"'";
                    statement = con.createStatement();
                    
                    while(preresult.next()){
                            questionDB = preresult.getString("question");
                            found = 1;
                        }
                    
                    if(found == 1 && ID.equals(questionDB)) {
                        JOptionPane.showMessageDialog(new JFrame(), "Quiz Already Taken", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        statement.execute(query);
                    }
                }
            } catch (ClassNotFoundException | SQLException e){
                 System.out.println(e.getMessage());
            }
            jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        String ID = model.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String question = model.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String answer = model.getValueAt(jTable1.getSelectedRow(), 2).toString();
        
        jTextField1.setText(ID);
        jTextField2.setText(answer);
        jTextArea1.setText(question);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        String query, url, user, pass;
            url = "jdbc:MySQL://localhost:3333/herology";
            user = "root";
            pass = "";
        PreparedStatement prestatement;
        String ID = model.getValueAt(jTable1.getSelectedRow(), 0).toString();
        int row = jTable1.getSelectedRow();
        
        if(row != -1) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                query = "DELETE FROM `question` WHERE `ID` = '"+ID+"'";
                prestatement = con.prepareStatement(query);
                prestatement.executeUpdate();
                model.removeRow(row);
                
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Failed To Delete Selected Data", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select One Row To Delete", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        jTextField1.setText("");
        jTextField2.setText("");
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String query, url, user, pass;
            url = "jdbc:MySQL://localhost:3333/herology";
            user = "root";
            pass = "";
        Connection con = null;
        PreparedStatement prestatement = null;
        ResultSet result = null;
        BufferedWriter writer = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
                
                query = "SELECT * FROM `question`";
                prestatement = con.prepareStatement(query);
                result = prestatement.executeQuery();
                
                writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "/Downloads/questions.csv"));
                CSVPrinter printer = new CSVPrinter(writer, CSVFormat.EXCEL.withHeader(result));
                printer.printRecords(result);
                printer.close(true);
                
                JOptionPane.showMessageDialog(new JFrame(), "File Successfully Exported", "Information",
                                    JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Failed To Export Data", "Error", 
                        JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if(writer != null)
                        writer.close();

                    if(result != null)
                        result.close();

                    if(prestatement != null)
                        prestatement.close();

                    if(con != null)
                        con.close();
                } catch (SQLException | IOException e) {
                    System.out.println(e.getMessage());
                }
            }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Student.run();
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> table = new TableRowSorter<> (model);
        jTable1.setRowSorter(table);
        
        String filter = jTextField3.getText();
        
        table.setRowFilter(RowFilter.regexFilter(filter));
    }//GEN-LAST:event_jTextField3KeyReleased

    /**
     */
    public static void run() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Question question = new Question();
            question.jTextField1.setEditable(false);
            question.setLocation(150, 150);
            question.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}