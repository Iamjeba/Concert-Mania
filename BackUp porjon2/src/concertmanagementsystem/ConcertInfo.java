package concertmanagementsystem;

public class ConcertInfo {

    private int id;
    private String name;
    private String location;
    private String category;
    private int ticket_quantity, ticket_price;
    private String C_date,ArtistNames;
    private int S_id;
    private int M_id;

    public ConcertInfo(int id, String name, String location, String category, int ticket_price, int ticket_quantity, String C_date, String ArtistNames ,int S_id, int M_id) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.category = category;
        this.ticket_price = ticket_price;
        this.ticket_quantity = ticket_quantity;
        this.C_date = C_date;
        this.ArtistNames = ArtistNames;
        this.S_id = S_id;
        this.M_id = M_id;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public String getCategory() {
        return category;
    }
    public int getS_id() {
        return S_id;
    }
    public String getC_date() {
        return C_date;
    }
    public String getArtistNames()
    {
        return ArtistNames;
    }
    public int getTicket_Price() {
        return ticket_price;
    }
    
    public int getTicket_Quantity() {
        return ticket_quantity;
    }

    public int getM_id() {
        return M_id;
    }

}
