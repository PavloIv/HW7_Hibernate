package ua.ip.hw6.table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
@ToString
@Getter
@Setter
@NoArgsConstructor
public  class Customers {
    @Id @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "customer")
    List<Projects> projects =new ArrayList<>();

    public Customers(Integer id, String name, String website) {
        this.id = id;
        this.name = name;
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return Objects.equals(id, customers.id) && Objects.equals(name, customers.name) && Objects.equals(website, customers.website);
    }

}
