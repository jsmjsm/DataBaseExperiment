package Question6.task6;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Task5 {
    static {
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (Exception e) {
            System.out.println("\n Error loading DB2 Driver... \n");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Table k = new Table();
        JFrame MainWindow = new JFrame("表");
        MainWindow.setBounds(500, 100, 700, 800);
        MainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainWindow.setLayout(new BorderLayout());

        // layout
        JPanel JP1 = new JPanel();
        JP1.setPreferredSize(new Dimension(600, 50));
        JPanel JP2 = new JPanel();
        JP2.setPreferredSize(new Dimension(600, 700));
        JPanel JP3 = new JPanel();
        JP3.setPreferredSize(new Dimension(100, 700));
        JPanel JP4 = new JPanel();
        JP4.setPreferredSize(new Dimension(600, 50));

        /*
         * -> JP1
         *
         * @ 点击按钮后读取数据库并且更新
         */
        JLabel info = new JLabel("表格信息: TEMPL");
        info.setPreferredSize(new Dimension(200, 40));
        JButton LoadDataBase = new JButton("载入数据库");
        LoadDataBase.setPreferredSize(new Dimension(100, 40));
        LoadDataBase.setPreferredSize(new Dimension(100, 40));
        LoadDataBase.addActionListener(e -> {
            k.refreshData();
        });
        JP1.add(info);
        JP1.add(LoadDataBase);

        /*
         * -> JP2
         *
         * @ 表格中的显示
         */
        JTable thisTable = k.getTheTable();
        JScrollPane sp = new JScrollPane(thisTable);
        sp.setPreferredSize(new Dimension(550, 650));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JP2.add(sp);

        /*
         * ->JP3
         *
         * @ 1.单行插入 2. 多行插入 3. 子查询插入
         */
        // 单行插入
        JButton InsertOneRow = new JButton("单行插入");
        InsertOneRow.addActionListener(e -> {
            InsertFunction insert = new InsertFunction();
            insert.InsertOneRow();
        });
        // 多行插入
        JButton InsertManyRows = new JButton("多行插入");
        InsertManyRows.addActionListener(e -> {
            InsertFunction insert = new InsertFunction();
            insert.InsertManyRows();
        });

        // 子查询插入
        JButton InsertByCheck = new JButton("子查询插入");
        InsertByCheck.addActionListener(e -> {
            InsertFunction insert = new InsertFunction();
            try {
                insert.InsertWithQuery();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        JP3.add(InsertOneRow);
        JP3.add(InsertManyRows);
        JP3.add(InsertByCheck);

        MainWindow.add(JP1, BorderLayout.NORTH);
        MainWindow.add(JP2, BorderLayout.WEST);
        MainWindow.add(JP3, BorderLayout.EAST);
        MainWindow.add(JP4, BorderLayout.SOUTH);
        MainWindow.setVisible(true);

    }
}
