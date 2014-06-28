package com.mytutorial.rateflats;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flats")
public class Flat implements Serializable, Comparable<Flat>{

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private String nameOfStreetandNumber;
	private Integer distanceToWork;
    private Integer priceByMonth;
    private Integer areaSize;
    private String url;
    private Double myRating;
    private String comments;
    private Boolean isCommunityIncluded;
    private Boolean isWaterIncluded;
    private Boolean isPermittedAContractOfSixMonths;
    
    private Double finalRating;
    
	public String getNameOfStreetandNumber() {
		return nameOfStreetandNumber;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setNameOfStreetandNumber(String nameOfStreetandNumber) {
		this.nameOfStreetandNumber = nameOfStreetandNumber;
	}
	
	public Integer getDistanceToWork() {
		return distanceToWork;
	}
	public void setDistanceToWork(Integer distanceToWork) {
		this.distanceToWork = distanceToWork;
	}
	
	public Integer getPriceByMonth() {
		return priceByMonth;
	}
	public void setPriceByMonth(Integer priceByMonth) {
		this.priceByMonth = priceByMonth;
	}
	
	public Integer getAreaSize() {
		return areaSize;
	}
	public void setAreaSize(Integer areaSize) {
		this.areaSize = areaSize;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Double getMyRating() {
		return myRating;
	}
	public void setMyRating(Double myRating) {
		this.myRating = myRating;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Boolean getIsCommunityIncluded() {
		return isCommunityIncluded;
	}
	public void setIsCommunityIncluded(Boolean isCommunityIncluded) {
		this.isCommunityIncluded = isCommunityIncluded;
	}
	
	public Boolean getIsWaterIncluded() {
		return isWaterIncluded;
	}
	public void setIsWaterIncluded(Boolean isWaterIncluded) {
		this.isWaterIncluded = isWaterIncluded;
	}
	
	public Boolean getIsPermittedAContractOfSixMonths() {
		return isPermittedAContractOfSixMonths;
	}
	public void setIsPermittedAContractOfSixMonths(
			Boolean isPermittedAContractOfSixMonths) {
		this.isPermittedAContractOfSixMonths = isPermittedAContractOfSixMonths;
	}
    
	public Double getFinalRating() {
		return finalRating;
	}
	public void setFinalRating(Double finalRating) {
		this.finalRating = finalRating;
	}
	
	public Double returnRateDistance(){
		Double rateDistance = 5.0;
		int distance = this.distanceToWork;
		if (distance<100){
			distance = 100;
		}else if (distance>2000) {
			distance = 2000;
		}
		rateDistance = rateDistance + ((2000.0-distance)/380);
		return rateDistance;
	}
	
	public Double returnRatePrice(){
		Double ratePrice = 5.0;
		int price = this.priceByMonth;
		if(price<330){
			price = 330;
		}else if (price>400) {
			price = 400;
		}
		ratePrice = ratePrice + ((400.0-price)/14);
		return ratePrice;
	}
	
	public Double returnRateArea(){
		Double rateArea = 5.0;
		int area = this.areaSize;
		if(area<30){
			area = 30;
		}else if (area>90) {
			area = 90;
		}
		rateArea = rateArea + ((area-30.0)/12);
		return rateArea;
	}
	public int compareTo(Flat otherFlat) {
		// TODO Auto-generated method stub
		return this.finalRating.compareTo(otherFlat.finalRating);
	}
}