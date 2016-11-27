# book-maze-service

Url: https://peaceful-cove-43829.herokuapp.com

# Users

### POST /api/v1/users/signup

Sign up

##### Return codes:

200 - Success 
400 - Error 

Input data example:

    {
            "login": "test2",
            "password" : "test"
            "libraryId": "1",
            "firstName": "1",
            "lastName": "1",
            "birthDate": "06/06/2007"
    }

Output data example:

    {
            "login": "test2",
            "libraryId": "1",
            "firstName": "1",
            "lastName": "1",
            "birthDate": "06/06/2007"
            "roleName" : "USER"
    }
### POST /auth

Login

##### Return codes:

200 - Success 
403 - Incorrect login or password 

Input data example:

    {
        "login" : "test2",
        "password" : "test",
    }
Output data example:

    {
            "login": "test2",
            "password" : "test"
            "libraryId": "1",
            "firstName": "1",
            "lastName": "1",
            "birthDate": "06/06/2007"
            "roleName" : "USER"
    }
