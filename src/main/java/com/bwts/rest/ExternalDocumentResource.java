package com.bwts.rest;

import com.bwts.service.DocumentsService;
import com.bwts.model.DocumentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/documents")
public class ExternalDocumentResource {


    @Value("${access.token.enabled}") private boolean tokenEnabled;

    //private final KafkaMessageProducer messageProducer;

    private final String invoiceTopic;

    private DocumentsService documentsService;

    @Autowired
    public ExternalDocumentResource(DocumentsService documentsService,
                                    //KafkaMessageProducer producer,
                                    @Value("${consumer.invoice.topic}") String topic) {
        this.documentsService = documentsService;
        //this.messageProducer = producer;
        this.invoiceTopic = topic;
    }

    @GET
    @Path("getDocumentById/{id}")
    public Response getDocumentById(@PathParam("id") Long id) {
        DocumentModel documentModel = documentsService.getDocumentById(id);
        Map map = new HashMap();
        map.put("documentModel", documentModel);
        //return Response.ok(map).build();
        return Response.status(Response.Status.CREATED).build();
    }


}
