package com.example.demo.passrestriction;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BypassRestrictionsFieldRestrictions {

    @PostMapping("/BypassRestrictions/FieldRestrictions")
    @ResponseBody
    public String completed(@RequestParam String select, @RequestParam String radio, @RequestParam String checkbox, @RequestParam String shortInput, @RequestParam String readOnlyInput) {
        if (select.equals("option1") || select.equals("option2")) {
            return "failed";
        }
        if (radio.equals("option1") || radio.equals("option2")) {
            return "failed";
        }
        if (checkbox.equals("on") || checkbox.equals("off")) {
            return "failed";
        }
        if (shortInput.length() <= 5) {
            return "failed";
        }
        if ("change".equals(readOnlyInput)) {
            return "failed";
        }
        return "success";
    }
}
