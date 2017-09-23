package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Circle;
import model.Line;
import model.Point;
import model.Rectangle;
import model.Shape;
import model.User;

public class UserManager {
	public static User currentUser;

	public static void signIn(String userName,String password){
		try{
			Database.init();
			ResultSet rs=Database.getSql("SELECT * from paint.users where userName='"+userName+"' and password='"+password+"';");

			if(rs.next()){

				currentUser=new User(rs.getString("userName"),rs.getString("password"));


			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			Database.close();
		}
	}
	
	public static List<Shape> getShapes(){
		
			List<Shape> shapes=new ArrayList<Shape>();
			try{
				Database.init();
				ResultSet rs=Database.getSql("Select * from paint.rectangles where userName='"+currentUser.getUserName()+"'");
				while(rs.next()){
					shapes.add(new Rectangle(new Point(rs.getInt("startX"),rs.getInt("startY")),new Point(rs.getInt("endX"),rs.getInt("endY")),rs.getInt("color")));
				}
				
				 rs=Database.getSql("Select * from paint.circles where userName='"+currentUser.getUserName()+"'");
				while(rs.next()){
					shapes.add(new Circle(new Point(rs.getInt("startX"),rs.getInt("startY")),new Point(rs.getInt("endX"),rs.getInt("endY")),rs.getInt("color")));
				}
				
				 rs=Database.getSql("Select * from paint.line where userName='"+currentUser.getUserName()+"'");
				while(rs.next()){
					shapes.add(new Line(new Point(rs.getInt("startX"),rs.getInt("startY")),new Point(rs.getInt("endX"),rs.getInt("endY")),rs.getInt("color")));
				}
				
				return shapes;
				
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				return null;
			}
			
		}
	
	public static void addShape(Shape s) {
		Database.init();
			if(s instanceof Rectangle){
				Database.updateSql("Insert into rectangles (startX,startY,endX,endY,userName,color) values('"+s.getStartPoint().getX()+"','"+s.getStartPoint().getY()+"','"+s.getEndPoint().getX()+"','"+s.getEndPoint().getY()+"','"+currentUser.getUserName()+"','"+s.getIntColor()+"')");
			}
			else if(s instanceof Circle){
				Database.updateSql("Insert into circles (startX,startY,endX,endY,userName,color) values('"+s.getStartPoint().getX()+"','"+s.getStartPoint().getY()+"','"+s.getEndPoint().getX()+"','"+s.getEndPoint().getY()+"','"+currentUser.getUserName()+"','"+s.getIntColor()+"')");
			}
			
			else if(s instanceof Line){
				Database.updateSql("Insert into line (startX,startY,endX,endY,userName,color) values("+s.getStartPoint().getX()+","+s.getStartPoint().getY()+","+s.getEndPoint().getX()+","+s.getEndPoint().getY()+",'"+currentUser.getUserName()+"',"+s.getIntColor()+")");
			}
		
		Database.close();
	}
	
	public static void deleteShapes(){
		Database.init();
		Database.updateSql("delete from line where userName='"+currentUser.getUserName()+"'");
		Database.updateSql("delete from circles where userName='"+currentUser.getUserName()+"'");
		Database.updateSql("delete from rectangles where userName='"+currentUser.getUserName()+"'");
		Database.close();
	}

	public static void signup(String userName, String password)throws Exception {
		Database.init();
		ResultSet rs=Database.getSql("Select * from users where userName='"+userName+"'");
		if(!rs.next())
		Database.updateSql("insert into users (userName,password) values ('"+userName+"','"+password+"')");
		else
			throw new Exception("Duplicate userName");
		Database.close();
	}
	
}
