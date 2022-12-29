package com.example.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "beanslist")
public class BeansEntity {
	

 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Id
 @Column(name = "id")
 private Integer id;

 @NotNull (message = "この項目は必須です")
 @Column(name = "farm")
 private String farm;
 
 @Column(name = "name")
 private String name;
 

 @NotNull (message = "100gの価格を入力してください")

 @Column(name = "smallsize")
 private Integer smallsize;
//
// @Pattern(regexp = "^[0-9]+$", message = "数値を入力してください")
 @NotNull (message = "200gの価格を入力してください")
 @Column(name = "mediumsize")
 private Integer mediumsize;
 
// @Pattern(regexp = "^[0-9]+$", message = "数値を入力してください")
 @NotNull (message = "ドリンクの価格を入力してください")
 @Column(name = "drink")
 private Integer drink;


}
