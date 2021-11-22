package com.example.demo.vulnirablecomponent;


import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringUtils;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VulnerableComponents  {

    @PostMapping("/VulnerableComponents/attack1")
    public @ResponseBody
    String completed(@RequestParam String payload) {
        XStream xstream = new XStream();
        xstream.setClassLoader(Contact.class.getClassLoader());
        xstream.alias("contact", ContactImpl.class);
        xstream.ignoreUnknownElements();
        Contact contact = null;
        
        try {
        	if (!StringUtils.isEmpty(payload)) {
        		payload = payload.replace("+", "").replace("\r", "").replace("\n", "").replace("> ", ">").replace(" <", "<");
        	}
            contact = (Contact) xstream.fromXML(payload);
        } catch (Exception ex) {
            return "failed  vulnerable-components.close" + ex.getMessage();
        }
        
        try {
            if (null!=contact) {
            	contact.getFirstName();//trigger the example like https://x-stream.github.io/CVE-2013-7285.html
            } 
            if (!(contact instanceof ContactImpl)) {
            	return "success vulnerable-components.success";
            }
        } catch (Exception e) {
        	return "success   vulnerable-components.success" + e.getMessage();
        }
        return "failed  vulnerable-components.fromXML";
    }
}
