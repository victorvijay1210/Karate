Feature: Create user using post api

Background:
	* url 'https://gorest.co.in'
	* def requestPayload = 
	"""
	{
        
        "gender": "male"
    }
	
	"""
Scenario: Update a user with the given data
Given path '/public/v2/users/2597'
And request requestPayload
And header Authorization = 'Bearer ' + tokenID
When method put
Then status 200
And match $.data.name == '#present'
And match $.data.name == 'Eshana Johar'
And match $.data.email == 'johar_eshana@carter-ratke.net'

