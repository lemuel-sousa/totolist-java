# totolist-java
Easily create tasks with this CURD API to-do list made in java and Spring boot web

This API allows you to create tasks, edit information, search by id, delete, change status and search tasks based on status (completed or pending).

## Make an http request

* Create an task [POST]: to create a new task use the '/api/tasks' route. Insert the following parameters in the json body
```json
{
		"title": "Clean the bedroom",
		"description": "",
		"deadLine": "2023-04-28T07:00:00",
		"status": "COMPLETED"
}
```

* Get all tasks [GET]: to list all tasks use the '/api/tasks'.
  <br>json response example:
```json
	{
		"id": 17,
		"title": "Clean the bedroom",
		"description": "",
		"deadLine": "2023-04-26T07:00:00",
		"status": "COMPLETED",
		"createdAt": "2023-04-26T14:18:02.752861",
		"updatedAt": "2023-04-26T14:21:19.957202"
	}
 ```
 
 * Update an task [PUT]
 <br>Make the request in the "/api/tasks/{id}" by inserting the id of the desired task.
 Inform in the json body only the parameters "title, description, deadLine and status".
 
   Updating status
 ```json
	{
		"title": "Clean the bedroom",
		"description": "",
		"deadLine": "2023-04-26T07:00:00",
		"status": "PENDING",
	}
 ```
 
  * DELETE an task [DELETE]
 <br>Make the request in the "/api/tasks/{id}" by inserting the id of the task to be removed.
     The request must return the status "204 No content".
 
 
