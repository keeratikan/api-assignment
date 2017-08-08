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
  
# View a task

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

    None

* **Data Params**

    task={id: 0,subject: Task Five,detail: Detail of Task Five,status: Pending}

* **Success Response:**

  * **Code:** 201 Created
  
    **Content:** { id : 5, Subject : Task Five, Detail : Detail of Task Five, Status : Pending }

* **Error Response:**

  * **Code:** 409 Conflict
  
    **Content:** { error : "Unable to add. A task with subject already exist." }

* **Sample Call:**

  ```javascript
  $.ajax({
    url: "/task/",
    dataType: "json",
    type : "POST",
    data: "{id: 0,subject: "Task Five",detail: "Detail of Task Five",status: "Pending"}"
    success : function(r) {
      console.log(r);
    }
  });
  ```
  
  # Edit a task

    Edit existing task in the list

* **URL**

    /task/:id

* **Method**
  
    PUT

* **URL Params**

    **Required:**

    id=[integer]

* **Data Params**

    task={id: 1,subject: "Task One One",detail: "Detail of Task One One",status: "Done"}

* **Success Response:**

  * **Code:** 200 
  
    **Content:** { id : 1, Subject : Task One One, Detail : Detail of Task One One, Status : Done }

* **Error Response:**

  * **Code:** 404 Not Found
  
    **Content:** { error : "Unable to update. Task with id not found." }

* **Sample Call:**

  ```javascript
  $.ajax({
    url: "/task/1",
    dataType: "json",
    type : "PUT",
    data: "{id: 0,subject: "Task One One",detail: "Detail of Task One One",status: "Done"}"
    success : function(r) {
      console.log(r);
    }
  });
  ```
# Delete a task

    Delete a existing task in the list

* **URL**

  /task/:id

* **Method**
  
  DELETE

* **URL Params**

  **Required:**

  id=[integer]

* **Data Params**

  None

* **Success Response:**

  * **Code:** 204 No Content
  
    **Content:** { id : 1, Subject : Task One, Detail : Detail of Task One, Status : Pending }

* **Error Response:**

  * **Code:** 404 Not Found
  
    **Content:** { error : "Unable to delete. Task with id not found." }

* **Sample Call:**

  ```javascript
  $.ajax({
    url: "/task/3",
    dataType: "json",
    type : "DELETE",
    success : function(r) {
      console.log(r);
    }
  });
  ```
