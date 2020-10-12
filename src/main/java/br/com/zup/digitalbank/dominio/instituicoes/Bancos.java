package br.com.zup.digitalbank.dominio.instituicoes;

public enum Bancos {

    BB("001"),
    BRADESCO("237"),
    CAIXA("104"),
    ITAU("341"),
    SANTANDER("033");

    private final String codigo;

    Bancos(String codigo) {
        this.codigo = codigo;
    }

    public String codigo() {
        return codigo;
    }

    public static Bancos nome(String codigo) {
        for (Bancos nome : Bancos.values()) {
            if (nome.codigo().equals(codigo)) {
                return nome;
            }
        }
        throw new IllegalArgumentException("Código de banco inválido.");
    }

}
