package com.francisco.estudo.model.enuns;

public enum PerfilEnum {

    ADMIN (1, "ROLE_ADMINISTRADOR"),
    USER (1, "ROLE_USUARIO");

    private int cod;
    private String descricao;

    private PerfilEnum(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome(){
        return getDescricao().substring(5);
    }

    public static PerfilEnum toEnum(Integer cod) {
        for(PerfilEnum e : PerfilEnum.values()) {
            if(e.getCod() == cod) {
                return e;
            }
        }
        return null;
    }
}
