package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "data_packet")
@Getter
@Setter
@ToString
public class DataEntity {

    @Id
    private Long id;

    @Column(name = "payload")
    private String payload;
}
