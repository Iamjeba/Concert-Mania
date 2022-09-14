/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertmanagementsystem;

public class SponsorInfo {
    
    private int S_Id,C_Id;
    private String S_CompanyName,S_PhoneNumber;

    public SponsorInfo(int S_Id, String S_CompanyName, String S_PhoneNumber,int C_Id) {
        this.S_Id = S_Id;
        this.C_Id = C_Id;
        this.S_CompanyName = S_CompanyName;
        this.S_PhoneNumber = S_PhoneNumber;
    }

    public int getS_Id() {
        return S_Id;
    }

    public int getC_Id() {
        return C_Id;
    }

    public String getS_CompanyName() {
        return S_CompanyName;
    }

    public String getS_PhoneNumber() {
        return S_PhoneNumber;
    }
    
    
}
