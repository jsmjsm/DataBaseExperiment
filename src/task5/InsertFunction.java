package task5;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class InsertFunction {
    InsertFunction() {
    }

    static int changeRow = 0;

    static void up() {
        changeRow++;
    }

    static void down() {
        changeRow--;
    }

    public void InsertOneRow() {
        JFrame getInput = new JFrame();
        String[] data = new String[14];

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

        EMPNO.setPreferredSize(new Dimension(120, 30));
        FIRSTNME.setPreferredSize(new Dimension(120, 30));
        MIDINIT.setPreferredSize(new Dimension(120, 30));
        LASTNAME.setPreferredSize(new Dimension(120, 30));
        WORKDEPT.setPreferredSize(new Dimension(120, 30));
        PHONENO.setPreferredSize(new Dimension(120, 30));
        HIREDATE.setPreferredSize(new Dimension(120, 30));
        JOB.setPreferredSize(new Dimension(120, 30));
        EDLEVEL.setPreferredSize(new Dimension(120, 30));
        SEX.setPreferredSize(new Dimension(120, 30));
        BIRTHDATE.setPreferredSize(new Dimension(120, 30));
        SALARY.setPreferredSize(new Dimension(120, 30));
        BONUS.setPreferredSize(new Dimension(120, 30));
        COMM.setPreferredSize(new Dimension(120, 30));

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

        getInput.setBounds(500, 100, 600, 800);
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

        // Insert Button
        JButton insert = new JButton("插入");
        insert.addActionListener(e1 -> {
            data[0] = getEMPNO.getText();
            data[1] = getFIRSTNME.getText();
            data[2] = getMIDINIT.getText();
            data[3] = getLASTNAME.getText();
            data[4] = getWORKDEPT.getText();
            data[5] = getPHONENO.getText();
            data[6] = getHIREDATE.getText();
            data[7] = getJOB.getText();
            data[8] = getEDLEVEL.getText();
            data[9] = getSEX.getText();
            data[10] = getBIRTHDATE.getText();
            data[11] = getSALARY.getText();
            data[12] = getBONUS.getText();
            data[13] = getCOMM.getText();

            try {
                // TODO: Get connection 的方式可能有变化
                Connection connection = DriverManager.getConnection("jdbc:db2:sample");
                connection.setAutoCommit(false);
                Statement stmt = connection.createStatement();
                String sql = "INSERT INTO EMPLOYEE (EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM)"
                        + "VALUES" + "(" + "'" + data[0] + "'" + ", " + "'" + data[1] + "'" + ", " + "'" + data[2] + "'"
                        + ", " + "'" + data[3] + "'" + ", " + "'" + data[4] + "'" + ", " + "'" + data[5] + "'" + ", "
                        + "'" + data[6] + "'" + ", " + "'" + data[7] + "'" + ", " + data[8] + ", " + "'" + data[9] + "'"
                        + ", " + "'" + data[10] + "'" + ", " + data[11] + ", " + data[12] + ", " + data[13] + ")";

                int k = stmt.executeUpdate(sql);
                System.out.println("Executed!");
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        getInput.add(insert);
        getInput.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getInput.setLayout(new FlowLayout());
        getInput.setVisible(true);
    }

    public void InsertManyRows() {
        JFrame getInput = new JFrame("输入");
        String[][] inputData = new String[100][14];

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

        EMPNO.setPreferredSize(new Dimension(120, 30));
        FIRSTNME.setPreferredSize(new Dimension(120, 30));
        MIDINIT.setPreferredSize(new Dimension(120, 30));
        LASTNAME.setPreferredSize(new Dimension(120, 30));
        WORKDEPT.setPreferredSize(new Dimension(120, 30));
        PHONENO.setPreferredSize(new Dimension(120, 30));
        HIREDATE.setPreferredSize(new Dimension(120, 30));
        JOB.setPreferredSize(new Dimension(120, 30));
        EDLEVEL.setPreferredSize(new Dimension(120, 30));
        SEX.setPreferredSize(new Dimension(120, 30));
        BIRTHDATE.setPreferredSize(new Dimension(120, 30));
        SALARY.setPreferredSize(new Dimension(120, 30));
        BONUS.setPreferredSize(new Dimension(120, 30));
        COMM.setPreferredSize(new Dimension(120, 30));

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
        getInput.setBounds(500, 100, 600, 800);
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
            inputData[changeRow][0] = getEMPNO.getText();
            inputData[changeRow][1] = getFIRSTNME.getText();
            inputData[changeRow][2] = getMIDINIT.getText();
            inputData[changeRow][3] = getLASTNAME.getText();
            inputData[changeRow][4] = getWORKDEPT.getText();
            inputData[changeRow][5] = getPHONENO.getText();
            inputData[changeRow][6] = getHIREDATE.getText();
            inputData[changeRow][7] = getJOB.getText();
            inputData[changeRow][8] = getEDLEVEL.getText();
            inputData[changeRow][9] = getSEX.getText();
            inputData[changeRow][10] = getBIRTHDATE.getText();
            inputData[changeRow][11] = getSALARY.getText();
            inputData[changeRow][12] = getBONUS.getText();
            inputData[changeRow][13] = getCOMM.getText();
            up();
        });

        JButton quit = new JButton("提交数据库");
        quit.addActionListener(e2 -> {
            try {
                Statement stmt = null;
                // TODO: Get connection 的方式可能有变化
                Connection connection = DriverManager.getConnection("jdbc:db2:sample");
                connection.setAutoCommit(false);
                stmt = connection.createStatement();
                while (changeRow > 0) {
                    stmt.executeUpdate(
                            "INSERT INTO EMPLOYEE(EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM)"
                                    + "VALUES(" + "'" + inputData[changeRow][0] + "'" + ", " + "'"
                                    + inputData[changeRow][1] + "'" + ", " + "'" + inputData[changeRow][2] + "'" + ", "
                                    + "'" + inputData[changeRow][3] + "'" + ", " + "'" + inputData[changeRow][4] + "'"
                                    + ", " + "'" + inputData[changeRow][5] + "'" + ", " + "'" + inputData[changeRow][6]
                                    + "'" + ", " + "'" + inputData[changeRow][7] + "'" + ", " + inputData[changeRow][8]
                                    + ", " + "'" + inputData[changeRow][9] + "'" + ", " + "'" + inputData[changeRow][10]
                                    + "'" + ", " + inputData[changeRow][11] + ", " + inputData[changeRow][12] + ", "
                                    + inputData[changeRow][13] + ", ");
                    down();
                }
                connection.commit();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        getInput.add(insert);
        getInput.add(quit);
        getInput.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getInput.setLayout(new BorderLayout());
        getInput.setVisible(true);
    }

    // 子查询插入
    public void InsertWithQuery() throws SQLException {
        JFrame getInput = new JFrame("输入");
        getInput.setBounds(500, 100, 500, 600);

        JLabel label0 = new JLabel("输入查询内容:");
        label0.setPreferredSize(new Dimension(100, 30));
        JTextField getcheck = new JTextField();
        getcheck.setColumns(30);

        JLabel label1 = new JLabel("输入查询的值");
        label1.setPreferredSize(new Dimension(100, 30));
        JTextField get_check_value = new JTextField();
        get_check_value.setColumns(30);

        JLabel label2 = new JLabel("输入插入内容");
        label2.setPreferredSize(new Dimension(100, 30));
        JTextField getinsert = new JTextField();
        getinsert.setColumns(30);

        JButton insert = new JButton("插入");
        insert.addActionListener(e -> {
            String to_check = getcheck.getText();
            String to_check_value = get_check_value.getText();
            String to_insert = getinsert.getText();
            try {
                // TODO: Get connection 的方式可能有变化
                Connection connection = DriverManager.getConnection("jdbc:db2:sample");
                connection.setAutoCommit(false);
                Statement stmt = connection.createStatement();
                String sql = "INSERT INTO EMPLOYEE (" + "'" + to_insert + "'" + ")" + " VALUES(SELECT EMPLOYEE."
                        + to_check + " FROM EMPLOYEE WHERE EMPLOYEE." + to_check + "=" + to_check_value + ")";
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        getInput.add(label0);
        getInput.add(getcheck);
        getInput.add(label1);
        getInput.add(get_check_value);
        getInput.add(label2);
        getInput.add(getinsert);
        getInput.add(insert);

        getInput.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getInput.setLayout(new FlowLayout());
        getInput.setVisible(true);
    }

}
