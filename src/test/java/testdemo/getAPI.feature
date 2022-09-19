@karatedemo_testcases
Feature: GET API Test


#Scenario: get user details
#Given url baseUrl+'/public/v2/users'
#And path '9'
#When method GET
#Then status 200
#* print response
#* def jsonResponse = response
#* print jsonResponse
#* def name = jsonResponse.name
#* print name
#* def gender = jsonResponse.gender
#* print gender
#* match name == 'Ananta Khatri'
#* match gender == 'female'

@karatedemo2
Scenario: get user not found details
Given url baseUrl+'/public/v2/users'
And path '1'
When method GET
Then status 404