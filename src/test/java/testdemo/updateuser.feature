Feature: Create user using post and put api

Background:
	* url 'https://gorest.co.in'
	* def requestPayload = read('classpath:src/test/resources/payload/user.json')
	
	* def random_string = 
	"""
		function(s){
			var text = "";
			var pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			for(var i=0; i<s; i++)
				text += pattern.charAt(Math.floor(Math.random() * pattern.length()));
				return text;
		}
	"""
	* def randomString = random_string(10)
	* print randomString
	
	
	  * requestPayload.email = randomString + "@gmail.com"
	  * set requestPayload.email = randomString + "@gmail.com"
	  
    * print requestPayload
	#post
Scenario: Create and update a user with the given data
Given path '/public/v1/users'	
And request requestPayload
And header Authorization = 'Bearer ' + tokenID
When method post
Then status 201
And match $.data.id == '#present'
And match $.data.name == '#present'
And match $.data.name == 'rahul'
And match $.data.email == requestPayload.email

#fetch user id from post call
* def userID = $.data.id
* print userID




	#put

	* def requestputPayload = 
	"""
	{
        
        "status": "inactive"
    }
	
	"""

Given path '/public/v2/users/'+userID
And request requestputPayload
And header Authorization = 'Bearer ' + tokenID
When method put
Then status 200
And match $.data.name == '#present'
And match $.data.name == 'rahul'
And match $.data.email == requestPayload.email