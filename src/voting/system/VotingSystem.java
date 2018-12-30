package voting.system;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.server.*;
import java.rmi.RemoteException;
import java.sql.Connection;

import java.util.Set;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class VotingSystem extends UnicastRemoteObject implements VotingInterface{

    public VotingSystem() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId( rs.getInt("user_id") );
        user.setEmail(rs.getString("email"));
        user.setAge( rs.getInt("age") );
        user.setUsername( rs.getString("username") );
        user.setPass( rs.getString("password") );

        return user;
    }
    

    @Override
    public User getUser(int id) throws RemoteException{
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE user_id=" + id);
            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Set<User> getAllUsers() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
            Set users = new HashSet();
            while(rs.next())
            {
                User user = extractUserFromResultSet(rs);
                users.add(user);
                System.out.println(user);
            }
            return users;
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByUserNameAndPassword(String user, String pass) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Users WHERE username=? AND password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertUser(User user) throws RemoteException{
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Users VALUES (NULL, ?, ?, ?, ?)");
            ps.setString(1, user.getEmail());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPass());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateUser(User user) throws RemoteException {
         Connection connection = ConnectionFactory.getConnection();
         try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Users SET email=?, age=?, username=?, password=? WHERE user_id=?");
            ps.setString(1, user.getEmail());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPass());
            ps.setInt(5, user.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
         }

         return false;
    }

    @Override
    public boolean deleteUser(int id) throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM Users WHERE user_id=" + id);
            if(i == 1) {
                return true;
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
        }
    
    private Competitor extractCompetitorFromResultSet(ResultSet rs) throws SQLException {
        Competitor competitor = new Competitor();
        competitor.setId( rs.getInt("competitor_id") );
        competitor.setName(rs.getString("name"));
        competitor.setAge( rs.getInt("age") );
        competitor.setJob(rs.getString("job") );
        competitor.setDetail(rs.getString("detail") );
        competitor.setCount(rs.getInt("count") );
        competitor.setElectionId(rs.getInt("election_id"));
        

        return competitor;
    }
    
    

    @Override
    public Competitor getCompetitor(int id) throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Competitors WHERE competitor_id=" + id);
            if(rs.next())
            {
                return extractCompetitorFromResultSet(rs);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
        
    }
    
    @Override
    public Set<Competitor> getCompetitorsByElectionID(int id) throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Competitors WHERE election_id=" + id);
            Set competitors = new HashSet();
            while(rs.next())
            {
                Competitor competitor = extractCompetitorFromResultSet(rs);
                competitors.add(competitor);
            }
            return competitors;
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
        
    }

    @Override
    public Set<Competitor> getAllCompetitor() throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Competitors");
            Set competitors = new HashSet();
            while(rs.next())
            {
                Competitor competitor = extractCompetitorFromResultSet(rs);
                competitors.add(competitor);
            }
            return competitors;
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertCompetitor(Competitor competitor) throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Competitors VALUES (NULL, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, competitor.getName());
            ps.setInt(2, competitor.getAge());
            ps.setString(3, competitor.getJob());
            ps.setString(4, competitor.getDetail());
            ps.setInt(5, competitor.getCount());
            ps.setInt(6, competitor.getElectionId());
            
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateCompetitor(Competitor competitor) throws RemoteException {
         Connection connection = ConnectionFactory.getConnection();
         try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Competitors SET name=?, age=?, job=?, detail=?, count=?, election_id=? WHERE competitor_id=?");
            ps.setString(1, competitor.getName());
            ps.setInt(2, competitor.getAge());
            ps.setString(3, competitor.getJob());
            ps.setString(4, competitor.getDetail());
            ps.setInt(5, competitor.getCount());
            ps.setInt(6, competitor.getElectionId());
            ps.setInt(7, competitor.getId());
            
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
         }

         return false;
    }

    @Override
    public boolean deleteCompetitor(int id) throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM Competitors WHERE competitor_id=" + id);
            if(i == 1) {
                return true;
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    private Election extractElectionFromResultSet(ResultSet rs) throws SQLException {
        Election election= new Election();
        election.setId( rs.getInt("election_id") );
        election.setName(rs.getString("name"));
        election.setType(rs.getString("type") );
        election.setDetail(rs.getString("detail") );
        election.setStatus(rs.getBoolean("status") );
        election.setResult(rs.getString("result") );
        System.out.print(rs.getString("result") );
        
        

        return election;
    }

    @Override
    public Election getElection(int id) throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Elections WHERE election_id=" + id);
            if(rs.next())
            {
//                System.out.print(extractElectionFromResultSet(rs).getName());
                return extractElectionFromResultSet(rs);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Set<Election> getAllElection() throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Elections");
            Set elections = new HashSet();
            while(rs.next())
            {
                Election election = extractElectionFromResultSet(rs);
                elections.add(election);
            }
            return elections;
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertElection(Election election) throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Elections VALUES (NULL, ?, ?, ?, ?, ?)");
            ps.setString(1, election.getName());
            ps.setString(2, election.getType());
            ps.setString(3, election.getDetail());
            ps.setBoolean(4, election.getStatus());
            ps.setString(5, election.getResult());
            
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateElection(Election election) throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();
         try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Elections SET name=?, type=?, detail=?, status=?, result=? WHERE election_id=?");
            ps.setString(1, election.getName());
            ps.setString(2, election.getType());
            ps.setString(3, election.getDetail());
            ps.setBoolean(4, election.getStatus());
            ps.setString(5, election.getResult());
            ps.setInt(5, election.getId());
            
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
         }

         return false;
    }

    @Override
    public boolean deleteElection(int id) throws RemoteException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM Elections WHERE election_id=" + id);
            if(i == 1) {
                return true;
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
}


