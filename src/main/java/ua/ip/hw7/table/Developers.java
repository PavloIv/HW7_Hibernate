package ua.ip.hw7.table;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "developers")
@ToString
@Getter
@Setter
@NoArgsConstructor
public  class Developers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "sex")
    private String sex;
    @Column(name = "salary")
    private Integer salary;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "developers" )
    @ToString.Exclude
    public List<Skills> skills = new ArrayList<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "developers")
    @ToString.Exclude
    public List<Projects> projects = new ArrayList<>();
}
