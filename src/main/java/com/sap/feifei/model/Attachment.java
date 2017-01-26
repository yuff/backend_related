package com.sap.feifei.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Attachment {

	@Id
	@Column(length = 40, nullable = false)

	private String hash; // Hash

	@Column(length = 24, nullable = false)
	private String pointer; // Pointer

	@Column(nullable = false)
	private String service; // Service

	@Column(nullable = false)
	private String serviceType; // ServiceTyp

	@Column(length = 128, nullable = false)
	private String filename; // Filename

	@Column(length = 60, nullable = false)
	private String text; // Text

	@Column(length = 64, nullable = false)
	private String type; // Type

	@Column(length = 64, precision = 15, scale = 0, nullable = false)
	private BigDecimal createTime; // Merftstmp

	@Column(length = 12, nullable = false)
	private String enterBy;// Merfnam

	@Column(length = 64, precision = 15, scale = 0, nullable = false)
	private BigDecimal changeTime; // Maetstmp

	@Column(length = 12, nullable = false)
	private String changeBy;// Maenam

	@Column(length = 1, nullable = false)
	private String virusChecked;// Viruschecked

	@Column(length = 1, nullable = false)
	private String internal; // Internal

	@Column(length = 1, nullable = false)
	private String flag01;	//Flag01

	@Column(length = 1, nullable = false)
	private String flag02;	//Flag02

	@Column(length = 1, nullable = false)
	private String flag03;	//Flag03

	@Column(length = 1, nullable = false)
	private String flag04;	//Flag04

	@Column(length = 1022, nullable = false)
	private String isUrl;	//Isurl

	@Column(length = 1, nullable = false)
	private String isContainedPersonalData; // Cpocd

	@Column(length = 4, nullable = false)
	private String dataProtectionRestriction; // Dprest

	@Column(length = 32, nullable = false)
	private String uuid;	//Uuid

	@Column(nullable = false)
	private Integer fileLength;	//Filelength

	@Column(nullable = false)
	private Byte[] fileData;	//Data
}
