package rest.controllers;

import models.Person;
import play.mvc.BodyParser;
import play.mvc.Result;
import rest.factory.BaseController;
import rest.requestdto.UsersRequestDto;
import rest.responsedto.UsersResponseDto;
import services.service.ServicesFactory;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * The main set of web services.
 */
@Named
@Singleton
public class Application extends BaseController {

    //private final PersonRepository personRepository;

    // We are using constructor injection to receive a repository to support our desire for immutability.
   /* @Inject
    public Application(final PersonRepository personRepository, final ServicesFactory servicesFactory) {
        this.personRepository = personRepository;
        this.servicesFactory = servicesFactory;
    }*/
    
	@Resource
    private ServicesFactory servicesFactory;

	
	@BodyParser.Of(BodyParser.Json.class)
    public Result index() {

        // For fun we save a new person and then find that one we've just saved. The id is auto generated by
        // the db so we know that we're round-tripping to the db and back in order to demonstrate something
        // interesting. Spring Data takes care of transactional concerns and the following code is all
        // executed on the same thread (a requirement of the JPA entity manager).

        final Person person = new Person();
        person.firstname = "Bruce";
        person.surname = "Smith";

        /*final Person savedPerson = personRepository.save(person);

        final Person retrievedPerson = personRepository.findOne(savedPerson.id);*/
        
        final Person savedPerson = servicesFactory.personService.savePerson(person);

        final Person retrievedPerson = servicesFactory.personService.findOnePerson(savedPerson.id);

        // Deliver the index page with a message showing the id that was generated.
        UsersRequestDto request = new UsersRequestDto();
        request.userType = "USER";
        try {
        	/*AUser user = servicesFactory.usersService.createAUser("GUEST");
            AUser onotherUser = servicesFactory.usersService.findUserById(user.userId);*/
            return ok(views.html.index.render("Found id: " + retrievedPerson.id + " new Id: /*+ onotherUser.userId + */ of person/people Addeed text"));
        } catch(Exception ex) {
        	
        }
        return ok(views.html.index.render("of person/people Addeed text"));
        
    }
    
    
    public Result persons() {
    	
    	List<UsersResponseDto> response = null;
    	try {
	    	List<Person> users = servicesFactory.personService.persons();
	    	
	    	response = new ArrayList<>();
	    	for(Person user : users) {
	    		UsersResponseDto aUserResponse = new UsersResponseDto(user.id, user.firstname, null);
	    		response.add(aUserResponse);
	    	}
	    	
    	} catch (Exception ex) {
    		
    	}
    	return convertObjectToJsonResponse(response);
    }
}