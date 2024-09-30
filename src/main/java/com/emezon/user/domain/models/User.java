package com.emezon.user.domain.models;

public class User {

    private String id;
    private String name;
    private String lastName;
    private String docNumber;
    private String cellphone;
    private String birthDate;
    private String email;
    private String password;
    private Rol rol;

    private User() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public static class Builder {
        private final User user;

        public Builder() {
            user = new User();
        }

        public Builder setId(String id) {
            user.setId(id);
            return this;
        }

        public Builder setName(String name) {
            user.setName(name);
            return this;
        }

        public Builder setLastName(String lastName) {
            user.setLastName(lastName);
            return this;
        }

        public Builder setDocNumber(String docNumber) {
            user.setDocNumber(docNumber);
            return this;
        }

        public Builder setCellphone(String cellphone) {
            user.setCellphone(cellphone);
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            user.setBirthDate(birthDate);
            return this;
        }

        public Builder setEmail(String email) {
            user.setEmail(email);
            return this;
        }

        public Builder setPassword(String password) {
            user.setPassword(password);
            return this;
        }

        public Builder setRol(Rol rol) {
            user.setRol(rol);
            return this;
        }

        public User build() {
            return user;
        }

    }

}
