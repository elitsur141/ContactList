public class Athlete extends Person
{
    private String sport;

    public Athlete(String firstName, String lastName, String phoneNumber, String theSport)
    {
        super(firstName, lastName, phoneNumber)
        sport = theSport;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String toString()
    {
        return super.toString() + " Sport: " + sport;
    }
}
