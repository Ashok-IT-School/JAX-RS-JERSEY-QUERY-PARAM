package com.himalaya.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/book")
public class BookResource {

	@GET
	@Path("/isbn")
	public String findPriceByIsbn(@QueryParam("isbn") String isbn) {
		System.out.println("BookResource :: findPriceByIsbn called");

		System.out.println("ISBN :: " + isbn);

		String responseMsg = "Book Price is $300.00";

		return responseMsg;
	}

	@GET
	public String findPriceByNameAndAuthorName(@QueryParam("bname") String bname, @QueryParam("aname") String aname) {

		System.out.println("findPriceByNameAndAuthorName() called");

		System.out.println("Book Name :: " + bname);

		System.out.println("Author Name:: " + aname);

		String responseMsg = "Book Price is $500.00";

		return responseMsg;
	}

	@GET
	@Path("/isbns")
	public String findByIsbns(@Context UriInfo uriInfo) {
		System.out.println("BookResource :: findByIsbns() method called");

		List<String> isbns = uriInfo.getQueryParameters().get("isbn");

		System.out.println("Isbns :: " + isbns);

		List<String> bids = uriInfo.getQueryParameters().get("bid");

		System.out.println("Book IDs : " + bids);
		String responseMsg = "Book Price is $1800.00";

		return responseMsg;
	}

}
