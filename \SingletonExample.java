public class ConfiguracaoAplicacao {
    private static ConfiguracaoAplicacao instancia;
    private Properties propriedades;

    private ConfiguracaoAplicacao() {
        propriedades = new Properties();
        carregarConfiguracoes();
    }

    public static synchronized ConfiguracaoAplicacao getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracaoAplicacao();
        }
        return instancia;
    }

    private void carregarConfiguracoes() {
        // Simulação do carregamento das configurações de um arquivo
        propriedades.setProperty("tema", "claro");
        propriedades.setProperty("idioma", "pt-BR");
    }

    public String getPropriedade(String chave) {
        return propriedades.getProperty(chave);
    }
}

// Uso do Singleton:
public class Main {
    public static void main(String[] args) {
        ConfiguracaoAplicacao config = ConfiguracaoAplicacao.getInstancia();
        System.out.println("Tema: " + config.getPropriedade("tema"));
    }
}

