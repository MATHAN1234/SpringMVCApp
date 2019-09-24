package com.pro.model;

import com.pro.bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataProvider {
    public String writeData(User user) throws ClassNotFoundException, SQLException {
        boolean flag=false;
        MyDb db=new MyDb();
        Connection con=db.getCon();
        Statement st =con.createStatement();
        ResultSet results=st.executeQuery("select username from users");
        while(results.next()){
            String CheckUser=results.getString("username");
            if(CheckUser.equals(user.getUserName())){
                flag=true;
                return "Cannot Register: "+user.getUserName()+ " UserName is already taken";
            }
        }
        results.close();
        if(!flag) {
            st.executeUpdate("insert into users(username,password,fullname) values('"+user.getUserName()+"','"+user.getPassword()+"','"+user.getFullName()+"')");
        }
        return "";
    }

    //Login user method in database
    public String[] readData(User user) throws ClassNotFoundException, SQLException{
        MyDb db=new MyDb();
        ResultSet result;
        Connection con=db.getCon();
        Statement st =con.createStatement();
        result=st.executeQuery("Select username,password,fullname from users");
        while(result.next()){
            String DataId=result.getString("username");
            String DataPass=result.getString("password");
            String DataName=result.getString("FullName");
            if((DataId.equals(user.getUserName()))&&(DataPass.equals(user.getPassword()))){
                return new String[]{ "success", DataName };
            }
        }
        return new String[]{ "", ""};
    }

}

