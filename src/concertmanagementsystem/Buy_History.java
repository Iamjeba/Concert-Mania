package concertmanagementsystem;

/**
 *
 * @author Wasi
 */
class Buy_History {
    
    private int User_id;
    private String User_name,BuyingTime,Method;
    private int CID,Tamt;
    private String Cname;
    private int Tquantity,Tprice,TamtMethod ,HaveTickets;


    public Buy_History(int User_id, String User_name, int CID, String Cname, int Tquantity, int Tprice, int Tamt,String BuyingTime, String Method ,int HaveTickets) {
        this.User_id = User_id;
        this.User_name = User_name;
        this.CID = CID;
        this.Cname = Cname;
        this.Tquantity = Tquantity;
        this.Tprice = Tprice;
        this.Tamt = Tamt;
        this.BuyingTime = BuyingTime;
        this.Method = Method;
        this.HaveTickets = HaveTickets;
    }

    public int getUser_id() {
        return User_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public String getBuyingTime() {
        return BuyingTime;
    }

    public String getMethod() {
        return Method;
    }

    public int getCID() {
        return CID;
    }

    public int getTamt() {
        return Tamt;
    }

    public String getCname() {
        return Cname;
    }

    public int getTquantity() {
        return Tquantity;
    }

    public int getTprice() {
        return Tprice;
    }

    public int getTamtMethod() {
        return TamtMethod;
    }

    public int getHaveTickets() {
        return HaveTickets;
    }

}

    
    
   
