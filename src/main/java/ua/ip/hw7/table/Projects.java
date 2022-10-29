package ua.ip.hw7.table;

import javax.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
@ToString
@Getter
@Setter
@NoArgsConstructor
public  class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "cost")
    private Integer cost;

    @ManyToOne
    @JoinColumn(name = "company_id")
    Companies company;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customers customer;

    @Column(name = "creation_date")
    private Date creationDate = Date.valueOf(LocalDate.now());

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany
    @JoinTable(
            name = "developers_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    @ToString.Exclude
    public List<Developers> developers = new ArrayList<>();


}
