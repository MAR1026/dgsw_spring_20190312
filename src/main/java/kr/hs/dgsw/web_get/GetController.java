package kr.hs.dgsw.web_get;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam String say,
            @RequestParam(required = false, defaultValue = "NONAME") String to) {
        return say + " " + to;
    }

    @GetMapping(value = {
            "/greeting1/{say}/{to}",
            "/greeting1/{say}",
            "/greeting1//{to}",
            "/greeting1"})
    public String greeting1(@PathVariable Optional<String> say, @PathVariable Optional<String> to) {

        String sayTmp = say.isPresent() ? say.get() : "메롱";
        String toTmp = to.isPresent() ? to.get() : "NONAME";
        return sayTmp + " " + toTmp;
    }
}