package Model;

import Helpers.TeamType;
import Utils.CustomHashSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    private Team team;
    private CustomHashSet<OrdinaryEmployee> teamMembers;

    @Before
    public void setUp() throws Exception {
        this.team = new Team();
        teamMembers = new CustomHashSet<>();
        for(int i=0; i<3; i++){
            teamMembers.add(new OrdinaryEmployee());
        }

    }

    @Test
    public void setType(){
        //Given
        TeamType teamType = TeamType.TESTERS;

        //When
        team.setType(teamType);

        //Then
        assertEquals(teamType,team.getType());
    }

    @Test
    public void setTeamMembers(){
        //Given
        int expectedTeamSize =3;


        //When
        team.setTeamMembers(teamMembers);

        //Then
        assertEquals(expectedTeamSize,team.getTeamMembers().size());
        assertNotNull(team.getTeamMembers());
    }

    @Test
    public void setTeamLeader(){
        //Given
        Manager teamLeader = new Manager();

        //When
        team.setTeamLeader(teamLeader);

        //Then
        assertEquals(teamLeader,team.getTeamLeader());
    }

    @Test
    public void setTeamUniqNumber(){
        //Given
        String unique = "Unique";

        //When
        team.setTeamUniqNumber(unique);

        //Then
        assertEquals(unique,team.getTeamUniqNumber());
    }

    @Test
    public void testToString() {
        //Given
        Team team = new Team(TeamType.TESTERS, teamMembers);
        String expectedResult = "Team{teamUniqNumber='null', type=TESTERS, teamLeader=null, teamMembers=[Employee{pesel='null', name='null', surname='null', jobPosition='null', salary=0.0, hireDate=null}, Employee{pesel='null', name='null', surname='null', jobPosition='null', salary=0.0, hireDate=null}, Employee{pesel='null', name='null', surname='null', jobPosition='null', salary=0.0, hireDate=null}]}";

        //When
        String result = team.toString();

        //Then
        assertEquals(expectedResult,result);
    }

}

