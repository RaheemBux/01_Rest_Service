package com.example._Rest_Service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name ="items")
public class ItemEntity {

    @Id
    @Column(name="unq_Id")
    private String uniqueId;

    @Column(name="name")
    private String name;

    @Column(name="gender")
    private String gender;

    @Column(name="size")
    private String size;

    @Column(name="season")
    private String season;

    @Column(name="fit_group")
    private String fitGroup;

    @Column(name="brand")
    private String brand;

    @Column(name="tags")
    private String tags;

    @Column(name="collection")
    private String collection;

    @Column(name="year")
    private String year;

    @Column(name="id")
    private String id;

    @Column(name="material")
    private String material;

    @Column(name="trans_mode")
    private String transMode;

    @Column(name="thickness_class")
    private String thicknessClass;

    @Column(name="inc_Id")
    private Integer incId;
}
