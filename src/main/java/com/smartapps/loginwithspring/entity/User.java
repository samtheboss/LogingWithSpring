package com.smartapps.loginwithspring.entity;

import com.smartapps.loginwithspring.utills.AllowEmpty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.event.spi.PreInsertEvent;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(
//            name = "user_sequence",
//            sequenceName = "user_sequence"
//    ,allocationSize = 1)
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "user_sequence"
//    )
    private Long user_id;
    private String first_name;
    @AllowEmpty(value = false)
    private String last_name;
    @Column(unique = true)
    private  String  email;
    private String  password;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_created;
    @Transient
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_modified;
}
