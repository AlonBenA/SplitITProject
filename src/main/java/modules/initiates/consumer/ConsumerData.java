package modules.initiates.consumer;

public class ConsumerData {

    String CultureName;
    String Email;
    String FullName;
    String PhoneNumber;

    public ConsumerData(String cultureName, String email, String fullName, String phoneNumber) {
        CultureName = cultureName;
        Email = email;
        FullName = fullName;
        PhoneNumber = phoneNumber;
    }

    public String getCultureName() {
        return CultureName;
    }

    public void setCultureName(String cultureName) {
        CultureName = cultureName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
