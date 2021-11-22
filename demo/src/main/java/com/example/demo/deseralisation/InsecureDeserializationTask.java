package com.example.demo.deseralisation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.util.Base64;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsecureDeserializationTask {
	
	
    @PostMapping("/InsecureDeserialization/task")
    @ResponseBody
    public String completed(@RequestParam String token) throws IOException {
        String b64token;
        long before;
        long after;
        int delay;

        b64token = token.replace('-', '+').replace('_', '/');

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(b64token)))) {
            before = System.currentTimeMillis();
            Object o = ois.readObject();
            if (!(o instanceof VulnerableTaskHolder)) {
                if (o instanceof String) {
                    return "failed insecure-deserialization.stringobject";
                }
                return "failed  insecure-deserialization.wrongobject";
            }
            after = System.currentTimeMillis();
        } catch (InvalidClassException e) {
            return "failed insecure-deserialization.invalidversion";
        } catch (IllegalArgumentException e) {
            return "failed insecure-deserialization.expired";
        } catch (Exception e) {
            return "failed  insecure-deserialization.invalidversion";
        }

        delay = (int) (after - before);
        if (delay > 7000) {
            return "failed";
        }
        if (delay < 3000) {
            return "failed";
        }
        return "success";
    }
}


