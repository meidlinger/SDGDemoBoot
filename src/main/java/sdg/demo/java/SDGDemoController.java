package sdg.demo.java;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class SDGDemoController {
	MysqlCon myconn;
	public SDGDemoController() {
		myconn = new MysqlCon();
	}
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	@GetMapping("/v1/api/sdg/demo/person/checktitle")
	public String getEmployeeTitle(@RequestParam(name = "name") String name) {
		Employee emp = new Employee();
        String title = emp.searchTitleByName(name);
		return title;
	}
	@GetMapping("/v1/api/sdg/demo/person/alltitles")
	public String[] getEmployeeTitle() {
		
		return myconn.getAllTitles();
	}

	
}
