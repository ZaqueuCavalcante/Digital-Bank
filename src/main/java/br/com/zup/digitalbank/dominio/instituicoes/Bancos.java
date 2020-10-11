package br.com.zup.digitalbank.dominio.instituicoes;

public enum Bancos {

    BB(001),
    BRADESCO(237),
    CAIXA(104),
    ITAU(341),
    SANTANDER(033);

    private final int codigo;

    Bancos(int codigo) {
        this.codigo = codigo;
    }

    public int codigo() {
        return codigo;
    }

    public static Bancos nome(int codigo) {
        for (Bancos nome : Bancos.values()) {
            if (nome.codigo() == codigo) {
                return nome;
            }
        }
        throw new IllegalArgumentException("Código de banco inválido.");
    }

}
