package todomanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import todomanager.domain.Task;
import todomanager.service.TaskService;

import java.util.Map;

@Controller
public class TaskController{

    @Autowired
    private TaskService taskService;
    @Transactional
    @RequestMapping("/index")
    public String listTasks(Map<String, Object> map){

        map.put("task", new Task());
        map.put("taskList", taskService.listTask());

        return "task";

    }
    @RequestMapping("/")
    public String home(){

        return "redirect:/index";

    }

    @RequestMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable("taskId") int taskId){
        taskService.deleteTask(taskId);
        return "redirect:/index";
    }
}

