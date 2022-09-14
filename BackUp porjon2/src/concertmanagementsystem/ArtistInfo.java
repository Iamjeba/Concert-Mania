package concertmanagementsystem;

public class ArtistInfo {

    private int A_Id, C_Id;
    private String A_Name, A_PhoneNumber, A_Email;

    public ArtistInfo(int A_Id, String A_Name, String A_PhoneNumber, String A_Email, int C_Id) {
        this.A_Id = A_Id;
        this.A_Name = A_Name;
        this.A_PhoneNumber = A_PhoneNumber;
        this.A_Email = A_Email;
        this.C_Id = C_Id;
    }

    public int getA_Id() {
        return A_Id;
    }

    public String getA_Name() {
        return A_Name;
    }

    public String getA_PhoneNumber() {
        return A_PhoneNumber;
    }

    public String getA_Email() {
        return A_Email;
    }

    public int getC_Id() {
        return C_Id;
    }

}
