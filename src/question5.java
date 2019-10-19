import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

//Table类，实现获取数据，初始化，更新表格
class Table {
    private String[][] Data = new String[500][14];
    private String[] TableTitle = new String[]{"EMPNO", "FIRSTNME","MIDINIT","LASTNAME","WORKDEPT","PHONENO",
            "HIREDATE","JOB","EDLEVEL","SEX","BIRTHDATE","SALARY","BONUS","COMM"};
    private JTable TheTable;

    //初始化程序
    Table() throws SQLException {
        int row = 0;
        Connection connection = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","db2inst1","db2root-pwd");
        connection.setAutoCommit(false);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, " +
                "JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM"
                + " FROM EMPLOYEE ");
        while ( rs.next() ) {
            Data[row][0] = rs.getString(1);
            Data[row][1] = rs.getString(2);
            Data[row][2] = rs.getString(3);
            Data[row][3] = rs.getString(4);
            Data[row][4] = rs.getString(5);
            Data[row][5] = rs.getString(6);
            Data[row][6] = rs.getString(7);
            Data[row][7] = rs.getString(8);
            Data[row][8] = rs.getString(9);
            Data[row][9] = rs.getString(10);
            Data[row][10]= rs.getString(11);
            Data[row][11]= rs.getString(12);
            Data[row][12]= rs.getString(13);
            Data[row][13]= rs.getString(14);
            row++;
        }
        rs.close();
        stmt.close();
        this.TheTable = new JTable(Data,TableTitle);
        TheTable.setPreferredSize(new Dimension(450,800));
    }

    //返回表格
    JTable getTheTable(){
        return this.TheTable;
    }

    //更新数据
    void refreshData(){
        try{
            int row = 0;
            Connection connection = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","db2inst1","db2root-pwd");
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, " +
                    "JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM"
                    + " FROM EMPLOYEE ");
            while ( rs.next() ) {
                Data[row][0] = rs.getString(1);
                Data[row][1] = rs.getString(2);
                Data[row][2] = rs.getString(3);
                Data[row][3] = rs.getString(4);
                Data[row][4] = rs.getString(5);
                Data[row][5] = rs.getString(6);
                Data[row][6] = rs.getString(7);
                Data[row][7] = rs.getString(8);
                Data[row][8] = rs.getString(9);
                Data[row][9] = rs.getString(10);
                Data[row][10]= rs.getString(11);
                Data[row][11]= rs.getString(12);
                Data[row][12]= rs.getString(13);
                Data[row][13]= rs.getString(14);
                row++;
            }
            rs.close();
            stmt.close();
            TheTable.updateUI();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


public class question5 {
    static {
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        }catch (Exception e){
            System.out.println("\n Error loading DB2 Driver... \n");
            e.printStackTrace();
        }
    }

    static int changerow = 0;

    static void up(){
        changerow++;
    }
    
    static void down(){
        changerow--;
    }

    public static void main(String[] args) throws Exception{
        Table k = new Table();
        JFrame MainWindow = new JFrame("表");
        MainWindow.setBounds(500,100,700,800);
        MainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainWindow.setLayout(new BorderLayout());

        //界面布局
        JPanel JP1 = new JPanel();
        JP1.setPreferredSize(new Dimension(600,50));
        JPanel JP2 = new JPanel();
        JP2.setPreferredSize(new Dimension(450,800));
        JPanel JP3 = new JPanel();
        JP3.setPreferredSize(new Dimension(150,500));
        JPanel JP4 = new JPanel();
        JP4.setPreferredSize(new Dimension(600,100));

        /*
        JP1,最上层操作
        点击按钮后读取数据库信息并更新
         */
        JButton LoadDataBase = new JButton("载入数据库");
        LoadDataBase.setPreferredSize(new Dimension(100,50));
        LoadDataBase.addActionListener(e -> {
            k.refreshData();
        });
        JP1.add(LoadDataBase);

        //JP2中表格的显示
        JTable thisTabel = k.getTheTable();
        JScrollPane sp = new JScrollPane(thisTabel);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JP2.add(sp);

        /*
        JP3中操作：
        1.单行插入
        2.多行插入
        3.子查询插入
         */
        //单行插入
        JButton InsertOneRow = new JButton("单行插入");
        InsertOneRow.addActionListener(e -> {
            String[] data = new String[14];
            data[0] = JOptionPane.showInputDialog(null,"EMPNO值输入:","输入", JOptionPane.PLAIN_MESSAGE);
            data[1] = JOptionPane.showInputDialog(null,"FIRSTNME值输入:","输入", JOptionPane.PLAIN_MESSAGE);
            data[2] = JOptionPane.showInputDialog(null,"MIDINIT值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[3] = JOptionPane.showInputDialog(null,"LASTNAME值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[4] = JOptionPane.showInputDialog(null,"WORKDEPT值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[5] = JOptionPane.showInputDialog(null,"PHONENO值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[6] = JOptionPane.showInputDialog(null,"HIREDATE值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[7] = JOptionPane.showInputDialog(null,"JOB值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[8] = JOptionPane.showInputDialog(null,"EDLEVEL值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[9] = JOptionPane.showInputDialog(null,"SEX值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[10] = JOptionPane.showInputDialog(null,"BIRTHDATE值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[11] = JOptionPane.showInputDialog(null,"SALARY值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[12] = JOptionPane.showInputDialog(null,"BONUS值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            data[13] = JOptionPane.showInputDialog(null,"COMM值输入:","输入",JOptionPane.PLAIN_MESSAGE);
            try {
                Connection connection = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","db2inst1","db2root-pwd");
                connection.setAutoCommit(false);
                Statement stmt = connection.createStatement();
                String sql = "INSERT INTO SAMPLE VALUES("+data[0]+", "+data[1]+", "+data[2]+", "+data[3]+", "+data[4]+", "
                        +data[5]+", "+data[6]+", "+data[7]+", "+data[8]+", "+data[9]+", "+data[10]+", "+data[11]+", "+data[12]+", "+data[13]+", ";
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


        //多行插入
        JButton InsertManyRows = new JButton("多行插入");
        InsertManyRows.addActionListener(e -> {
            JFrame getInput = new JFrame("输入");

            String[][] inputdata = new String[100][14];

            JLabel EMPNO = new JLabel("EMPNO");
            JLabel FIRSTNME = new JLabel("FIRSTNME");
            JLabel MIDINIT = new JLabel("MIDINIT");
            JLabel LASTNAME = new JLabel("LASTNAME");
            JLabel WORKDEPT = new JLabel("WORKDEPT");
            JLabel PHONENO = new JLabel("PHONENO");
            JLabel HIREDATE = new JLabel("HIREDATE");
            JLabel JOB = new JLabel("JOB");
            JLabel EDLEVEL = new JLabel("EDLEVEL");
            JLabel SEX = new JLabel("SEX");
            JLabel BIRTHDATE = new JLabel("BIRTHDATE");
            JLabel SALARY = new JLabel("SALARY");
            JLabel BONUS = new JLabel("BONUS");
            JLabel COMM = new JLabel("COMM");
            EMPNO.setPreferredSize(new Dimension(120,30));
            FIRSTNME.setPreferredSize(new Dimension(120,30));
            MIDINIT.setPreferredSize(new Dimension(120,30));
            LASTNAME.setPreferredSize(new Dimension(120,30));
            WORKDEPT.setPreferredSize(new Dimension(120,30));
            PHONENO.setPreferredSize(new Dimension(120,30));
            HIREDATE.setPreferredSize(new Dimension(120,30));
            JOB.setPreferredSize(new Dimension(120,30));
            EDLEVEL.setPreferredSize(new Dimension(120,30));
            SEX.setPreferredSize(new Dimension(120,30));
            BIRTHDATE.setPreferredSize(new Dimension(120,30));
            SALARY.setPreferredSize(new Dimension(120,30));
            BONUS.setPreferredSize(new Dimension(120,30));
            COMM.setPreferredSize(new Dimension(120,30));

            JTextField getEMPNO = new JTextField();
            JTextField getFIRSTNME = new JTextField();
            JTextField getMIDINIT = new JTextField();
            JTextField getLASTNAME = new JTextField();
            JTextField getWORKDEPT = new JTextField();
            JTextField getPHONENO = new JTextField();
            JTextField getHIREDATE = new JTextField();
            JTextField getJOB = new JTextField();
            JTextField getEDLEVEL = new JTextField();
            JTextField getSEX = new JTextField();
            JTextField getBIRTHDATE = new JTextField();
            JTextField getSALARY = new JTextField();
            JTextField getBONUS = new JTextField();
            JTextField getCOMM = new JTextField();
            getEMPNO.setColumns(40);
            getFIRSTNME.setColumns(40);
            getMIDINIT.setColumns(40);
            getLASTNAME.setColumns(40);
            getWORKDEPT.setColumns(40);
            getPHONENO.setColumns(40);
            getHIREDATE.setColumns(40);
            getJOB.setColumns(40);
            getEDLEVEL.setColumns(40);
            getSEX.setColumns(40);
            getBIRTHDATE.setColumns(40);
            getSALARY.setColumns(40);
            getBONUS.setColumns(40);
            getCOMM.setColumns(40);


            getInput.setBounds(500,100,600,800);
            getInput.add(EMPNO);
            getInput.add(getEMPNO);
            getInput.add(FIRSTNME);
            getInput.add(getFIRSTNME);
            getInput.add(MIDINIT);
            getInput.add(getMIDINIT);
            getInput.add(LASTNAME);
            getInput.add(getLASTNAME);
            getInput.add(WORKDEPT);
            getInput.add(getWORKDEPT);
            getInput.add(PHONENO);
            getInput.add(getPHONENO);
            getInput.add(HIREDATE);
            getInput.add(getHIREDATE);
            getInput.add(JOB);
            getInput.add(getJOB);
            getInput.add(EDLEVEL);
            getInput.add(getEDLEVEL);
            getInput.add(SEX);
            getInput.add(getSEX);
            getInput.add(BIRTHDATE);
            getInput.add(getBIRTHDATE);
            getInput.add(SALARY);
            getInput.add(getSALARY);
            getInput.add(BONUS);
            getInput.add(getBONUS);
            getInput.add(COMM);
            getInput.add(getCOMM);

            JButton insert = new JButton("插入");
            insert.addActionListener(e1 -> {
                inputdata[changerow][0] = getEMPNO.getText();
                inputdata[changerow][1] = getFIRSTNME.getText();
                inputdata[changerow][2] = getMIDINIT.getText();
                inputdata[changerow][3] = getLASTNAME.getText();
                inputdata[changerow][4] = getWORKDEPT.getText();
                inputdata[changerow][5] = getPHONENO.getText();
                inputdata[changerow][6] = getHIREDATE.getText();
                inputdata[changerow][7] = getJOB.getText();
                inputdata[changerow][8] = getEDLEVEL.getText();
                inputdata[changerow][9] = getSEX.getText();
                inputdata[changerow][10] = getBIRTHDATE.getText();
                inputdata[changerow][11] = getSALARY.getText();
                inputdata[changerow][12] = getBONUS.getText();
                inputdata[changerow][13] = getCOMM.getText();
                up();
            });
            
            JButton quit = new JButton("退出");
            quit.addActionListener(e2 -> {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","db2inst1","db2root-pwd");
                    connection.setAutoCommit(false);
                    Statement stmt = connection.createStatement();
                    while(changerow > 0){
                        stmt.executeUpdate("INSERT INTO SAMPLE VALUES("+inputdata[changerow][0]+", "+inputdata[changerow][1]+", "+
                                inputdata[changerow][2]+", "+inputdata[changerow][3]+", "+inputdata[changerow][4]+", "
                                +inputdata[changerow][5]+", "+inputdata[changerow][6]+", "+inputdata[changerow][7]+", "+
                                inputdata[changerow][8]+", "+inputdata[changerow][9]+", "+inputdata[changerow][10]+", "+inputdata[changerow][11]+", "+
                                inputdata[changerow][12]+", "+inputdata[changerow][13]+", ");
                        down();
                    }
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });

            getInput.add(insert);
            getInput.add(quit);
            getInput.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getInput.setLayout(new FlowLayout());
            getInput.setVisible(true);
         });

        //子查询插入
        JButton InsertByCheck = new JButton("子查询插入");
        InsertByCheck.addActionListener(e -> {
            JFrame Check = new JFrame("子查询插入");
            Check.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            JLabel checkinfo = new JLabel("查询指令");

        });

        JP3.add(InsertOneRow);
        JP3.add(InsertManyRows);

        MainWindow.add(JP1,BorderLayout.NORTH);
        MainWindow.add(JP2,BorderLayout.WEST);
        MainWindow.add(JP3,BorderLayout.EAST);
        MainWindow.add(JP4,BorderLayout.SOUTH);
        MainWindow.setVisible(true);
    }

}

