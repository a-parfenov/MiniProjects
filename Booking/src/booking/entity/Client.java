package booking.entity;

public class Client {
    private String name;
    private String surname;
    private String mobile;
    private String email;
    private final Bill billClient;

    public Client(String name, String surname, String mobile, String email, Bill bill) {
        this.name = name;
        this.surname = surname;
        this.mobile = mobile;
        this.email = email;
        this.billClient = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bill getBillClient() {
        return billClient;
    }

}
