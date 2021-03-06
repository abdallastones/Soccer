package soccer;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private Goal[] goals;
    
    public Game(){}
    public Game(Team homeTeam, Team awayTeam){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    Game(Team homeTeam, Team awayTeam, LocalDateTime plusDays) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @return the homeTeam
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * @param homeTeam the homeTeam to set
     */
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * @return the awayTeam
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * @param awayTeam the awayTeam to set
     */
    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
    public Goal[] getGoals() {
        return goals;
    }
    public void setGoals(Goal[] goals) {
        this.goals = goals;
    }
       
    public void playGame(){
        ArrayList <Goal> eventList = new ArrayList();
        Goal currEvent;
        for (int i=0; i < 90; i++){
            if (Math.random() > 0.95) {
                currEvent = new Goal();
                currEvent.setTheTeam(Math.random() > 0.5 ? homeTeam:awayTeam);
                currEvent.setThePlayer(currEvent.getTheTeam().getPlayerArray()[(int)(Math.random()*currEvent.getTheTeam().getPlayerArray().length)]);
                currEvent.setTheTime(i);
                eventList.add(currEvent);  
            }
            this.goals = new Goal[eventList.size()];
            eventList.toArray(goals);
        }
    }
    
    
    public String getDescription(){
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        StringBuilder returnString = new StringBuilder();
        
        returnString.append(this.homeTeam.getTeamName() + " vs " + this.awayTeam.getTeamName() + "\n");
        for (Goal currGoal : this.getGoals()){
            if (currGoal.getTheTeam() == homeTeam){
                homeTeamGoals++;
                homeTeam.incGoalsTotal(1);
            }
            else {
                awayTeamGoals++;
                awayTeam.incGoalsTotal(1);
            }
            returnString.append("Goal scored after ");
            returnString.append(currGoal.getTheTime());
            returnString.append(" min by ");
            returnString.append(currGoal.getThePlayer().getPlayerName());
            returnString.append(" of ");
            returnString.append(currGoal.getTheTeam().getTeamName());
            returnString.append("\n");
        }    
        if (homeTeamGoals == awayTeamGoals){
            returnString.append("It's a draw!");
            this.homeTeam.incPointsTotal(1);
            this.awayTeam.incPointsTotal(1);
        }
        else if (homeTeamGoals > awayTeamGoals){
            returnString.append(homeTeam.getTeamName() + " win!");
            homeTeam.incPointsTotal(2);
        }
        else {
            returnString.append(awayTeam.getTeamName() + " win!");
            awayTeam.incPointsTotal(2);
        }
    
        return returnString.toString();
    }

    Object getTheDateTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}