
package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // == private final Logger log = LoggerFactory.getLogger(LogTestController.class);
@RestController
public class LogTestController {

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        /**
         * logging에는 레벨이 존재한다
         * 나열된 순서대로 trace -> debug -> info -> warn -> error 의 내림차순의 레벨이 존재한다
         * application.properties에서 어떠한 레벨의 로그는 보고 싶은지 설정이 가능하고
         * 설정된 레벨의 로그부터 하위 레벨까지의 모든 로그가 출력된다.
         */
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        /**
         * 로깅시 주의사항
         *  log.trace("trace log={}", name);
         *  log.trace("trace log" + name);
         *  중 후자는 권장되지 않는 로깅방식이다. 로깅 레벨이 debug라는 가정하에,
         *  trace 로그는 출력이 되지 않는다 하지만 자바의 특성때문에 String간의 연산이 일어나면서
         *  불필요한 자원을 사용하게 되는것.
         */
        return "ok";
    }
}
