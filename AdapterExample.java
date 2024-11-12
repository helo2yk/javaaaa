// Interface de Pagamento comum
public interface Pagamento {
    void pagar(double valor);
}

// Adapters para adaptar as APIs externas ao padrão esperado pelo sistema
public class PaypalAdapter implements Pagamento {
    private PaypalAPI paypal;

    public PaypalAdapter(PaypalAPI paypal) {
        this.paypal = paypal;
    }

    @Override
    public void pagar(double valor) {
        paypal.realizarPagamentoPaypal(valor);
    }
}

public class StripeAdapter implements Pagamento {
    private StripeAPI stripe;

    public StripeAdapter(StripeAPI stripe) {
        this.stripe = stripe;
    }

    @Override
    public void pagar(double valor) {
        stripe.realizarPagamentoStripe(valor);
    }
}

// API simulada do Paypal
public class PaypalAPI {
    public void realizarPagamentoPaypal(double valor) {
        System.out.println("Pagamento realizado com PayPal: $" + valor);
    }
}

// API simulada do Stripe
public class StripeAPI {
    public void realizarPagamentoStripe(double valor) {
        System.out.println("Pagamento realizado com Stripe: $" + valor);
    }
}

// Uso do Adapter
public class Main {
    public static void main(String[] args) {
        Pagamento pagamentoPaypal = new PaypalAdapter(new PaypalAPI());
        Pagamento pagamentoStripe = new StripeAdapter(new StripeAPI());

        pagamentoPaypal.pagar(100.00);
        pagamentoStripe.pagar(150.00);
    }
}

