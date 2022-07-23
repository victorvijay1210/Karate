Feature: Demo Test

Scenario: json reader parser

* def jsonObject = 
"""
[
{
"name": "manish",
 "job": "QA",
 "salary": "100000"

},
{
"name": "Vijay",
 "job": "senior software engineer",
 "salary": "70000"

},

]

"""
* print jsonObject
* print jsonObject [0].salary


Scenario: complex json reader

* def jsonObject =
"""
{
"menu": {
  "id": "file",
  "value": "File",
  "popup": {
    "menuitem": [
      {"value": "New", "onclick": "CreateNewDoc()"},
      {"value": "Open", "onclick": "OpenDoc()"},
      {"value": "Close", "onclick": "CloseDoc()"}
    ]
  }
}
}

"""
* print jsonObject.menu.popup





