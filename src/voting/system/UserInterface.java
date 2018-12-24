/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting.system;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

/**
 *
 * @author pro
 */
public interface UserInterface extends Remote{
    User getUser(int id) throws RemoteException;
    Set<User> getAllUsers() throws RemoteException;
    User getUserByUserNameAndPassword(String user, String pass) throws RemoteException;
    boolean insertUser(User user) throws RemoteException;
    boolean updateUser(User user) throws RemoteException;
    boolean deleteUser(int id) throws RemoteException;
}
