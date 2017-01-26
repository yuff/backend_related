package com.sap.feifei.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Incident {

	// header parts
	@Id
	@Column(length = 24, nullable = false)
	private String pointer; // Pointer

	@Column(length = 10, nullable = false)
	private String installationNumber; // Csinsta

	@Column(nullable = false)
	private String msgNumber; // Mnumm

	@Column(nullable = false)
	private String msgYear; // Myear

	@Column(nullable = false)
	private String service; // Service

	@Column(nullable = false)
	private String serviceType; // ServiceTyp

	@Column(nullable = false)
	private String incidentNumberNLZ; // MnummNLZ

	@Column(nullable = false, length = 12)
	private String username; // Uname

	@Column(nullable = false)
	private String usernameText;// UnameText

	@Column(nullable = false, length = 120)
	private String shortText; // Stext

	@Column(nullable = false)
	private String status; // Status

	@Column(nullable = false)
	private String statusText; // StatusText

	@Column(nullable = false)
	private String priority; // Priority

	@Column
	private String priorityText; // PriorityText

	@Column
	private String componentKey; // ComponentKey

	@Column
	private String componentName; // ComponentName

	@Column
	private String componentText; // ComponentText

	@Column
	private Date createDate; // Erftstmp


	@Column
	private String createDateFrom; // ErftstmpFrom

	@Column(nullable = false)
	private String createDateTo; // ErftstmpTo

	@Column(nullable = false)
	private Date lastUpdateDate; // Aetstmp

	@Column(nullable = false)
	private String lastUpdateDateFrom; // AetstmpFrom

	@Column(nullable = false)
	private String lastUpdateDateTo; // AetstmpTo

	@Column(nullable = false)
	private String url; // URL

	// core parts
	@Column(nullable = false, length = 1000)
	private String description; // Description

	@Column(nullable = false)
	private String businessImpactText; // BIText

	@Column(nullable = false)
	private String reproText; // ReproText

	@Column(length = 10, nullable = false)
	private String customerNumber; // CustNbr

	@Column(length = 18, nullable = false)
	private String systemNumber; // Sysnr

	@Column(nullable = false)
	private String attxStr; // AttxStr

	@Column(nullable = false)
	private int retCode; // RetCode. Should it be int or String ? Double check.

	@Column(nullable = false)
	private String resultText; // ResultText

}
