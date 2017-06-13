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
        String expectedResult = "Team{" +
                "\n\tteamUniqNumber='" + null + '\'' +
                "\n\ttype=" + "TESTERS" +
                "\n\tteamLeader=" + null +
                "\n\tteamMembers= \n" + teamMembers +
                "\n}\n";

        //When
        String result = team.toString();

        //Then
        assertEquals(expectedResult,result);
    }

    @Test
    public void getTypeDescriptionTesters(){
        //Given
        TeamType type = TeamType.TESTERS;
        team.setType(type);
        String expectedString = "TESTERS";

        //When
        String result = team.getTypeDescription();

        //Then
        assertEquals(result, expectedString);
    }

    @Test
    public void getTypeDescriptionAdv(){
        //Given
        TeamType type = TeamType.ADV;
        team.setType(type);
        String expectedString = "ADV";

        //When
        String result = team.getTypeDescription();

        //Then
        assertEquals(result, expectedString);
    }

    @Test
    public void getTypeDescriptionDev(){
        //Given
        TeamType type = TeamType.DEV;
        team.setType(type);
        String expectedString = "DEV";

        //When
        String result = team.getTypeDescription();

        //Then
        assertEquals(result, expectedString);
    }

    @Test
    public void getTypeDescriptionQA(){
        //Given
        TeamType type = TeamType.QA;
        team.setType(type);
        String expectedString = "QA";

        //When
        String result = team.getTypeDescription();

        //Then
        assertEquals(result, expectedString);
    }

    @Test
    public void getTypeDescriptionUX(){
        //Given
        TeamType type = TeamType.UX;
        team.setType(type);
        String expectedString = "UX";

        //When
        String result = team.getTypeDescription();

        //Then
        assertEquals(result, expectedString);
    }


}

