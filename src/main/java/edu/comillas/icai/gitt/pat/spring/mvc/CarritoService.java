package edu.comillas.icai.gitt.pat.spring.mvc;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarritoService {

    private final Map<Long, ModeloCarrito> carritos = new HashMap<>();
    private Long contadorId = 1L;

    public List<ModeloCarrito> obtenerTodos() {
        return new ArrayList<>(carritos.values());
    }

    public Optional<ModeloCarrito> obtenerPorId(Long id) {
        return Optional.ofNullable(carritos.get(id));
    }

    public ModeloCarrito crear(ModeloCarrito carrito) {
        carrito.setIdCarrito(contadorId++);
        carritos.put(carrito.getIdCarrito(), carrito);
        return carrito;
    }

    public Optional<ModeloCarrito> actualizar(Long id, ModeloCarrito carritoActualizado) {
        if (!carritos.containsKey(id)) {
            return Optional.empty();
        }
        carritoActualizado.setIdCarrito(id);
        carritos.put(id, carritoActualizado);
        return Optional.of(carritoActualizado);
    }

    public boolean eliminar(Long id) {
        return carritos.remove(id) != null;
    }
}
