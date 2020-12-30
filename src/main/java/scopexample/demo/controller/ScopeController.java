package scopexample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import scopexample.demo.component.PrototypeScopeComponent;
import scopexample.demo.component.RequestScopeComponent;
import scopexample.demo.component.SessionScopeComponent;
import scopexample.demo.component.SingletonScopeComponent;

@RestController
public class ScopeController {
    @Autowired
    private SingletonScopeComponent singletonScopeComponent;

    @Autowired
    private PrototypeScopeComponent prototypeScopeComponent;

    @Autowired
    private RequestScopeComponent requestScopeComponent;

    @Autowired
    private SessionScopeComponent sessionScopeComponent;

    @GetMapping("/session")
    public long getSessionScopeData(){
        sessionScopeComponent.printInstanceInfo();
        return System.identityHashCode(sessionScopeComponent);
    }

    @GetMapping("/request")
    public long getRequestScopeData(){
        requestScopeComponent.printInstanceInfo();
        return System.identityHashCode(requestScopeComponent);
    }

    @GetMapping("/singleton")
    public long getSingletonScopeData(){
        singletonScopeComponent.printInstanceInfo();
        return System.identityHashCode(singletonScopeComponent);
    }

    @GetMapping("/prototype")
    public long getPrototypeScopeData(){
        prototypeScopeComponent.printInstanceInfo();
        return System.identityHashCode(prototypeScopeComponent);
    }
}
