package com.example.demo.injection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlInject {

	@PostMapping("XmlAttack1")
	public String xml(@RequestParam String cc)
	{
        StringBuffer output = new StringBuffer();

        output.append(cc);
        return output.toString();
	}
}
