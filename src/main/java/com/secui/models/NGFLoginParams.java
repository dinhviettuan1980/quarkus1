package com.secui.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ext_clnt_id", "ext_clnt_secret", "lang"})
public class NGFLoginParams {
    public String ext_clnt_id;
    public String ext_clnt_secret;
    public String lang;
    public int force;
}
