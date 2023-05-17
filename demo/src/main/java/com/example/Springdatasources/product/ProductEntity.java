/**
 * 
 */
package com.example.Springdatasources.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author srinidhi.k
 *
 */
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectid;
	private String projectname;
	private String projectdetails;
}
