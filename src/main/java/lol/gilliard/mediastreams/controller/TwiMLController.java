package lol.gilliard.mediastreams.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class TwiMLController {

    /**
     * This handles the Webhook request from Twilio
     *
     * @param uriInfo Injected by Spring, this allows us to get the current hostname, which we use in the WebSocket URL
     * @return TwiML using Media Streams
     */
    @GetMapping(value = "/twiml", produces = "application/xml")
    @ResponseBody
    public String getStreamsTwiml(UriComponentsBuilder uriInfo){
        String currentHost = uriInfo.build().getHost();
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<Response>\n" +
            "    <Say>Start talking and see the transcriptions in your console.</Say>\n" +
            "    <Start>\n" +
            "        <Stream url=\"wss://" + currentHost + "/messages\"></Stream>\n" +
            "    </Start>\n" +
            "    <Pause length=\"30\"/>\n" +
            "</Response>";
    }


}
