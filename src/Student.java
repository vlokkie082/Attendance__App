/**
 * A Basketball Player and the player's stats.
 * @author dejohns2
 * @since 2025.02.22
 * @version 1.0 beta
 * @see <a href="https://github.com/dejohns2/JavaSection3_BB_Scoreboard_Spring2025.git">GitHub Repository</a>
 */
public class Player {

    /** The Player's jersey. */
    private int jersey;

    /** The Player's name. */
    private String name;

    /** The player's number of fouls. */
    private int fouls;

    /** The Player's number of 1pt field goals. */
    private int fieldGoals_1pt;

    /** The Player's number of 2pt field goals. Need to multiply by 2 when calculating total points. */
    private int fieldGoals_2pt;

    /** The Player's number of 3pt field goals. Need to multiply by 3 when calculating total points. */
    private int fieldGoals_3pt;

    /**
     * Set the Player's fields to default values null and zeroes.
     * The default constructor is PRIVATE, so it is ONLY called by the overload constructor.
     */
    private Player() {
        name = null;
        jersey = 0;
        fouls = 0;
        fieldGoals_1pt = 0;
        fieldGoals_2pt = 0;
        fieldGoals_3pt = 0;
    } // end of default constructor

    /**
     * This overload constructor should only be used by the ArrayList indexOf method
     * to detect if a jersey number is already taken by overriding the equals method to test
     * if two players are equal based on their jersey number.
     * @param jersey The Player's jersey number.
     * @throws Exception if the setJersey method throws a data validation error.
     */
    public Player(int jersey) throws Exception {
        this();
        setJersey(jersey);
    } // end of jesery overload constructor

    /**
     * Allow creating a Player plus setting their name and jersey number.
     * The constructor first calls the default constructor and then
     * calls both the setName and setJersey methods for data validation.
     * @param name The Player's name
     * @param jersey The Player's jersey #
     * @throws Exception if the name or jersey setters throws an error
     */
    public Player(int jersey, String name) throws Exception {
        this();
        setJersey(jersey);
        setName(name);
    } // end of jersey and name overload constructor

    /**
     * Get the Player's name.
     * @return The Player's name.
     */
    public String getName() { return name; }

    /**
     * Get the Player jersey number.
     * @return The Player's jersey number
     */
    public int getJersey() { return jersey; }

    /**
     * Get the Player's number of fouls.
     * @return the number of fouls by the Player.
     */
    public int getFouls() {	return fouls; }

    /**
     * Get the Player's number of 1pt field goals made.
     * @return The number of 1pt field goals made by the Player.
     */
    public int getFieldGoals_1pt() { return fieldGoals_1pt; }

    /**
     * Get the Player's number of 2pt field goals made.
     * @return The number of 2pt field goals made by the Player.
     */
    public int getFieldGoals_2pt() { return fieldGoals_2pt; }

    /**
     * Get the Player's number of 3pt field goals made.
     * @return the number of 3pt field goals made by the Player.
     */
    public int getFieldGoals_3pt() {return fieldGoals_3pt; }

    /**
     * Set the Player's jersey number if it's a positive number between 1 and 55
     * otherwise it throws an error.
     * @param jersey the player's jersey number
     * @throws Exception if the jersey number isn't between 0 and 55 inclusively.<br>
     * Error Example: Invalid jersey number #10 for name Bob!
     */
    public void setJersey(int jersey) throws Exception {
        if (jersey >= 0 && jersey <= 55)
            this.jersey = jersey;
        else
            throw new Exception("Invalid jersey number #" + jersey + " for name " + name + "!");
    } // end of setJersey method

    /**
     * Set the Player's name. Uses the trim method to remove leading and trailing spaces
     * and then if the name is an empty string, it will throw an error
     * if not then it will set the player's name.
     * @param name The Player's name
     * @throw Exception if the player's name is blank (whitespace or empty)<br>
     * Error Example: Name cannot be blank for jersey number #10!
     */
    public void setName(String name) throws Exception {

        name = name.trim();

        if (name.isBlank())
            throw new Exception("Name cannot be blank for jersey number #" + jersey + "!");
        else
            this.name = name;
    } // end of setName method

    /**
     * Increment the appropriate field goal type, using a switch that also handles for invalid data.<br>
     * case 0 is received then increment fouls by 1<br>
     * case 1 is received then increment fieldGoal_1pt by 1<br>
     * case 2 is received then increment fieldGoal_2pt by 1<br>
     * case 3 is received then increment fieldGoal_3pt by 1<br>
     * default throw an exception displaying the invalid value that was received
     * @param statsType The stats type 0=foul, 1=1pt Field Goal Shot, 2=2pt Field Goal Shot, 3=3pt Field Goal
     * @throws Exception if an invalid statsType is received (valid 0-3)<br>
     * Error Example: Invalid statsType = 4
     */
    public void updateStats(int statsType) throws Exception {

        switch (statsType) {
            case 0:
                fouls++;
            case 1:
                fieldGoals_1pt++;
                break;
            case 2:
                fieldGoals_2pt++;
                break;
            case 3:
                fieldGoals_3pt++;
                break;
            default:
                throw new Exception("Invalid statsType = " + statsType);
        }
    } // end of updateStats method

    /**
     * Get the Player's total points by calculating it by field goal types.
     * @return The Player's total points = 1pt + (2pt * 2) + (3pt * 3)
     */
    public int getPoints() {
        return fieldGoals_1pt + (fieldGoals_2pt * 2) + (fieldGoals_3pt * 3);
    }

    /**
     * Display the Player's jersey number, name, # of fouls, and # of points via getPoints method<br>
     * Example:#10 Billy Fouls=1 Points=5
     */
    public void displayStats() {
        System.out.print("#" + jersey + " " + name + " Fouls=" + fouls + " Points=" + getPoints());
    }

    /**
     * Instead of verifying two players are identical by equal identities.<br>
     * This method will verify two players are the same by ONLY their jersey number.<br>
     * This allows the ArrayList.getIndex() method to return a player's by only checking their jersey number.
     * @param object a player object to check equality of ONLY the jersey number
     * @return true if the two player's jersey are equal otherwise false
     */
    @Override
    public boolean equals(Object object) {

        if(!(object instanceof Player))
            return false;

        Player other = (Player)object;

        return this.jersey == other.getJersey();
    } // end of override equals

    /**
     * Returns the jersey number and player name. Example:<br>
     * #10 Billy
     * @return The player's jersey and name
     */
    @Override
    public String toString(){
        return "#" + jersey + " " + name;
    }
}

