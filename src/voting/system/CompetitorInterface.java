package voting.system;

import java.rmi.*;
import java.util.Set;

public interface CompetitorInterface extends Remote{
    
    Set<Competitor> getCompetitorsByElectionID(int id) throws RemoteException;  //using election id
    Competitor getCompetitor(int id) throws RemoteException;
    
    Set<Competitor> getAllCompetitor() throws RemoteException;
    boolean insertCompetitor(Competitor competitor) throws RemoteException;
    boolean updateCompetitor(Competitor competitor) throws RemoteException;
    boolean deleteCompetitor(int id) throws RemoteException; 
}
    
