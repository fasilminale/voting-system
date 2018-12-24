/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting.system;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author pro
 */
public class Server {
    
    public static void main(String args[]){
		 try {
			Registry registry = LocateRegistry.createRegistry(5099);
                        registry.bind("voting", new VotingSystem());
			System.out.println("Server is connected and waiting for the client");
		 }
		catch(Exception e) {
			System.out.println("Server could not connect: "+e);
		}
	}
}
