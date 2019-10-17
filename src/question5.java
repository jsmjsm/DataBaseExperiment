import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class question5 {
    static {
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        }catch (Exception e){
            System.out.println("\n Error loading DB2 Driver... \n");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception{
        String[][] Information = new String[1000][14];

        JFrame MainWindow = new JFrame("表");
        MainWindow.setBounds(500,100,600,800);
        MainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainWindow.setLayout(new BorderLayout());

        //界面布局
        JPanel JP1 = new JPanel();
        JP1.setPreferredSize(new Dimension(600,50));
        JPanel JP2 = new JPanel();
        JP2.setPreferredSize(new Dimension(450,650));
        JPanel JP3 = new JPanel();
        JP3.setPreferredSize(new Dimension(150,500));
        JPanel JP4 = new JPanel();
        JP4.setPreferredSize(new Dimension(600,100));

        JTable Tabel = new JTable();

        //
        JScrollPane sp = new JScrollPane(Tabel);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JP2.add(sp);

        //表格头
        String[] tableTitle = new String[]{"EMPNO", "FIRSTNME","MIDINIT","LASTNAME","WORKDEPT","PHONENO","HIREDATE","JOB","EDLEVEL","SEX","BIRTHDATE","SALARY","BONUS","COMM"};

        //第一次启动时将数据库信息录入
        try {
            //行
            int row = 0;
            Connection connection = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","db2inst1","db2root-pwd");
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, " +
                    "JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM"
                    + " FROM EMPLOYEE ");
            while ( rs.next() ) {
                Information[row][0] = rs.getString(1);
                Information[row][1] = rs.getString(2);
                Information[row][2] = rs.getString(3);
                Information[row][3] = rs.getString(4);
                Information[row][4] = rs.getString(5);
                Information[row][5] = rs.getString(6);
                Information[row][6] = rs.getString(7);
                Information[row][7] = rs.getString(8);
                Information[row][8] = rs.getString(9);
                Information[row][9] = rs.getString(10);
                Information[row][10]= rs.getString(11);
                Information[row][11]= rs.getString(12);
                Information[row][12]= rs.getString(13);
                Information[row][13]= rs.getString(14);
                row++;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        /*
        JP1,最上层操作
        点击按钮后读取数据库信息并更新
         */

        JButton LoadDataBase = new JButton("载入数据库");
        LoadDataBase.setPreferredSize(new Dimension(100,50));
        LoadDataBase.addActionListener(e -> {
            try {
                //行
                int row = 0;
                Connection connection = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","db2inst1","db2root-pwd");
                connection.setAutoCommit(false);
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, " +
                        "JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM"
                         + " FROM EMPLOYEE ");
                while ( rs.next() ) {
                    Information[row][0] = rs.getString(1);
                    Information[row][1] = rs.getString(2);
                    Information[row][2] = rs.getString(3);
                    Information[row][3] = rs.getString(4);
                    Information[row][4] = rs.getString(5);
                    Information[row][5] = rs.getString(6);
                    Information[row][6] = rs.getString(7);
                    Information[row][7] = rs.getString(8);
                    Information[row][8] = rs.getString(9);
                    Information[row][9] = rs.getString(10);
                    Information[row][10]= rs.getString(11);
                    Information[row][11]= rs.getString(12);
                    Information[row][12]= rs.getString(13);
                    Information[row][13]= rs.getString(14);
                    row++;
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        JP1.add(LoadDataBase);

        /*
        JP2操作
        1.读取数据库中数据
        2.显示
        3.进行操作后刷新
         */



        MainWindow.add(JP1,BorderLayout.NORTH);
        MainWindow.add(JP2,BorderLayout.WEST);
        MainWindow.add(JP3,BorderLayout.EAST);
        MainWindow.add(JP4,BorderLayout.SOUTH);
        MainWindow.setVisible(true);
    }

}
