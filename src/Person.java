class Person {
    private int id;
    private String name;
    String address;
    String phone;
    private String email;
    private String gender;

    public Person(int id, String name, String address, String phone, String email, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
