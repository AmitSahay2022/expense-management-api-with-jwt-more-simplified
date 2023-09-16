package com.sahayji.exp.management.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
	@NotBlank(message = "name should not blank")
   private String name;
	@NotBlank(message = "email should not blank")
	@Column(unique = true)
	@Email(message = "provide valid email address")
   private String email;
	@NotBlank(message = "password should not blank")
   private String password;
   private int age;
   @CreationTimestamp
   @Column(name = "created_at",updatable = false)
   private Timestamp createdAt;
   @UpdateTimestamp
   private Timestamp updatedAt;
}
