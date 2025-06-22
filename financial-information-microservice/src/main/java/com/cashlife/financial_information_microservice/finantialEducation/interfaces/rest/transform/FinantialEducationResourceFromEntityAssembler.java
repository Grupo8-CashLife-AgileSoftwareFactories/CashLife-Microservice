package com.cashlife.financial_information_microservice.finantialEducation.interfaces.rest.transform;

import com.cashlife.financial_information_microservice.finantialEducation.domain.model.aggregates.FinantialEducation;
import com.cashlife.financial_information_microservice.finantialEducation.interfaces.rest.resources.FinantialEducationResource;
import com.cashlife.financial_information_microservice.finantialEducation.interfaces.rest.resources.PreguntaResource;
import com.cashlife.financial_information_microservice.finantialEducation.interfaces.rest.resources.RespuestaResource;
import org.springframework.stereotype.Component;

@Component
public class FinantialEducationResourceFromEntityAssembler {

    public FinantialEducationResource toResource(FinantialEducation entity) {
        FinantialEducationResource resource = new FinantialEducationResource();
        resource.setId(entity.getId());
        resource.setTitulo(entity.getTitulo());

        PreguntaResource preguntaResource = new PreguntaResource();
        preguntaResource.setId(entity.getPregunta().getId());
        preguntaResource.setTexto(entity.getPregunta().getTexto());
        resource.setPregunta(preguntaResource);

        RespuestaResource respuestaResource = new RespuestaResource();
        respuestaResource.setId(entity.getRespuesta().getId());
        respuestaResource.setTexto(entity.getRespuesta().getTexto());
        resource.setRespuesta(respuestaResource);

        return resource;
    }
}
