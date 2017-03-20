package lecture464.model;

import java.sql.*;

public class Products {
	
	private int Id;
	private String ProductName;
	private int ProductCategoryIndex;
	private String ProductDescription;
	private double Price;
	private int AvailableQuantity;
	private int EstimatedDeliveryDays;
	private int SellerId;
	private String ProductPhotosLinks;
	private String ProductCategory;
	//private String ProductVideosLinks;
	private String ProductThumbnail;
	private String Review;
	private int Rating;
	private Date ReviewDate;
	private int ReviewCustomerID;
	private String ProductQuestion;
	private String ProductAnswer;
	
	public String getProductQuestion() {
		return ProductQuestion;
	}
	public void setProductQuestion(String productQuestion) {
		ProductQuestion = productQuestion;
	}
	public String getProductAnswer() {
		return ProductAnswer;
	}
	public void setProductAnswer(String productAnswer) {
		ProductAnswer = productAnswer;
	}
	public int getReviewCustomerID() {
		return ReviewCustomerID;
	}
	public void setReviewCustomerID(int reviewCustomerID) {
		ReviewCustomerID = reviewCustomerID;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public Date getReviewDate() {
		return ReviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		ReviewDate = reviewDate;
	}
	public int getProductId() {
		return Id;
	}
	public void setProductId(int Id) {
		this.Id = Id;
		}

	public int getEstimatedDeliveryDays() {
		return EstimatedDeliveryDays;
	}
	public void setEstimatedDeliveryDays(int estimatedDeliveryDays) {
		EstimatedDeliveryDays = estimatedDeliveryDays;
	}
	public int getSellerId() {
		return SellerId;
	}
	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}
	public Products (int Id, String ProductName, int ProductCategoryIndex, String ProductDescription, double Price, int AvailableQuantity, int EstimatedDeliveryDays, int SellerId, String ProductPhotosLinks, String ProductThumbnail) {
		super();
	  	this.Id = Id;
	    this.ProductName =  ProductName;
		this.ProductCategoryIndex = ProductCategoryIndex;
		this.ProductDescription = ProductDescription;
		this.Price = Price;
		this.AvailableQuantity = AvailableQuantity;
		this.EstimatedDeliveryDays = EstimatedDeliveryDays;
		this.SellerId = SellerId;
		this.ProductPhotosLinks = ProductPhotosLinks;
		this.ProductThumbnail = ProductThumbnail;
		//this.ProductCategory = getProductCategoryIndex(ProductCategoryIndex);
	    } 
	    
	
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
			}
	public String getProductCategoryIndex() {
		if(ProductCategoryIndex == 1) {
			return "Food";
		} else if (ProductCategoryIndex == 2 ) {
			return "Fancy";
		} else  {
			return "Funny";
		}
	}
	public void setProductCategoryIndex(int productCategoryIndex) {
		ProductCategoryIndex = productCategoryIndex;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}

	public int getAvailableQuantity() {
		return AvailableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		AvailableQuantity = availableQuantity;
	}
	public String getProductPhotosLinks() {
		return ProductPhotosLinks;
	}
	public void setProductPhotosLinks(String productPhotosLinks) {
		ProductPhotosLinks = productPhotosLinks;
	}
	public String getProductThumbnail() {
		return ProductThumbnail;
	}
	public void setProductThumbnail(String productThumbnail) {
		ProductThumbnail = productThumbnail;
	}
    

}
	

