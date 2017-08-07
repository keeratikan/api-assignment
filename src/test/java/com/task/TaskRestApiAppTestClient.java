package com.task;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import com.task.model.Task;

public class TaskRestApiAppTestClient 
{

	public static final String REST_SERVICE_URI = "http://localhost:8080/TaskRestApi/api";
    
	/* GET */
    @SuppressWarnings("unchecked")
    private static void listAllTasks(){
        System.out.println("----------listAllTask API Testing----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> tasksMap = restTemplate.getForObject(REST_SERVICE_URI+"/task/", List.class);
         
        if(tasksMap!=null){
            for(LinkedHashMap<String, Object> map : tasksMap){
                System.out.println("Task : id="+map.get("id")+", Subject="+map.get("subject")+", Detail="+map.get("detail")+", Status="+map.get("status"));
            }
        }else{
            System.out.println("----------No task exist----------");
        }
    }
    
    /* GET */
    private static void getTask(){
        System.out.println("----------Get Task API Testing----------");
        RestTemplate restTemplate = new RestTemplate();
        Task task = restTemplate.getForObject(REST_SERVICE_URI+"/task/1", Task.class);
        System.out.println(task);
    }
     
    /* POST */
    private static void addTask() {
        System.out.println("----------Add Task API Testing----------");
        RestTemplate restTemplate = new RestTemplate();
        Task task = new Task(0,"Task Five","Detail of Task Five", "Pending");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/task/", task, Task.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
    
    /* PUT */
    private static void editTask() {
        System.out.println("----------Edit Task API Testing----------");
        RestTemplate restTemplate = new RestTemplate();
        Task task  = new Task(1,"Task One One","Detail of Task One One", "Done");
        restTemplate.put(REST_SERVICE_URI+"/task/1", task);
        System.out.println(task);
    }
    
    /* PUT */
    private static void editTaskStatus() {
        System.out.println("----------Edit Task Status API Testing----------");
        RestTemplate restTemplate = new RestTemplate();
        Task task = restTemplate.getForObject(REST_SERVICE_URI+"/task/4", Task.class);
        task.setStatus("Done");
        restTemplate.put(REST_SERVICE_URI+"/task/4", task);
        System.out.println(task);
    }
 
    /* DELETE */
    private static void deleteTask() {
        System.out.println("----------Delete Task API Testing----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/task/3");
    }
    
    public static void main(String args[]){
        listAllTasks();
        getTask();
        listAllTasks();
        addTask();
        listAllTasks();
        editTask();
        listAllTasks();
        editTaskStatus();
        listAllTasks();
        deleteTask();
        listAllTasks();
    }
}
