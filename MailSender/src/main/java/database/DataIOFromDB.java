package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import com.data.UserData;

public class DataIOFromDB {
	static PreparedStatement ps;
	
	public static void setDataIntoDB(String name,String gMail,String gPassword,String uPassword,String gender) {
		String query="insert into userdata(name,gmail,gPassword,uPassword,gender) values(?,?,?,?,?)";
		try {
			ps=DataBaseConnection.getConnection().prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, gMail);
			ps.setString(3, gPassword);
			ps.setString(4, uPassword);
			ps.setString(5, gender);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "You are successfuly registered");
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("This record is already exiest !");
				JOptionPane.showMessageDialog(null, "This record is already exiest !");
			}
			e.printStackTrace();
		}
	}
	public static void getDataFromDB(String gmail,String ePassword) {
//		Statement statement = null;
		String query="select gPassword,uPassword from userdata where gmail = ?";
		try {
			ps = DataBaseConnection.getConnection().prepareStatement(query);
//			System.out.println(DataBaseConnection.getConnection());
			ps.setString(1, gmail);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {
			String uPassword=resultSet.getString(2);
			String gPassword=resultSet.getString(1);
			if(ePassword.equals(uPassword)) {
				UserData.uEmail=gmail;
				UserData.uPassword=gPassword;
			}else {
				JOptionPane.showMessageDialog(null, "Invalid emal or password !");
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean forgetPassword(String email) {
		String gPassword="";
		String query="select gPassword from userdata where gmail=?";
		try {
			ps=DataBaseConnection.getConnection().prepareStatement(query);
			ps.setString(1, email);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {
				gPassword=resultSet.getString(1);
				if(!(gPassword.isBlank())) {
					UserData.uEmail=email;
					UserData.uPassword=gPassword;
					return true;
				}else {
					System.out.println("Email is Invlid");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static int  setPassword(String newPassword) {
		int temp=0;
		String query="update userdata set uPassword=? where gmail=?";
		try {
			ps=DataBaseConnection.getConnection().prepareStatement(query);
			ps.setString(1, newPassword);
			ps.setString(2, UserData.uEmail);
			temp=ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}
}
