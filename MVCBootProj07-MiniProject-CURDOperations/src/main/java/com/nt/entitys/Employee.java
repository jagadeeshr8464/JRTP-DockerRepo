package com.nt.entitys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "EMP")
public class Employee implements Serializable{

	@Id
	@SequenceGenerator(name="gen1",initialValue = 1000,allocationSize = 1,sequenceName = "empSQE")
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empNo;
	@Column(length=20)
	private String empName;
	@Column(length=20)
	private String job="Clerk";
	private Float sal;
	private Integer deptNo=10;
}
