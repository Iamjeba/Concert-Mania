package concertmanagementsystem;

class User {
    private String UserType;
    private int id;
    private String name;
    private String gender;
    private String email;
    private String pin;
    private String nid;
    private String phn;
    private String dob;
    private String health;
    private String picture;
    
    
    //constructor
    public User(String UserType,int id, String name, String gender, String email ,String nid, 
            String phn, String dob, String health, String pin,String images){
        this.UserType=UserType;
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.nid = nid;
        this.phn = phn;
        this.dob = dob;
        this.health = health;
        this.pin = pin;
        this.picture=images;
    }
  
    public String getUserType(){
        return UserType;
    }
    public int getid(){
        return id;
    }
    public String getname(){
        return name;
    }
    public String getgender(){
        return gender;
    }
    public String getemail(){
        return email;
    }
    public String getpin(){
        return pin;
    }
    public String getnid(){
        return nid;
    }
    public String getphn(){
        return phn;
    }
    public String getdob(){
        return dob;
    }
    public String gethealth(){
        return health;
    }
    public String getImage(){
        return picture;
    }
}
