package br.com.zup.digitalbank.dominio.contas.atributos;

public enum Tipo {

    CORRENTE_PF("001"),
    POUPANCA_PF("011"),
    CORRENTE_PJ("003"),
    POUPANCA_PJ("013"),
    INVESTIMENTO("042");

    private final String codigo;

    Tipo(String codigo) {
        this.codigo = codigo;
    }

    public String codigo() {
        return codigo;
    }

    public static Tipo nome(String codigo) {
        for (Tipo nome : Tipo.values()) {
            if (nome.codigo().equals(codigo)) {
                return nome;
            }
        }
        throw new IllegalArgumentException("Código de tipo de conta inválido.");
    }

}
