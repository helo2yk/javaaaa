
import java.util.ArrayList;
import java.util.List;

// Interface Observer
public interface Observer {
    void atualizar(String mensagem);
}

// Classe observável (Subject)
public class EstoqueProduto {
    private List<Observer> observers = new ArrayList<>();
    private int quantidadeEmEstoque;

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setQuantidadeEmEstoque(int quantidade) {
        this.quantidadeEmEstoque = quantidade;
        notificarObservers();
    }

    private void notificarObservers() {
        for (Observer observer : observers) {
            observer.atualizar("Novo estoque: " + quantidadeEmEstoque);
        }
    }
}

// Observador para clientes
public class Cliente implements Observer {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Cliente " + nome + " recebeu notificação: " + mensagem);
    }
}

// Observador para gerentes
public class Gerente implements Observer {
    private String nome;

    public Gerente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Gerente " + nome + " recebeu notificação: " + mensagem);
    }
}

// Uso do Observer
public class Main {
    public static void main(String[] args) {
        EstoqueProduto estoque = new EstoqueProduto();

        Cliente cliente1 = new Cliente("Alice");
        Gerente gerente1 = new Gerente("Bob");

        estoque.adicionarObserver(cliente1);
        estoque.adicionarObserver(gerente1);

        estoque.setQuantidadeEmEstoque(20);
    }
}
