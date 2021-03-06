package Question1;

import java.sql.*;
import java.lang.*;

public class question1 {
    static {
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String argv[]){
        try {
            Connection con = null;
            String url = "jdbc:db2://127.0.0.1:50000/sample";
            if (argv.length == 0)
            { con = DriverManager.getConnection(url,"db2inst1","db2root-pwd"); }
            else if (argv.length == 2){
                String userid = argv[0];
                String passwd = argv[1];
                con = DriverManager.getConnection(url,"db2inst1","db2root-pwd");
            }
            else
            { throw new Exception
                    ("\n Usage: java MyJDBC[,username,password]\n");}
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT EMPNO, LASTNAME " +
                            " FROM EMPLOYEE " +
                            " WHERE SALARY > 40000 " );
            while ( rs.next() ) {
                System.out.println("empno="+ rs.getString(1) + "   " + "lastname="+ rs.getString(2));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        };
    };
}

