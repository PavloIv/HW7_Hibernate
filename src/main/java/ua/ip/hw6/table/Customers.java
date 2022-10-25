package ua.ip.hw6.table;

import java.util.Objects;

public  class Customers {
    private Integer id;
    private String name;
    private String website;

    public Customers(Integer id, String name, String website) {
        this.id = id;
        this.name = name;
        this.website = website;
    }

    public Customers() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return Objects.equals(id, customers.id) && Objects.equals(name, customers.name) && Objects.equals(website, customers.website);
    }

    @Override
    public String toString() {
        return  "\n" + "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Website='" + website + '\'' +
                '}' + "\n";
    }
}
