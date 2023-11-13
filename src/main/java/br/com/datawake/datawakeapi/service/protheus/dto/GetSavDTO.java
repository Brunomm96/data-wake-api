package br.com.datawake.datawakeapi.service.protheus.dto;

import java.util.Collections;
import java.util.List;

public class GetSavDTO {
    private List<ProtheusSavDTO> itens = Collections.emptyList();

//    GETTERS AND SETTERS

    public List<ProtheusSavDTO> getItens() {
        return itens;
    }

    public void setItens(List<ProtheusSavDTO> itens) {
        this.itens = itens;
    }
}
