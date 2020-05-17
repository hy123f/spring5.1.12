package mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AaController {
	
	@GetMapping("test.do")
	public void test() {
		System.out.println("Ö´ÐÐ l");
	}
}
