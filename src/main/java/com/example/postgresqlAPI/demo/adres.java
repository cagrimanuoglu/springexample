package com.example.postgresqlAPI.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name="kisi_Adres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"id"})
@ToString
public class adres implements Serializable {
	
	@Id
	@SequenceGenerator(name="seq_kisi_adres",allocationSize=1)
	@GeneratedValue(generator="seq_kisi_adres",strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(length = 500,name = "adres")
	private String adres;
	@Enumerated
	private AdresTip adresTip;
	@Column(name = "aktif")
	private Boolean aktif;
	
	@ManyToOne
	@JoinColumn(name = "kisi_adres_id")
	private kisi k;
	
	public enum AdresTip{
		
		Ev_Adresi,
		İş_Adresi,
		Diğer
		
		
	}
	
	
	

}
