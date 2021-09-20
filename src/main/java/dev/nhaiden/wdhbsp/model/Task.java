package dev.nhaiden.wdhbsp.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    @NotBlank
    @Length(max = 255)
    @EqualsAndHashCode.Exclude
    private String description;

    @Column(name="finished")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @EqualsAndHashCode.Exclude
    private LocalDate date;

    @Column(name = "hoursWorked")
    @EqualsAndHashCode.Exclude
    private Integer hoursWorked;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @EqualsAndHashCode.Exclude
    private Employee employee;
}
