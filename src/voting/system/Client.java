/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting.system;
import java.net.FileNameMap;
import java.rmi.Naming;
import java.util.Set;
import sun.java2d.loops.MaskFill;
/**
 *
 * @author pro
 */
public class Client {
    
    public static void main(String args[]) {
	 	try {
			 VotingInterface vi=(VotingInterface)Naming.lookup("rmi://localhost:5099/voting");
                         
                         //insert example
                         /**
                         
                         Election election = new Election("Books Awards", "Entertemnet", "2011, spt - 2011, Dec books award", true, "");
                         vi.insertElection(election);
                         
                         Competitor competitor1 = new Competitor("Eferem Seyume",32,"Writer, Artist, Poet","he has wrote many books since 1995", 0,2);
                         Competitor competitor2 = new Competitor("Ysmake Worku",29,"Artist, Writer, Poet","Writer of Dertogada, Toa-series", 0,2);
                         vi.insertCompetitor(competitor1);
                         vi.insertCompetitor(competitor2);
                         * 
                         * 
                         * */
                         
                         //update count example
                         
//                         Competitor competitor = vi.getCompetitor(9);
//                         competitor.setCount(competitor.getCount() + 1);
//                         
//                         vi.updateCompetitor(competitor);
                         Set<Election> elections = vi.getAllElection();
                         for(Election election:elections){
                             System.out.println(election.getName());
                         }
                         
                         
                         
                        
		}
		catch(Exception e){
			System.out.println("Client Exception: "+e);
		}
	}
    
    
    
}
