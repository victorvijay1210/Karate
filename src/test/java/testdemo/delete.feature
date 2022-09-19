Feature: Delete user with given API

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
	#delete
Scenario: Create user with the given userid
#create user
Given path '/public/v1/users'	
And request requestPayload
And header Authorization = 'Bearer ' + tokenID
When method post
Then status 201
And match $.data.id == '#present'
And match $.data.name == '#present'
And match $.data.name == 'graciya'
And match $.data.email == requestPayload.email

#fetch user id
* def userid = $.data.id
* print userid

#delete user
Given path '/public/v1/users' + userid
And header Authorization = 'Bearer ' + tokenID
When method delete
Then status 404

#get the same user with userid
Given url baseUrl+'/public/v2/users' + userid
When method GET
Then status 404

