package voting.system;

import java.rmi.*;
import java.util.Set;

public interface ElectionInterface extends Remote{
    
    Election getElection(int id) throws RemoteException;  //using election id
    Set<Election> getAllElection() throws RemoteException;
    boolean insertElection(Election election) throws RemoteException;
    boolean updateElection(Election election) throws RemoteException;
    boolean deleteElection(int id) throws RemoteException; 
    
    
}
