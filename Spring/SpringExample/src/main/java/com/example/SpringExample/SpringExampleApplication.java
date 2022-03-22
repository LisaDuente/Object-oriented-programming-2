package com.example.SpringExample;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringExampleApplication {
	//add all the JDBC and MYSQL dependencies before you do this
	//you can find them on the spring initalizer website
	//open the properties file and add the URL, username and password


	@Autowired
	UserService userService;

	public static void main(String[] args) {
		//tell the program in which context it is in
		ApplicationContext context = SpringApplication.run(SpringExampleApplication.class, args);
		//declare that this service is a bean object that is connected to the UserService class
		//a bean is some specific kind of spring object
		UserService userService = context.getBean(UserService.class);
		//User user = new User("Janina", "Jane");
		//userService.insertUser(user);
		//User user2 = userService.downloadUser("Janina");
		//System.out.println(user2.toString());
		User user3 = new User("123", "Jane");
		User user4 = new User("456", "Jane");
		User user5 = new User("789", "Jane");
		List<User> userList = new ArrayList<>();
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		//userService.insertNewUsers(userList);

		System.out.println(user3);

		//to use a JSON file create a parser
		Gson gson = new Gson();

		//convert a user to a JSON string
		String userAsString = gson.toJson(user3);
		System.out.println(userAsString);

		//convert from string to JSON object, use your string, then what kind of class
		User newUser = gson.fromJson(userAsString,User.class);
		System.out.println(newUser.toString());

		//object to JSON array
		String jsonArrayAsString = gson.toJson(userList);
		System.out.println(jsonArrayAsString);

		//JSON array to object/list
		User[] userArrayJson = gson.fromJson(jsonArrayAsString,User[].class);
		System.out.println(Arrays.toString(userArrayJson));
		//now we have an array with User objects, cast this into a list
		List<User> userListJson = Arrays.asList(userArrayJson);

		//or write:
		//List<User> userList = Arrays.asList(gson.fromJson(jsonArrayAsString,User[].class));
		System.out.println(userListJson);
		//this is an abstract list now but we want to parse it to an ArrayList to add something
		ArrayList<User> test = new ArrayList<>(userListJson);
		//test.add(new User("Agneta","Lisa"));
		System.out.println(test);

		//cast the string to a json object, get out values
		//use the key because its always about key value pairs
		JsonObject jsonObject = gson.fromJson(userAsString,JsonObject.class);
		String id = jsonObject.get("ID").getAsString();
		System.out.println(id);

	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World")String name){
		return "Hello " + name + "!";
	}

	@GetMapping("/calculate")
	public String calculate(@RequestParam(value = "num1", defaultValue = "0")int num1,@RequestParam(value = "num2", defaultValue = "0") int num2){
		int sum = num1+num2;
		return num1 + " + " + num2 + " equals " + sum;
	}

}
