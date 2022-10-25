package ua.ip.hw6.table;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "skills")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Skills {
    @Id @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "language")
    private String language;
    @Column(name = "level")
    private String level;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany
    @JoinTable(
            name = "developers_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    public List<Developers> developers = new ArrayList<>();


}
