package ua.ip.hw6.table;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "companies")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Companies {
    @Id @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "year_of_foundation")
    private Integer yearOfFoundation;

    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    List<Projects> projects = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Companies companies = (Companies) o;
        return Objects.equals(id, companies.id) && Objects.equals(name, companies.name) && Objects.equals(yearOfFoundation, companies.yearOfFoundation);
    }

}
