package hello.controllers;

import hello.models.*;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;



@RestController
public class ClientController{
	private List<Client> clients = new ArrayList<Client>();

	ClientController(){
		Client p1 = new Client(1,10,15867,"Bill");
		Client p2 = new Client(2,20,20035,"John");
		Client p3 = new Client(3,15,20356,"Ted");
		Client p4 = new Client(4,12,20154,"Thomas");

		clients.add(p1);
		clients.add(p2);
		clients.add(p3);
		clients.add(p4);
	}

	@RequestMapping(value="/client",method = RequestMethod.GET)
	public List<Client> index(){
		return this.clients;
	}

	
	@RequestMapping(value="/client/{id}",method = RequestMethod.GET)
	public ResponseEntity show(@PathVariable("id") int id){
		for(Client p : this.clients){
			if(p.getId() == id){
				return new ResponseEntity<Client>(p,new HttpHeaders(),HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}

	
	@RequestMapping(value="/client/", method = RequestMethod.POST)
	  public ResponseEntity create() {

	Client p = new Client(5,10,31,"John");
	 	this.clients.add(p);
	        return new ResponseEntity<Client>(p, new HttpHeaders(), HttpStatus.OK);
	    

	 }


	  @RequestMapping(value="/client/{id}", method = RequestMethod.PUT)
	  public ResponseEntity update(@PathVariable("id") int id) {
	    for(Client p : this.clients) { 
	      if(p.getId() == id) { p.setName("Andrew");
	        return new ResponseEntity<Client>(p, new HttpHeaders(), HttpStatus.OK);
	      	}
	    }
	    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	 }



	@RequestMapping(value="/client/{id}",method = RequestMethod.DELETE)
	public ResponseEntity remove(@PathVariable("id") int id){
		for(Client p : this.clients){
			if(p.getId() == id){
				this.clients.remove(p);
				return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}


}