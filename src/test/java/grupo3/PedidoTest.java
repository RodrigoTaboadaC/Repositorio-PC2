package grupo3;

import base.Pedido;
import modelo.Producto;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void testCantidadInvalida(){
        Pedido pedido = new Pedido();
        Producto laptop = new Producto( "Laptop", 1000.00, -5,"LPT0001", "Tecnología", true, false);
        pedido.getDetallesPedido().add(laptop);

        IllegalStateException ex = assertThrows(IllegalStateException.class, pedido::validarStock);
        assertEquals("Error: hay un producto con cantidad negativa", ex.getMessage());
    }

    @Test
    void cantidadNoValidaTest() {
        Pedido pedido = new Pedido();
        Producto producto = new Producto("PC", 1000.00, 5, "LPT0001", "Tecnología", true, false);
        boolean resultado = pedido.agregarProducto(producto, -2);
        assertFalse(resultado, "Debe devolver false por cantidad negativa");
    }

    @Test
    void productoDuplicadoTest() {
        Pedido pedido = new Pedido();
        Producto p1 = new Producto("PC", 1000.00, 5, "LPT0001", "Tecnología", true, false);
        Producto p2 = new Producto("PC", 1000.00, 5, "LPT0001", "Tecnología", true, false);

        boolean producto1 = pedido.agregarProducto(p1, 2);
        boolean producto2 = pedido.agregarProducto(p2, 2);
        assertFalse(producto2);
    }


}
