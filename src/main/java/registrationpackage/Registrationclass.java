package registrationpackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class Registrationclass
 */
public class Registrationclass extends HttpServlet {
	private static final long serialVersionUid = 1L;
	 private static final String dburl="jdbc:mysql://localhost:3306/sumagodb";
     private static final String jdbcusername="root";
     private static final String jdbcpassword="sam1312";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrationclass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "Add":
                    addStudent(request, response);
                    break;
                case "Delete":
                    deleteStudent(request, response);
                   
                    break;
                
                case "Update":
                    updateStudent(request, response);
                    break;
                default:
                    response.sendRedirect("Registration.jsp");
                    break;
            }
        } else {
            response.sendRedirect("Registration.jsp");
        }
    }
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String grade = request.getParameter("grade");

        try (Connection conn = DriverManager.getConnection(dburl,jdbcusername,jdbcpassword )) {
            String sql = "insert into sumago (id,name, age, grade) values (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.setString(4, grade);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("Registration.jsp");
    }
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idtodelet = Integer.parseInt(request.getParameter("id"));
        try (Connection conn = DriverManager.getConnection(dburl,jdbcusername,jdbcpassword)) {
            String sql = "delete from sumago where id=?"; 
 
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idtodelet);
            statement.executeUpdate();
            
            String updateSql = "update sumago set id = id - 1 where id > ?";
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);
            updateStatement.setInt(1, idtodelet);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("Registration.jsp");
    }
	

	
	 private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        int age = Integer.parseInt(request.getParameter("age"));
	        String grade = request.getParameter("grade");
	        try (Connection conn = DriverManager.getConnection(dburl,jdbcusername,jdbcpassword)) {
	            String sql = "update sumago set id=?,name=?, age=?, grade=? ";	          
	            PreparedStatement statement = conn.prepareStatement(sql);    
	            statement.setInt(1, id);
	            statement.setString(2, name);
	            statement.setInt(3, age);
	            statement.setString(4, grade);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        response.sendRedirect("Registration.jsp");
	    }
}




