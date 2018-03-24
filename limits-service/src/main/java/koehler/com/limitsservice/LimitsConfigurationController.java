package koehler.com.limitsservice;

import koehler.com.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    @HystrixCommand(fallbackMethod="fallbackRetrieveLimitsFromConfiguration")
    public LimitConfiguration retrieveLimitsFromConfiguration() {

    	if(true)
    		throw new RuntimeException();
    	
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());

    }
    
    public LimitConfiguration fallbackRetrieveLimitsFromConfiguration() {
    	return new LimitConfiguration(9, 1);
    	
    }
    
    
}
