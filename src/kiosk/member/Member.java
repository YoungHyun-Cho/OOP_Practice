package kiosk.member;

public class Member {
    private int id;
    private String userName;
    private String password;
    private String address;
    private String phoneNumber;
    private int OrderId;

    public Member(int id, String userId, String password, String address, String phoneNumber, int orderId) {
        this.id = id;
        this.userName = userId;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        OrderId = orderId;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getOrderId() {
        return OrderId;
    }

    public String toString() {
        return userName;
    }
}
