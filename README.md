# voting-system
 	Java voting system api using rmi.

## Usage
###### insert example
```
VotingInterface vi=(VotingInterface)Naming.lookup("rmi://localhost:5099/voting");
Election election = new Election("Books Awards", "Entertemnet", "2011, spt - 2011, Dec books award", true, "");
vi.insertElection(election);

Competitor competitor1 = new Competitor("Eferem Seyume",32,"Writer, Artist, Poet","He has written many books since 1995", 0,2);
Competitor competitor2 = new Competitor("Ysmake Worku",29,"Artist, Writer, Poet","Writer of Dertogada, Toa-series", 0,2);
vi.insertCompetitor(competitor1);
vi.insertCompetitor(competitor2);
```
###### update count example
```
Competitor competitor = vi.getCompetitor(9);
competitor.setCount(competitor.getCount() + 1);
vi.updateCompetitor(competitor);
```
###### login example
```
User user = getUserByUserNameAndPassword("username", "password");
if (user != null){
    //successfull
    
}
```


######

