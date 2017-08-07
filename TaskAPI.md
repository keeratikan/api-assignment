# View all tasks

    View all items in the list

* **URL**

  /task/

* **Method**
  
  GET

* **URL Params**

  None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 
  
    **Content:** { id : 1, Subject : Task One, Detail : Detail of Task One, Status : Pending }

* **Error Response:**

  * **Code:** 204 No Content 
  
    **Content:** { error : "No task list" }

* **Sample Call:**

  ```javascript
  $.ajax({
    url: "/task/",
    dataType: "json",
    type : "GET",
    success : function(r) {
      console.log(r);
    }
  });
  ```
  
# View task

    View a single task in the list

* **URL**

  /task/:id

* **Method**
  
  GET

* **URL Params**

  **Required:**

  id=[integer]

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 
  
    **Content:** { id : 1, Subject : Task One, Detail : Detail of Task One, Status : Pending }

* **Error Response:**

  * **Code:** 404 Not Found
  
    **Content:** { error : "Task with id not found." }

* **Sample Call:**

  ```javascript
  $.ajax({
    url: "/task/1",
    dataType: "json",
    type : "GET",
    success : function(r) {
      console.log(r);
    }
  });
  ```
# Add a task

    Add a task to the list

* **URL**

  /task/

* **Method**
  
  POST

* **URL Params**

  **Required:**

  id=[integer]

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 
  
    **Content:** { id : 1, Subject : Task One, Detail : Detail of Task One, Status : Pending }

* **Error Response:**

  * **Code:** 404 Not Found
  
    **Content:** { error : "Task with id not found." }

* **Sample Call:**

  ```javascript
  $.ajax({
    url: "/task/1",
    dataType: "json",
    type : "GET",
    success : function(r) {
      console.log(r);
    }
  });
  ```
