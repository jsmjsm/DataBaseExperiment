package Question6.task6;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

// Build the table
public class Table {
    private String[][] Data = new String[200][14];
    private String[] tableTitle = new String[] { "EMPNO", "FIRSTNME", "MIDINIT", "LASTNAME", "WORKDEPT", "PHONENO",
            "HIREDATE", "JOB", "EDLEVEL", "SEX", "BIRTHDATE", "SALARY", "BONUS", "COMM" };
    private JTable TheTable;

    // MARK: Init
    Table() throws SQLException {
        int row = 0;
        // TODO: Get connection 的方式可能有变化
        Connection connection = DriverManager.getConnection("jdbc:db2:sample");
        connection.setAutoCommit(false);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, "
                + "JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM" + " FROM EMPLOYEE ");
        while (rs.next()) {
            for (int i = 0; i < 14; i++) {
                if (rs.getString(i + 1).equals(" ")) {
                    Data[row][i] = "空";
                } else {
                    Data[row][i] = rs.getString(i + 1);
                }
            }
            row++;
        }
        rs.close();
        stmt.close();
        // MARK Table
        TableColumn column;
        this.TheTable = new JTable(Data, tableTitle);
        TheTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // 设置列宽
        for (int i = 0; i < 14; i++) {
            column = TheTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(90);
        }
    }

    // 返回表格
    JTable getTheTable() {
        return this.TheTable;
    }

    // refresh data
    void refreshData() {
        try {
            int row = 0;
            // TODO: Get connection 的方式可能有变化
            Connection connection = DriverManager.getConnection("jdbc:db2:sample");
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, HIREDATE, "
                    + "JOB, EDLEVEL, SEX, BIRTHDATE, SALARY, BONUS, COMM" + " FROM EMPLOYEE ");
            // solution for task 6
            while (rs.next()) {
                for (int i = 0; i < 14; i++) {
                    if (rs.getString(i + 1).equals(" ")) {
                        Data[row][i] = "空";
                    } else {
                        Data[row][i] = rs.getString(i + 1);
                    }
                }
                row++;
            }
            rs.close();
            stmt.close();
            TheTable.updateUI(); // updateUI
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
