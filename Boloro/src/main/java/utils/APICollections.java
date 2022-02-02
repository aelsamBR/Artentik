package utils;

import java.time.Instant;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class APICollections {
	
	
	ResponseBodyExtractionOptions respo;
	Support sup =new Support();
	
	String BaseURL="https://boloro-backend-admin-dev.devtomaster.com/";
	String LoginAPI = BaseURL+"v1/admin/auth";
	String CreateAssetAPI= BaseURL+"v1/admin/asset";
	String AccessToken= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZG1pblVzZXIiOnsiaWQiOjMsImVtYWlsIjoic3VwZXJhZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoiYWRtaW4ifSwiaWF0IjoxNjQzNjA4NTk4LCJleHAiOjE2NzUxNjYxOTh9.q6QL5wEr0BOSuuKiGaLA8v-thOfD0B56CeVGzBdNlSU";

	
	
		  public void AssetCreation (String AssetName) throws InterruptedException {
			  
			  JSONObject jo = new JSONObject();
				JSONArray array = new JSONArray();
			  jo.put("categoryId", "77");
				jo.put("subCategoryId","52");
				jo.put("saleType", "fixed");
				jo.put("name", AssetName);
				jo.put("status", "active");
				jo.put("description","");
				jo.put("quantity", 1);
				jo.put("creatorDescription", "");
				jo.put("creatorName", "");
			//	jo.put("auctionBuyNowPrice", null);
				jo.put("isBuyNowForAuction", false);
				jo.put("isDownloadable", true);
			//	jo.put("auction", null);
			//	jo.put("royaltyCommission", null);
				jo.put("isCarrosel", false);
				jo.put("isEditionMintToAdmin", false);
				jo.put("descriptionMint", "");
				jo.put("ipfs3dUrl", "");
				jo.put("ipfs3dId", "");
				jo.put("totalEdition", "12");
				jo.put("regularPrice", "1");
				array.put(2187);
				jo.put("fileId", array);
			//	jo.put("royaltyCommission", null);
				RequestSpecification reqSpec = RestAssured.given();
				String a=jo.toString();
				System.out.println(a);
				reqSpec.body(jo.toString());
				reqSpec.contentType("application/json");
				System.out.println(AccessToken);
				Response resp =reqSpec.header("Authorization", "Bearer "+AccessToken).post(CreateAssetAPI);
				respo=resp.getBody();
				String b=respo.asString();
				System.out.println(b);
			    String message=respo.jsonPath().getString("message");
			    System.out.println(message);
	
		  }	
		  
 public void AuctionAssetCreation (String AssetName) throws InterruptedException {
	
			  JSONObject jo = new JSONObject();
			  JSONObject Auction = new JSONObject();
				JSONArray array = new JSONArray();
			  jo.put("categoryId", "77");
				jo.put("subCategoryId","52");
				jo.put("saleType", "auction");
				jo.put("name", AssetName);
				jo.put("status", "active");
				jo.put("description","");
				jo.put("quantity", 1);
				jo.put("creatorDescription", "");
				jo.put("creatorName", "");
			//	jo.put("auctionBuyNowPrice", null);
				jo.put("isBuyNowForAuction", false);
				jo.put("isDownloadable", true);
				Auction.put("auctionType", "normal");
				Auction.put("openingPrice", "1");
				Auction.put("startDate", Instant.now().toString());
				Auction.put("endingDate", Instant.now().plusSeconds(3600).toString());
				Auction.put("status", "active");
				jo.put("auction", Auction);
			//	jo.put("auction", null);
			//	jo.put("royaltyCommission", null);
				jo.put("isCarrosel", false);
				jo.put("isEditionMintToAdmin", false);
				jo.put("descriptionMint", "");
				jo.put("ipfs3dUrl", "");
				jo.put("ipfs3dId", "");
				jo.put("currentEdition", "12");
				jo.put("totalEdition", "12");
				jo.put("regularPrice", "1");
				array.put(2187);
				jo.put("fileId", array);
				
			//	jo.put("royaltyCommission", null);
				RequestSpecification reqSpec = RestAssured.given();
				String a=jo.toString();
				System.out.println(a);
				reqSpec.body(jo.toString());
				reqSpec.contentType("application/json");
				System.out.println(AccessToken);
				Response resp =reqSpec.header("Authorization", "Bearer "+AccessToken).post(CreateAssetAPI);
				respo=resp.getBody();
				String b=respo.asString();
				System.out.println(b);
			    String message=respo.jsonPath().getString("message");
			    System.out.println(message);
	
		  }	

		  /*
		  public void getRewardID(String EndPoint, String accessToken) {
			  RequestSpecification reqSpec = RestAssured.given();
				Response resp = reqSpec.header("Authorization", accessToken).get(EndPoint);
			    respo=resp.getBody();
			     RewardID =respo.jsonPath().getString("result[0]._id");
			     System.out.println(RewardID);
				
	
		  }	
		  public void PurchaseReward() {
				
				jo.put("eventId", RewardID);
				jo.put("quantity",1);
				jo.put("platform", 2);
				RequestSpecification reqSpec = RestAssured.given();
				reqSpec.body(jo.toString());
				reqSpec.contentType("application/json");
				Response resp =reqSpec.header("Authorization", accessToken).post(PostPurchaseRewardAPI);
				respo=resp.getBody();
			    String message=respo.jsonPath().getString("message");
			    System.out.println(message);
			    
		  }	
		  
		  public String getRewardStatus() {
			  RequestSpecification reqSpec = RestAssured.given();
				Response resp = reqSpec.header("Authorization", accessToken).get(getRewardStatusAPI);
			    respo=resp.getBody();
				String RewardStatus =respo.jsonPath().getString("result[0].status");
				return RewardStatus;
	
		  }	
		  
	  public void getCampaignID() {
		  RequestSpecification reqSpec = RestAssured.given();
			Response resp = reqSpec.header("Authorization", accessToken).get(getCampaignListAPI);
		    respo=resp.getBody();
			 getCampaignID =respo.jsonPath().getString("result.data[0]._id");

	  }	
	  
	  public void getQuizID() {
		  String getQuizListAPI = BaseURL+"campaign/"+getCampaignID+"/quiz/1";
		  System.out.println(getCampaignID);
		  RequestSpecification reqSpec = RestAssured.given();
		  System.out.println(getQuizListAPI);
		  System.out.println(accessToken);
			Response resp = reqSpec.header("Authorization", accessToken).get(getQuizListAPI);
		    respo=resp.getBody();
		    String h=respo.asPrettyString();
		    System.out.println(h);
			 QuizID =respo.jsonPath().getString("result._id");
			 SessionID =respo.jsonPath().getString("result.sessionId");
			 QNo =respo.jsonPath().getString("result.qno");
			 OptionID =respo.jsonPath().getString("result.question.options[0]._id");
			 System.out.println(QuizID);
			 System.out.println(SessionID);
			 System.out.println(QNo);
			 System.out.println(OptionID);
			 
	  }	
	  
	  public void playQuiz() {
		  RequestSpecification reqSpec = RestAssured.given();
		  JSONObject jo1 = new JSONObject();
		  JSONObject jo2 = new JSONObject();
		  jo2.put("quizId", QuizID);
		  jo2.put("sessionId", SessionID);
		  jo2.put("qno", QNo);
		  jo1.put("_id", OptionID);
		  jo2.put("answer", jo1); 
		String samp=  jo2.toString();
	System.out.println(samp);
			reqSpec.body(jo2.toString());
			reqSpec.contentType("application/json");
			Response resp = reqSpec.header("Authorization", accessToken).post(PlayQuizAPI);
			respo=resp.getBody();
			String h=respo.asPrettyString();
			System.out.println(h);
		     String a =respo.jsonPath().getString("result.correctAnswer.explanation");
		     System.out.println(a);
	  }
	  public String getAvailableCoin() {
		  RequestSpecification reqSpec = RestAssured.given();
			Response resp = reqSpec.header("Authorization", accessToken).get(getAvailableCoin);
		    respo=resp.getBody();
			 String availableCoin =respo.jsonPath().getString("result.mq");
			 System.out.println(availableCoin);
			 return availableCoin;

	  }	
	  
	  public String getNPCName() {
		  RequestSpecification reqSpec = RestAssured.given();
			Response resp = reqSpec.header("Authorization", accessToken).get(getNPCListAPI);
		    respo=resp.getBody();
			String getNPCName =respo.jsonPath().getString("result.docs[0].heading");
            return getNPCName;
	  }	*/
	
}
