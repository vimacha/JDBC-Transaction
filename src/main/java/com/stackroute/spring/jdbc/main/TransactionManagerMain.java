package com.stackroute.spring.jdbc.main;

import com.stackroute.spring.jdbc.model.Actor;
import com.stackroute.spring.jdbc.model.Movie;
import com.stackroute.spring.jdbc.service.MovieManagerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stackroute.spring.jdbc.service.MovieManager;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		ctx.refresh();
		MovieManager movieManager = ctx.getBean("movieManager",
				MovieManagerImpl.class);

		Movie cust = createDummyCustomer();
		movieManager.createCustomer(cust);

		ctx.close();
	}

	private static Movie createDummyCustomer() {
		Movie movie = new Movie();
		movie.setMovie_Id(1);
		movie.setMovie_name("Darling");
		movie.setReleaseYear(2018);
		movie.setRating((float) 9.7);



		Actor actor = new Actor();
		//actor.setMovie_Id(1);
		actor.setLeadActor("Prabhas");
		actor.setLeadActress("Kajal");
		actor.setMovie_Id(movie.getMovie_Id());
		movie.setActor(actor);

		return movie;
	}

}
