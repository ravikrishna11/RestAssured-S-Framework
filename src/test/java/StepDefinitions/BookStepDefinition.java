package StepDefinitions;

import org.json.simple.JSONObject;


import equifax.training.util.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BookStepDefinition extends Util {


	static int Bookid, publisherId,authorId, Pid, Aid,customerId,bookingId,billingId;
	static Response response=null;
	static JSONObject request =null;

	
	@Given("^Create Book entry with \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
	public static void Create_Book_entry(String bookName,String authorId,String publisherId,String authorName,String publisherName,String genre,String price,String numberOfPages) 
	{
					
		Object[] Key = {"bookName","authorId","publisherId","authorName","publisherName","genre","price","numberOfPages"};
		Object[] Value = {bookName,authorId,publisherId,authorName,publisherName,genre,price,numberOfPages};
				
		String serviceURL = "/books/book";
		int statusCode = 200;

		response = Util.POSTRes(Key, Value,serviceURL,statusCode);
		
		String Res = response.asString();
		JsonPath jp=new JsonPath(Res);
        Bookid=jp.getInt("bookId");
        Pid = jp.getInt("publisherId");
        Aid = jp.getInt("authorId");
        System.out.println("Book id created : "+Bookid);
        System.out.println("Publisher id created : "+Pid);	
        System.out.println("Author id created : "+Aid);	
	}
	
	@Then("^Get the book details using Book id$")
	public void Get_the_book_details_Book_id() {
	
			String serviceURL = "/books/book";
			int statusCode = 200;
			String QueryP = "bookId";
			int QueryV = Bookid;
			
			response = Util.GETRes(QueryP, QueryV,serviceURL,statusCode);

			System.out.println("Book details is verified with bookid : " + Bookid);
	}
	
	
	@Then("^Get the book details using Publisher id$")
	public void Get_the_book_details_Publisher_id() {
		
		
		String serviceURL = "/books/publisherbooks";
		int statusCode = 200;
		String QueryP = "publisherId";
		int QueryV = Pid;
		
		response = Util.GETRes(QueryP, QueryV,serviceURL,statusCode);
		
		System.out.println("Book details is verified with publisherId : " + Pid);

	}
	
	@Then("^Delete the Book details by Book id$")
	public void Delete_the_book_details_Book_id() {
	
		String serviceURL = "/books/book";
		int statusCode = 200;
		String QueryP = "bookId";
		int QueryV = Bookid;
		
		response = Util.DELETERes(QueryP, QueryV,serviceURL,statusCode);

		System.out.println("Bookid : " + Bookid + " is deleted");
	}
	
	@Then("^Create Publisher entry with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void create_Publisher_entry_with(String publisherName, String address, String country)  {

		Object[] Key = {"publisherName","address","country"};
		Object[] Value = {publisherName,address,country};

		String serviceURL = "/publishers/publisher";
		int statusCode = 200;

		response = Util.POSTRes(Key, Value,serviceURL,statusCode);
		
		String Res = response.asString();
		JsonPath jp=new JsonPath(Res);
		publisherId=jp.getInt("publisherId");
        System.out.println("publisher Id created : "+publisherId);
	}
	
	@Then("^Delete the publisher details by publisher id$")
	public void Delete_the_publisher_details_publisher_id() {

		String serviceURL = "/publishers/publisher";
		int statusCode = 200;
		String QueryP = "publisherId";
		int QueryV = publisherId;
		
		response = Util.DELETERes(QueryP, QueryV,serviceURL,statusCode);
		
		System.out.println("publisherId : " + publisherId + " is deleted");

	}
	
	@Then("^Create Author entry with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void create_Author_entry_with(String Name, String address, String country)  {
		Object[] Key = {"name","address","country"};
		Object[] Value = {Name,address,country};

		String serviceURL = "/authors/author";
		int statusCode = 200;

		response = Util.POSTRes(Key, Value,serviceURL,statusCode);
		
		String Res = response.asString();
		JsonPath jp=new JsonPath(Res);
		authorId=jp.getInt("authorId");
        System.out.println("Author Id created : "+authorId);
    
	}
	
	@Then("^Delete the Author details by Author id$")
	public void Delete_the_Author_details_Author_id() {

		String serviceURL = "/authors/author";
		int statusCode = 200;
		String QueryP = "authorId";
		int QueryV = authorId;
		
		response = Util.DELETERes(QueryP, QueryV,serviceURL,statusCode);
		
		System.out.println("authorId : " + authorId + " is deleted");
	}
	
	
	@Then("^Get the book details using Author id$")
	public void Get_the_book_details_Author_id() {
		
		String serviceURL = "/books/booksauthor";
		int statusCode = 200;
		String QueryP = "authorId";
		int QueryV = Aid;
		
		response = Util.GETRes(QueryP, QueryV,serviceURL,statusCode);
	//.assertThat().body("authorId",equalTo(Aid) )
		System.out.println("authorId is verfied with authorId :" + Aid);

	}
	
	
	@Then("^Create Customer entry with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void create_Customer_entry_with(String Name, String address, String country)  {

		Object[] Key = {"name","address","country"};
		Object[] Value = {Name,address,country};

		String serviceURL = "/customers/customer";
		int statusCode = 200;

		response = Util.POSTRes(Key, Value,serviceURL,statusCode);

		String Res = response.asString();
		JsonPath jp=new JsonPath(Res);
		customerId=jp.getInt("customerId");
        System.out.println("customer Id created : "+customerId);
		
	}
		
	@Then("^Create Booking using bookID and CustomerID$")
	public void create_Booking_using_bookID_and_CustomerID()  {

		Object[] Key = {"bookId","customerId"};
		Object[] Value = {Bookid,customerId};
		
		String serviceURL = "/bookings/booking";
		int statusCode = 200;

		response = Util.POSTRes(Key, Value,serviceURL,statusCode);
		
		String Res = response.asString();
		JsonPath jp=new JsonPath(Res);
		bookingId=jp.getInt("bookingId");
        System.out.println("booking Id created : "+bookingId);
      	
	}
	
	@Then("^Save Billing entry with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void Save_Billing_entry_with(String billingAddress, String bookingCost, String zipzode,String state)  {

		Object[] Key = {"bookingId","customerId","billingAddress","bookingCost","zipzode","state"};
		Object[] Value = {bookingId,customerId,billingAddress,bookingCost,zipzode,state};

		String serviceURL = "/billings/billing";
		int statusCode = 200;

		response = Util.POSTRes(Key, Value,serviceURL,statusCode);
		
		String Res = response.asString();
		JsonPath jp=new JsonPath(Res);
		billingId=jp.getInt("billingId");
        System.out.println("billing Id created : "+billingId);
		
	}
	
	@Then("^Find Number of Books hold by customer using CustomerID$")
	public void Find_Number_of_Books_hold_by_customer_using_CustomerID()  {

		String serviceURL = "/bookings/customer";
		int statusCode = 200;
		String QueryP = "customerId";
		int QueryV = customerId;
		
		response = Util.GETRes(QueryP, QueryV,serviceURL,statusCode);
	
		String Res = response.asString();
		System.out.println("Number of Books hold by customer : "+Res);
      	
	}
	
}