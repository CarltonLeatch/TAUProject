package com.SteamLibrary.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String companyName;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date modifyTime;

    private Date readTime;

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", readTime=" + readTime +
                '}';
    }


    public Game(String name, String companyName) {

        this.name = name;
        this.companyName = companyName;
    }
}
